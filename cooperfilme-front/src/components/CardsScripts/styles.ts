import styled from "styled-components";

export const Container = styled.div`
  width: 100%;
  border-radius: 8px;
  border: 1px solid #e6e6f0;
  background: #fff;
  font-family: "Archivo", sans-serif;
  &:hover {
    opacity: 0.8;
    cursor: pointer;
  }
  margin-bottom: 20px;
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

export const Footer = styled.footer`
  border-radius: 0px 0px 8px 8px;
  background: #fafafc;
  display: flex;
  justify-content: space-between;
  padding: 40px;
  align-items: center;
`;

export const Wrapper = styled.div`
  padding: 40px;
`;

export const Status = styled.div`
  color: #9c98a6;
  font-size: 14px;
  font-style: normal;
  font-weight: 400;
  line-height: 20px;
  span {
    color: #8257e5;
    font-size: 20px;
    font-style: normal;
    font-weight: 700;
    line-height: 26px;
    margin-left: 16px;
  }
`;

export const Phone = styled.span`
  color: #8257e5;
  font-size: 20px;
  font-style: normal;
  font-weight: 700;
  line-height: 26px;
  margin-left: 16px;
`;
