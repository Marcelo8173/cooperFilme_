import { Container, HelpText } from "./styles";

interface InputProps extends React.InputHTMLAttributes<HTMLInputElement> {
  label?: string;
  labelColor?: "default" | "dark";
  error?: string;
  itemRef?:any
}

const Input = ({ label, error, labelColor, itemRef ,...props }: InputProps) => {
  return (
    <Container error={!!error} labelColor={labelColor}>
      <label>{label}</label>
      <input ref={itemRef} {...props} type="text" />
      {!!error && <HelpText>{error}</HelpText>}
    </Container>
  );
};

export { Input };
