import styled from "styled-components";
import color from "../../../styles/color";

export const Container = styled.div`
  z-index: 10;
  border-bottom: 2px ${color.lightgray} solid;
  .header{
    margin: auto 16.67% ;
    display: flex;
    flex-direction: row;
    .logout-container{
      margin-left: auto;
      padding-top: 30px;
    }
  }
`;

