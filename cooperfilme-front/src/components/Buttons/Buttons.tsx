import React from "react";
import { ButtonContainer } from "./styled";

interface ButtonProps extends React.ButtonHTMLAttributes<HTMLButtonElement> {
  children: React.ReactNode;
  typeButton?: "default" | "gosth";
}

const Button = ({ children, typeButton = 'default', ...props }: ButtonProps) => {
  return (
    <ButtonContainer typeButton={typeButton} {...props}>
      {children}
    </ButtonContainer>
  );
};

export { Button };
