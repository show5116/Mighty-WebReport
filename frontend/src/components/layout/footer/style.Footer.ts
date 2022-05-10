import styled from "styled-components";
import color from "../../../styles/color";

export const Container = styled.div`
  width: 100%;
  padding-top: 1.5rem;
  text-align: center;
  border-top: 2px ${color.lightgray} solid;
  .footer-title{
    font-weight: bold;
  }
  .footer-text{
    color : ${color.gray};
    display: inline-block;
    line-height: 1.1rem;
    font-size: 12px;
  }
`;
