import styled from "styled-components";
import color from "../../styles/color";
import {TableHeader} from "../../types/type";

export const Container = styled.div<{headers:TableHeader[] , isViewAll:boolean , isLookDown:boolean}>`
  overflow: hidden;
  width: 100%;
  table{
    display: grid;
    overflow: auto;
    height: ${(props) => {
        if(props.isViewAll){
            return `650px`;
        }else if(props.isLookDown){
            return `380px`;
        }else {
            return `650px`;
        }
    }};
    grid-template-columns: ${(props) => (props.headers.map((header)=> {
        return `minmax(${header.width},1fr) `;   
    }))}; 
    grid-template-rows: auto;
  }

  table thead,
  table tbody,
  table tr {
    display: contents;
  }
  
  table th {
    width: 100%;
    position: sticky;
    top: 0;
    background-color: white;
    border: 1px solid black;
  }

  table tbody {
    
  }
  
  table th,
  table td {
    height: 28px;
    font-size: 12px;
    text-align: left;
    padding: 4px 4px;
  }
  
  table th span,
  table td span {
    white-space: nowrap;
    text-overflow: ellipsis;
    overflow: hidden;
    display: block;
  }

  table tr td {
    border-top: 1px solid #ccc;
  }
  
  & .resize-handle {
    display: block;
    position: absolute;
    cursor: col-resize;
    width: 7px;
    right: 0;
    top: 0;
    z-index: 1;
    border-right: 2px solid transparent;
  }

  & .resize-handle:hover {
    border-color: #ccc;
  }

  & .resize-handle.active {
    border-color: #517ea5;
  }
`;
