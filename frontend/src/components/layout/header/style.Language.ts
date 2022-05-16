import styled from "styled-components";
import color from "../../../styles/color";

export const Container = styled.button`
  display: flex;
  justify-content: center;
  align-items: center;
  height: 15px;
  cursor: pointer;
  font-size: 15px;
  width: 43px;
  border-radius: 5px;
  padding: 2px;
  border: 1px solid ${color.darkgray};
  &:hover{
    opacity: 0.8;
  }
`;
