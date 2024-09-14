import { Container } from "./styles";

interface InputProps extends React.InputHTMLAttributes<HTMLInputElement> {
  label?: string;
  labelColor?: "default" | "dark";
}

const Input = ({ label, labelColor, ...props }: InputProps) => {
  return (
    <Container labelColor={labelColor}>
      <label>{label}</label>
      <input {...props} type="text" />
    </Container>
  );
};

export { Input };
