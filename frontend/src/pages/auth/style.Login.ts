import styled from "styled-components";
import color from "../../styles/color";
import backGroundImg from "../../assets/img/m_img_tami.jpg"

export const Container = styled.div`
  min-width: 1000px;
  height: calc( 100vh - 80px);
  .form-container{
    padding: 100px 16px;
    margin: auto;
    background-image: url(${backGroundImg});
    background-position: center center;
    background-repeat: no-repeat;
    background-color: white;
    .login-form{
      margin-left: 33.33%;
      width: 500px;
      padding: 35px;
      background: ${color.white};
      border: solid 1px ${color.lightgray};
      box-shadow: 0 0 3px ${color.lightgray};
      .form-title{
        text-align: center;
        margin-bottom: 35px;
        border-bottom: solid 1px ${color.lightgray};
        h2{
          border-bottom: 0;
          font-size: 24px;
          margin-bottom: 15px;
        }
      }
      .button-container{
        margin-left: auto;
        width: 100px;
      }
    }
  }
`;
