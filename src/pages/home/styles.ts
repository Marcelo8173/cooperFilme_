import styled from "styled-components";

export const Container = styled.div``;


export const SearchContainer = styled.div`
  width: 100%;
  display: flex;
  align-items: flex-end;
  justify-content: center;
  margin: -44px 0;
`;
export const Main = styled.main`
  padding: 0 356px;
`;

export const LoginSection = styled.section`
  display: flex;
  align-items: center;
`;

export const ButtonContainer = styled.div`
  width: 120px;
  height: 50px;
`;

export const NewScript = styled.div`
  color: #d8cbf7;
  font-family: Poppins;
  font-size: 14px;
  font-style: normal;
  font-weight: 400;
  line-height: 24px;
  margin-left: 10px;
  > button {
    color: #d8cbf7;
    font-family: Poppins;
    font-size: 14px;
    font-style: normal;
    font-weight: 400;
    line-height: 24px;
    background: transparent;
    border: 0;
    &:hover {
      opacity: 0.8;
    }
  }
`;

export const CardContainer = styled.div`
  display: flex;
  flex-direction: column;
  width: 100%;
  justify-content: center;
  align-items: center;

  margin-top: 100px;

  > p {
    font-family: Poppins;
    font-size: 14px;
    color: #32264d;
    font-weight: 700;
    font-size: 16px;
    margin-bottom: 8px;
  }
`;
