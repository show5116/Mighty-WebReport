import styled from "styled-components";
import color from "../../../styles/color";

export const Container = styled.div`
  display: flex;
  flex-direction: row;
  text-align: center;
  .menu-parent{
    position: relative;
    width: 100px;
    cursor: pointer;
    padding: 15px;
    transition: 0.15s ease-in-out;
    .menu-children{
      display: none;
    }
  }
  .menu-parent:hover {
    color: ${color.blue};
    .menu-children{
      color: #000000;
      display: flex;
      position: absolute;
      flex-direction: column;
      width: 300px;
      top: 46px;
      left: 0px;
      background: white;
      z-index: 10;
      border-top: 2px solid ${color.blue};
      border-bottom : 2px solid ${color.lightgray};
      padding: 15px 0;
      text-align: left;
      .menu-child{
        padding: 10px 10px;
        transition: 0.15s ease-in-out;
      }
      .menu-child:hover{
        background: ${color.darkgray};
        color: ${color.white};  
      }
    }
  }
`;
