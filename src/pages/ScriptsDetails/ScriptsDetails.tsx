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
  CommentsContainer,
  Comments,
  SaveComments,
} from "./styles";
import { useEffect, useState } from "react";
import api from "../../services/api";
import { Input } from "../../components/Input/Input";
import { Button } from "../../components/Buttons/Buttons";

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
  const [comments, setComments] = useState<{ comment: string }[]>([]);
  const [newComment, setNewComment] = useState<{ comment: string }>();

  useEffect(() => {
    api
      .get(`/scripts/check/details/${id}`)
      .then((response) => setData(response.data));
    api
      .get(`/comments/script/${id}`)
      .then((response) => setComments(response.data));
  }, [id]);

  const handleChange = (
    e:
      | React.ChangeEvent<HTMLInputElement>
      | React.ChangeEvent<HTMLSelectElement>
  ) => {
    const { name, value } = e.target;
    setNewComment((prevData: any) => ({
      ...prevData,
      [name]: value,
    }));
  };

  const handleSubmit = async () => {
    try {
      await api.post(`/comments/script/${id}`, newComment);
      if (newComment) {
        setComments([newComment, ...comments]);
      }
    } catch (e) {
      console.log(e);
    }
  };

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

        <CommentsContainer>
          <p>Comentários: </p>
          {comments.length > 0 &&
            comments.map((item) => <Comments>{item.comment}</Comments>)}
        </CommentsContainer>
        <SaveComments>
          <Input
            name="comment"
            onChange={handleChange}
            label="Novo comentário"
            placeholder="Crie seu comentário:"
          />
          <Button onClick={handleSubmit}>Salvar</Button>
        </SaveComments>
      </Main>
    </Container>
  );
};

export { ScriptsDetails };
