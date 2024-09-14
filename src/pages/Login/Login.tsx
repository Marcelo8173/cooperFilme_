import { Button } from "../../components/Buttons/Buttons";
import { Input } from "../../components/Input/Input";
import { Header } from "../home/styles";
import {
  Container,
  LoginContainer,
  Main,
  Title,
  ButtonContainer,
} from "./style";
import { useNavigate } from "react-router-dom";

const Login = () => {
  const navigate = useNavigate();
  return (
    <Container>
      <Header>
        <Title>Login</Title>
      </Header>
      <Main>
        <LoginContainer>
          <Input placeholder="Digite seu e-mail" label="Email" />
          <Input placeholder="Digite sua senha" label="Senha" />
          <Input placeholder="Cargo" label="Cargo" />
          <ButtonContainer>
            <Button typeButton="gosth" onClick={() => navigate("/")}>
              Voltar
            </Button>
            <Button>Logar</Button>
          </ButtonContainer>
        </LoginContainer>
      </Main>
    </Container>
  );
};
export { Login };
