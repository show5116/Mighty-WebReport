import styled from "styled-components";

export const Container = styled.div<{isLookDown:boolean}>`
  height: calc( 100vh - 80px);
  width: 100%;
  position: relative;
  .look-down{
    cursor: pointer;
    position: absolute;
    top: -4px;
    right: 20px;
  }
  
  ${(props) => props.isLookDown 
      ? 
      `form{
          display: flex;
          flex-direction: column;
          .condition-container{
            display: flex;
            div:nth-child(1){
                flex-grow : 1;
            }
            div:nth-child(2){
                flex-grow : 1;
            } 
            div:nth-child(3){
                flex-grow : 2;
            }
            
          }
      }`
      :
      `form{
          display: flex;
          .condition-container{
            display: grid;
            grid-template-columns: 1fr 1fr;
            div:nth-child(3){
                grid-column-start: 1;
                grid-column-end: 3;
            }
          }
      }`
  }
  
  
`;
