import styled from "styled-components";
import color from "../../styles/color";

export const Container = styled.button`
  cursor: pointer;
  width: 100%;
  border: 0;
  border-radius: 20px;
  font-size: 20px;
  font-weight: bold;
  position: relative;
  box-shadow: rgba(0,0,0,0.20) 0px 2px 4px;
  transition: 0.15s ease-in-out;
  &:hover{
    opacity: 0.7;
  }
  &:disabled{
    cursor : default;
    color : inherit;
    opacity: 1.0;
    background-color: ${color.lightgray} !important;;
  }
  .buttonText {
    width: 100%;
    margin: 0;
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%,-50%);
  }
`;
