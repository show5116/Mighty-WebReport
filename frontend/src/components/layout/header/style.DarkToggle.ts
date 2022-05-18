import styled from "styled-components";

export const Container = styled.div`
  #dark-btn{
    display: none;
  }
  .toggler{
    display: block;
    width: 40px;
    height: 20px;
    border: 2px solid ;
    border-radius: 30px;
    position: relative;
    cursor: pointer;
  }
  .ball,
  .sun,
  .moon {
    position: absolute;
    top: 50%;
    transform: translateY(-50%);
  }
  .sun,
  .moon{
    width: 21px;
  }
  .ball{
    display: inline-block;
    width: 15px;
    height: 14px;
    background-color: #000000;
    border-radius: 50%;
    left: 3px;
    z-index: 10;
    transition: transform .5s ease-in-out;
  }

  .sun{
    left: 2px;
  }
  .moon{
    right: 0px;
  }
  #dark-btn:checked + .ball{
    transform: translate(15px,-50%);
  }
`;
