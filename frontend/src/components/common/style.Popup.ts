import styled from "styled-components";
import color from "../../styles/color";

export const Container = styled.div< { show : boolean } >`
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100vh;
  display: ${(props) => (props.show? 'flex' : 'none')};
  justify-content: center;
  align-items: center;
  background-color: rgba(0,0,0,0.4);
  z-index: 9999;
  .modal-body{
    position: absolute;
    width: 400px;
    height: 250px;
    padding: 40px 0px;
    text-align: center;
    background-color: ${color.white};
    border-radius: 10px;
    box-shadow: 0 2px 3px 0 rgba(34,36,38,0.15);
    ${(props) => props.show && `
        animation: fade-in 0.3s;
    `}
    .modal-header{
      font-size: 30px;
      font-weight: bold;
      margin-bottom: 50px;
    }
    .modal-content{
      font-size: 20px;
      margin-bottom: 50px;
      .modal-bold{
        color: ${color.red};
        font-weight: bold;
      }
    }
    .button-container{
      padding: 0 120px;
      margin: 0 30px;
    }
    .hidden{
      width: 0;
      height: 0;
      padding: 0;
      margin: 0;
      border: 0;
    }
  }

  @keyframes fade-in {
    from {
      opacity: 0;
    }
    to {
      opacity: 1;
    }
  }
`;
