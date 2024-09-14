import { Container, Status } from "./styles";

interface CardStatusProps {
  title: string;
  status: string;
}

const CardStatus = ({ status, title }: CardStatusProps) => {
  return (
    <Container>
      <span>{title}</span>
      <Status>{status}</Status>
    </Container>
  );
};

export { CardStatus };
