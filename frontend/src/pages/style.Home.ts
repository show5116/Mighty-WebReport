import styled from "styled-components";
import backGroundImg from "../assets/img/m_img_tami.jpg"

export const Container = styled.div`
  min-width: 1000px;
  min-height: 600px;
  .home-container {
    padding: 265px 15px;
    margin: auto;
    background-image: url(${backGroundImg});
    background-position: center center;
    background-repeat: no-repeat;
    background-color: white;
  }
`;