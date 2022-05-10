import styled from "styled-components";
import color from "../../styles/color";

export const Container = styled.div`
  display: flex;
  margin-bottom: 20px;
  .select-icon{
    display: inline-block;
    position: relative;
    height: 34px;
    width: 30px;
    border: 1px solid ${color.lightgray};
    border-right: 0;
    svg {
      position: absolute;
      top: 5px;
      left: 5px;
    }
  }
  .select-box{
    display: inline-block;
    height: 34px;
    width: 90%;
    padding: 6px 12px;
    font-size: 14px;
    line-height: 1;
    color: ${color.darkgray};
    border: 1px solid ${color.lightgray};
    box-shadow: none;
    transition: all 0.15s ease-in-out;
  }
  .select-box:focus{
    outline: 0;
    border-color: ${color.gray};
    box-shadow: 0 0 2px ${color.darkgray};
  }
`;
