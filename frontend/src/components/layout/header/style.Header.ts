import styled from "styled-components";
import color from "../../../styles/color";

export const Container = styled.div`
  z-index: 10;
  border-bottom: 2px ${color.lightgray} solid;
  height: 80px;
  .header{
    margin: auto 16.67% ;
    display: flex;
    flex-direction: row;
    .nav-container{
      width: 100%;
      display: flex;
      flex-direction: column;
      .logout-container{
        display: flex;
        flex-direction: row;
        gap: 10px;
        margin-left: auto;
        padding-top: 10px;
        align-content: center;
        justify-content: center;
      }
    }
    
  }
`;

