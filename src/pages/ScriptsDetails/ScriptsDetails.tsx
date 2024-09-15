import { useParams } from "react-router-dom";
import { Header } from "../../components/Header/Header";
import {
  Container,
  Main,
  Title,
  Content,
  TitleContainer,
  Status,
  ClientData,
} from "./styles";
import { useEffect, useState } from "react";
import api from "../../services/api";

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

const ScriptsDetails = () => {
  const { id } = useParams<{ id: string }>();
  const [data, setData] = useState<Script>({} as Script);

  useEffect(() => {
    api.get(`/scripts/check/details/${id}`).then(response => setData(response.data))
  }, [id]);

  return (
    <Container>
      <Header title="Detalhes do roteiro" />
      <Main>
        <TitleContainer>
          <Title>{data.title}</Title>
          <Status>
            Status: <span>{data.status}</span>
          </Status>
        </TitleContainer>
        <ClientData>
          <span>{data?.client?.name}</span>
          <span>{data?.client?.email}</span>
          <span>{data?.client?.phone}</span>
        </ClientData>
        <Content>{data.content}</Content>

        <p>Comentarios</p>
      </Main>
    </Container>
  );
};

export { ScriptsDetails };
