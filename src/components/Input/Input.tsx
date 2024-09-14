import { Container, HelpText } from "./styles";

interface InputProps extends React.InputHTMLAttributes<HTMLInputElement> {
  label?: string;
  labelColor?: "default" | "dark";
  error?: string;
}

const Input = ({ label, error, labelColor, ...props }: InputProps) => {
  return (
    <Container error={!!error} labelColor={labelColor}>
      <label>{label}</label>
      <input {...props} type="text" />
      {!!error && <HelpText>{error}</HelpText>}
    </Container>
  );
};

export { Input };
