import styled from "styled-components";

export const Container = styled.div<{selected:boolean}>`
  overflow-y: auto;
  height: 720px;
  ${(props)=> props.selected 
          ?
          `display: block;`
          :
          `display: none;`
    }
`;
