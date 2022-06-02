import styled from "styled-components";
import backGroundImg from "../assets/img/m_img_tami.jpg"

export const Container = styled.div`
  min-width: 1000px;
  height: calc( 100vh - 80px);
  .home-container {
    padding: 266px 15px;
    margin: auto;
    background-image: url(${backGroundImg});
    background-position: center center;
    background-repeat: no-repeat;
    background-color: white;
  }
`;
