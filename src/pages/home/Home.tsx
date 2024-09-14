import {
  Container,
  Header,
  Title,
  SearchContainer,
  Main,
  LoginSection,
  ButtonContainer,
  NewScript,
} from "./styles";
import { Button } from "../../components/Buttons/Buttons";
import { Input } from "../../components/Input/Input";
import { useNavigate } from "react-router-dom";

const Home = () => {
  const navigate = useNavigate();

  return (
    <Container>
      <Header>
        <LoginSection>
          <ButtonContainer>
            <Button onClick={() => navigate("/login")}>Login</Button>
          </ButtonContainer>
          <NewScript>
            Ainda não tem roteiro submeteu um roteiro?{" "}
            <button>Click aqui para submeter</button>
          </NewScript>
        </LoginSection>
        <Title>Bem vindo ao cooperfime</Title>
      </Header>
      <Main>
        <SearchContainer>
          <Input
            label="Check o status do seu roteiro"
            placeholder="Você pode buscar pelo título ou pelo seu email"
          />
        </SearchContainer>
      </Main>
    </Container>
  );
};

export { Home };
