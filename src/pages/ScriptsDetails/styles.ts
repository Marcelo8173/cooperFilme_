import styled from "styled-components";

export const Container = styled.div``;

export const Main = styled.main`
  border-radius: 8px;
  border: 1px solid #e6e6f0;
  background: var(--Shapes-01, #fff);
  margin: 40px 60px;
  padding: 40px;
`;

export const Title = styled.div`
  color: #32264d;
  font-family: Archivo;
  font-size: 24px;
  font-style: normal;
  font-weight: 700;
  line-height: 25px;
`;

export const Content = styled.div`
  color: #6a6180;
  font-family: Poppins;
  font-size: 16px;
  font-style: normal;
  font-weight: 400;
  line-height: 26px;
  margin-top: 30px;
`;

export const TitleContainer = styled.div`
  display: flex;
  align-items: baseline;
`;

export const Status = styled.span`
  margin-left: 20px;
  color: #6a6180;
  font-family: Poppins;
  font-size: 16px;
  font-style: normal;
  font-weight: 400;
  line-height: 26px;
  > span {
    color: #8257e5;
    font-family: Archivo;
    font-size: 16px;
    font-style: normal;
    font-weight: 700;
    line-height: 26px;
  }
`;

export const ClientData = styled.div`
  color: #6a6180;
  font-family: Poppins;
  font-size: 16px;
  font-style: normal;
  font-weight: 400;
  line-height: 26px;
  display: flex;
  flex-direction: column;
`;

export const CommentsContainer = styled.div`
  margin-top: 8px;
  display: flex;
  flex-direction: column;
  > p {
    color: #32264d;
    font-family: Archivo;
    font-size: 12px;
    font-style: normal;
    font-weight: 700;
    line-height: 25px;
  }
`;

export const Comments = styled.span`
  color: #6a6180;
  font-family: Archivo;
  font-size: 12px;
  font-style: normal;
  font-weight: 700;
  line-height: 25px;
`;

export const SaveComments = styled.div`
  width: 100%;
  display: flex;
  align-items: end;
  margin-top: 8px;
  > div {
    margin-right: 8px;
  }
`;