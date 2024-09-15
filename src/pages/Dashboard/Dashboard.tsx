import { useEffect, useState } from "react";
import { Button } from "../../components/Buttons/Buttons";
import { Header } from "../../components/Header/Header";
import { Input } from "../../components/Input/Input";
import { DateInput } from "../../components/InputDate/InputDate";
import { Select } from "../../components/Select/Select";
import { Container, FilterContainer, Main } from "./styles";
import { FiSearch } from "react-icons/fi";
import api from "../../services/api";
import { CardsScripts } from "../../components/CardsScripts/CardsScripts";
import { useNavigate } from "react-router-dom";

interface Client {
  id: string;
  name: string;
  email: string;
  phone: string;
}

interface Script {
  id: string;
  title: string;
  content: string;
  status:
    | "AGUARDANDO_ANALISE"
    | "EM_ANALISE"
    | "AGUARDANDO_REVISAO"
    | "EM_REVISAO"
    | "AGUARDANDO_APROVACAO"
    | "EM_APROVACAO"
    | "APROVADO"
    | "RECUSADO"
    | "ERROR";
  client: Client;
}

const Dashboard = () => {
  const [data, setData] = useState<Script[]>([]);
  const navigate = useNavigate();

  const statusOptions = [
    { value: "aguardando_analise", label: "Aguardando Análise" },
    { value: "em_analise", label: "Em Análise" },
    { value: "aguardando_revisao", label: "Aguardando Revisão" },
    { value: "em_revisao", label: "Em Revisão" },
    { value: "aguardando_aprovacao", label: "Aguardando Aprovação" },
    { value: "em_aprovacao", label: "Em Aprovação" },
    { value: "aprovado", label: "Aprovado" },
    { value: "recusado", label: "Recusado" },
    { value: "error", label: "Erro" },
  ];

  useEffect(() => {
    api.get("/scripts").then((response) => setData(response.data));
  }, []);

  return (
    <Container>
      <Header title="Lista de roteiros" />
      <FilterContainer>
        <Select name="status" label="Status" options={statusOptions} />
        <Input name="email" label="Email" placeholder="Procure por um email" />
        <DateInput label="Selecione uma data" />
        <div>
          <Button>
            <FiSearch />
          </Button>
        </div>
      </FilterContainer>
      <Main>
        {data.length > 0 ? (
          <>
            {data.map((item) => (
              <CardsScripts
                onClick={() => navigate(`/scripts/details/${item.id}`)}
                key={item.id}
                title={item.title}
                content={item.content}
                phone={item.client.phone}
                status={item.status}
              />
            ))}
          </>
        ) : (
          <p>Sem roteiros cadastrados</p>
        )}
      </Main>
    </Container>
  );
};

export { Dashboard };
