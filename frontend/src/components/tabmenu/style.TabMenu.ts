import styled from "styled-components";
import color from "../../styles/color";

export const Container = styled.div`
  height: 100%;
  margin-left: 30px;
  margin-right: 30px;
  position: relative;
  .tabList{
    position: sticky;
    top: 80px;
    z-index: 9000;
    background: ${color.white};
    height: 40px;
    display: flex;
    border-bottom: 1px solid lightgray;
  }
  .tabContent{
    padding: 10px;
    height: 100%;
  }
`;
