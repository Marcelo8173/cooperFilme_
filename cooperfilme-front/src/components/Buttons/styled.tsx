import styled from "styled-components";

interface ButtonContainerProps {
  typeButton?: "default" | "gosth";
}

export const ButtonContainer = styled.button<ButtonContainerProps>`
  background: ${({ typeButton }) =>
    typeButton === "default" ? "#04d361" : "transparent"};
  border: 0;
  padding: 15px;
  width: 100%;
  height: 100%;
  border-radius: 8px;
  font-size: 16px;
  font-style: normal;
  font-weight: 600;
  max-width: 200px;
  color: ${({ typeButton }) => (typeButton === "default" ? "#fff" : "#04d361")};
  font-family: "Archivo", sans-serif;
  &:hover {
    opacity: 0.8;
  }
`;
