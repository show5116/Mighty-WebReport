import styled from "styled-components";

export const Container = styled.div<{isViewAll:boolean}>`
  height: 100%;
  overflow-y: auto;
  background-color: white;
  ${(props) => props.isViewAll && `
    position : absolute;
    top: 0;
    left: 0;  
    z-index: 100;
    overflow: auto;
  `}
  .btn-container{
    margin-left: auto;
    .search-btn{
      cursor: pointer;
      border: 0;
      background-color: inherit;
      margin-right: 10px;
    }
    .expand-btn{
      cursor: pointer;
    }
  }
  .result-header{
    display: flex;
    margin-bottom: 10px;
    padding-right: 20px;
  }
  .result-main{
    
  }
`;
