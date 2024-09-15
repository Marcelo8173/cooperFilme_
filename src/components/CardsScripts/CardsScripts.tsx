import {
  Container,
  Title,
  Content,
  Footer,
  Wrapper,
  Status,
  Phone,
} from "./styles";

interface CardsScriptsProps {
  title: string;
  content: string;
  status: string;
  phone: string;
  onClick?: () => void;
}

const CardsScripts = ({
  content,
  phone,
  status,
  title,
  onClick,
}: CardsScriptsProps) => {
  return (
    <Container onClick={onClick}>
      <Wrapper>
        <Title>{title}</Title>
        <Content>{content}</Content>
      </Wrapper>
      <Footer>
        <Status>
          status: <span>{status}</span>
        </Status>
        <Phone>{phone}</Phone>
      </Footer>
    </Container>
  );
};

export { CardsScripts };
