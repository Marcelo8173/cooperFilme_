import styled from "styled-components";

interface ContainerProps {
  labelColor?: "default" | "dark";
}

export const Container = styled.div<ContainerProps>`
  display: flex;
  flex-direction: column;
  width: 500px;
  > label {
    color: ${({ labelColor }) =>
      labelColor === "default" ? "#d4c2ff" : "#9b76f5"};
    font-family: Poppins;
    font-size: 16px;
    font-style: normal;
    font-weight: 400;
    line-height: 24px;
  }
  > input {
    border-radius: 8px;
    border: 1px solid #e6e6f0;
    background: #fafafc;
    height: 56px;
    padding: 5px;
  }
`;
