import styled from "styled-components";

export const Container = styled.div``;
export const Header = styled.header`
  background: #8257e5;
  width: 100%;
  min-height: 272px;
  padding: 20px 50px;
`;

export const Title = styled.h1`
  color: #ffffff;
  font-size: 36px;
  font-weight: 700;
  margin-top: 40px;
  margin-left: 300px;
  max-width: 300px;
  text-align: left;
`;

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
