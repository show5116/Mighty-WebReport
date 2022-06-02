import styled from "styled-components";
import color from "../../../styles/color";

export const Container = styled.div`
  padding: 10px 10px;
  transition: 0.15s ease-in-out;
  &:hover{
    background: ${color.darkgray};
    color: ${color.white};
  }
`;
