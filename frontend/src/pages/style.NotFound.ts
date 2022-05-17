import styled from "styled-components";
import color from "../styles/color";

export const Container = styled.div`
  text-align: center;
  img{
    margin-top: 100px;
    width: 200px;
  }
  .not-found-header{
    font-size: 1.5rem;
    line-height: 2rem;
    margin-top: 50px;
  }
  .not-found-btn{
    margin-top: 50px;
    margin-bottom: 60px;
    width: 150px;
    height: 40px;
    font-size: 15px;
    font-weight: bold;
    cursor: pointer;
    background: ${color.white};
    border-radius: 10px;
    border : 2px solid ${color.darkgray};
    color: ${color.darkgray};
    display: inline-block;
    transition: 0.2s ease-in-out;
  }
  .not-found-btn:hover{
    background: ${color.darkgray};
    color: ${color.white};
  }
`;
