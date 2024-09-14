import { useState } from "react";
import { Button } from "../../components/Buttons/Buttons";
import { Input } from "../../components/Input/Input";
import { Container, LoginContainer, Main, ButtonContainer } from "./style";
import { useNavigate } from "react-router-dom";
import api from "../../services/api";
import { Select } from "../../components/Select/Select";
import { Header } from "../../components/Header/Header";
import { useAuth } from "../../hooks/AuthContext";

interface DataProps {
  email: string;
  password: string;
  role: string;
}

interface ErrorProps {
  email?: string;
  password?: string;
  role?: string;
}

const Login = () => {
  const navigate = useNavigate();
  const { singIn } = useAuth();

  const [data, setData] = useState<DataProps>({
    email: "",
    password: "",
    role: "",
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
      const newErrors: ErrorProps = {};
      if (!data.email) newErrors.email = "Email é obrigatório";
      if (!data.password) newErrors.password = "Senha é obrigatória";
      if (!data.role) newErrors.role = "Cargo é obrigatório";

      if (Object.keys(newErrors).length > 0) {
        setErrors(newErrors);
      } else {
        await api.post("/auth/login", data).then((response) => {
          singIn({
            email: data.email,
            role: data.role,
            token: response.data.token,
          });
          navigate(`/${response.data.token}`)

        });
      }
    } catch (e) {
      console.log(e);
    }
  };

  return (
    <Container>
      <Header title="Login" />
      <Main>
        <LoginContainer>
          <Input
            onChange={handleChange}
            placeholder="Digite seu e-mail"
            label="Email"
            name="email"
            value={data.email}
            error={errors.email}
          />
          <Input
            onChange={handleChange}
            placeholder="Digite sua senha"
            label="Senha"
            name="password"
            type="password"
            value={data.password}
            error={errors.password}
          />
          <Select
            label="Cargo"
            name="role"
            options={[
              {
                label: "ANALISTA",
                value: "ANALISTA",
              },
              {
                label: "REVISOR",
                value: "REVISOR",
              },
              {
                label: "APROVADORES",
                value: "APROVADORES",
              },
            ]}
            value={data.role}
            onChange={handleChange}
            placeholder="Selecione seu cargo"
          />
          <ButtonContainer>
            <Button typeButton="gosth" onClick={() => navigate("/")}>
              Voltar
            </Button>
            <Button onClick={handleSubmit}>Logar</Button>
          </ButtonContainer>
        </LoginContainer>
      </Main>
    </Container>
  );
};
export { Login };
