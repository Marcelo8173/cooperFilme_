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
  const [data, setDate] = useState<Script>({
    id: "2d58a18a-a4f8-4078-b161-aef4b44f2a13",
    title: "film",
    content: "o silencio dos inocentes",
    status: "EM_ANALISE",
    client: {
      id: "260a9383-dc2b-4d46-a5e8-0aae8fcaaaa6",
      name: "Marcelo",
      email: "marceloandreb1io@gmail.com",
      phone: "11993882395",
    },
  });

  useEffect(() => {
    // api.get(`/scripts/check/details/${id}`).then(response => setData(response.data))
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
          <span>{data.client.name}</span>
          <span>{data.client.email}</span>
          <span>{data.client.phone}</span>
        </ClientData>
        <Content>{data.content}</Content>

        <p>Comentarios</p>
      </Main>
    </Container>
  );
};

export { ScriptsDetails };
