import styled from "styled-components";

export const Container = styled.button`
  cursor: pointer;
  width: 100%;
  border: 0;
  border-radius: 20px;
  font-size: 20px;
  font-weight: bold;
  position: relative;
  box-shadow: rgba(0,0,0,0.19) 0px 10px 20px,rgba(0,0,0,0.23) 0px 6px 9px;
  .buttonText {
    width: 100%;
    margin: 0;
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%,-50%);
  }
`;
