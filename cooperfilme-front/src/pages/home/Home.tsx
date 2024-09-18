import {
  Container,
  SearchContainer,
  Main,
  LoginSection,
  ButtonContainer,
  NewScript,
  CardContainer,
} from "./styles";
import { Button } from "../../components/Buttons/Buttons";
import { Input } from "../../components/Input/Input";
import { useNavigate } from "react-router-dom";
import { useEffect, useRef, useState } from "react";
import api from "../../services/api";
import { CardStatus } from "../../components/CardStatus/CardStatus";
import { Header } from "../../components/Header/Header";

interface DataProps {
  status: string;
  title: string;
}

const Home = () => {
  const navigate = useNavigate();
  const timerSearch = useRef<number | null>(null);
  const [search, setSearch] = useState<string>();
  const [value, setValue] = useState<string>();
  const [data, setData] = useState<DataProps[]>([]);

  const endAndStartTimer = (value: string) => {
    if (timerSearch.current !== null) {
      clearTimeout(timerSearch.current);
    }
    setValue(value);
    timerSearch.current = window.setTimeout(() => {
      setSearch(value);
    }, 1500);
  };

  useEffect(() => {
    setData([]);
    if (search) {
      api
        .get("/scripts/check", {
          params: {
            search,
          },
        })
        .then((response) => setData(response.data));
    }
  }, [search]);

  const renderLoading = () => {
    if (data.length > 0) {
      return (
        <>
          <p>Voĉe tem {data.length} roteiro(s) cadastrados</p>
          <>
            {data.map((item, index) => (
              <CardStatus title={item.title} status={item.status} key={index} />
            ))}
          </>
        </>
      );
    }

    return (
      <p>
        User o filtro acima para procurar roteiros cadastrados ou cadastre um
        novo roteiro
      </p>
    );
  };

  return (
    <Container>
      <Header title="Bem vindo ao cooperfilme">
        <LoginSection>
          <ButtonContainer>
            <Button onClick={() => navigate("/login")}>Login</Button>
          </ButtonContainer>
          <NewScript>
            Ainda não tem roteiro submeteu um roteiro?{" "}
            <button onClick={() => navigate("/newScript")}>
              Click aqui para submeter
            </button>
          </NewScript>
        </LoginSection>
      </Header>
      <Main>
        <SearchContainer>
          <Input
            value={value}
            onChange={(e) => endAndStartTimer(e.target.value)}
            itemRef={timerSearch}
            label="Check o status do seu roteiro"
            placeholder="Você pode buscar pelo título ou pelo seu email"
          />
        </SearchContainer>
        <CardContainer>{renderLoading()}</CardContainer>
      </Main>
    </Container>
  );
};

export { Home };
