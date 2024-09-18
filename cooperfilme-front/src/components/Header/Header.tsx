import { HeaderContainer, Title } from "./styles";

interface HeaderProps {
  children?: React.ReactNode;
  title: string;
}
const Header = ({ children, title }: HeaderProps) => {
  return (
    <HeaderContainer>
      {children}
      <Title>{title}</Title>
    </HeaderContainer>
  );
};

export { Header };
