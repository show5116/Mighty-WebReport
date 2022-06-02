import styled from "styled-components";

export const Container = styled.div<{selected:boolean}>`
  ${(props)=> props.selected 
          ?
          `display: block;`
          :
          `display: none;`
    }
`;
