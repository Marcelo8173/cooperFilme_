import { useNavigate } from "react-router-dom";
import { Button } from "../../components/Buttons/Buttons";
import { Header } from "../../components/Header/Header";
import { Input } from "../../components/Input/Input";
import { Container, Main, Wrapper, Title, Content, Footer } from "./styles";
import { useState } from "react";
import api from "../../services/api";

interface DataProps {
  title: string;
  content: string;
  name: string;
  email: string;
  phone: string;
}

interface ErrorProps {
  title?: string;
  content?: string;
  name?: string;
  email?: string;
  phone?: string;
}

const NewScript = () => {
  const navigate = useNavigate();
  const [loading, setLoading] = useState(false);

  const [data, setData] = useState<DataProps>({
    title: "",
    content: "",
    name: "",
    email: "",
    phone: "",
  });

  const handleChange = (
    e:
      | React.ChangeEvent<HTMLInputElement>
      | React.ChangeEvent<HTMLSelectElement>
  ) => {
    const { name, value } = e.target;
    setData((prevData: any) => ({
      ...prevData,
      [name]: value,
    }));
  };
  const [errors, setErrors] = useState<ErrorProps>({});

  const handleSubmit = async () => {
    try {
      setLoading(true);
      const newErrors: ErrorProps = {};
      if (!data.email) newErrors.email = "Email é obrigatório";
      if (!data.content) newErrors.content = "O conteúdo é obrigatório";
      if (!data.name) newErrors.name = "Nome é obrigatório";
      if (!data.phone) newErrors.phone = "Telefone é obrigatório";
      if (!data.title) newErrors.title = "Título é obrigatório";

      if (Object.keys(newErrors).length > 0) {
        setErrors(newErrors);
      } else {
        await api.post("/scripts", data);
        navigate("/");
      }
      setLoading(false);
    } catch (e) {
      console.log(e);
      setLoading(false);
    }
  };

  return (
    <Container>
      <Header title="Cadastrar novo roteiro" />
      <Main>
        <Wrapper>
          <Title>Cadastro de roteiro</Title>
          <Content>
            <Input
              onChange={handleChange}
              label="Título"
              name="title"
              placeholder="Cadastre o título do seu roteiro"
              value={data.title}
              error={errors.title}
            />
            <Input
              name="content"
              onChange={handleChange}
              label="Conteúdo (Na v2 você podera subir um arquivo do seu roteiro)"
              placeholder="Cadastre o conteúdo do roteiro"
              value={data.content}
              error={errors.content}
            />
            <Input
              onChange={handleChange}
              name="name"
              label="Nome"
              placeholder="Digite seu nome"
              value={data.name}
              error={errors.name}
            />
            <Input
              name="email"
              onChange={handleChange}
              label="Email"
              placeholder="Digite seu email"
              value={data.email}
              error={errors.email}
            />
            <Input
              name="phone"
              onChange={handleChange}
              label="Telefone"
              placeholder="Digite seu Telefone: xx-xxxxx-xxxx"
              value={data.phone}
              error={errors.phone}
            />
          </Content>
        </Wrapper>
        <Footer>
          <Button onClick={() => navigate("/")} typeButton="gosth">
            Cancelar
          </Button>
          <Button disabled={loading} onClick={handleSubmit}>
            {loading ? "Salvando" : "Salvar"}
          </Button>
        </Footer>
      </Main>
    </Container>
  );
};

export { NewScript };
