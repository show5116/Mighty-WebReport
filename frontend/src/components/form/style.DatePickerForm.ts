import styled from "styled-components";
import color from "../../styles/color";

export const Container = styled.div<{ isRangeSearch:boolean }>`
  position: relative;
  border: 1px solid ${color.lightgray};
  width:  ${(props) => props.isRangeSearch ? "230px" : "110px"};
  padding: 5px 10px;
  border-radius: 20px;
  display: flex;
  & .date-picker-container{
    position: relative;
  }
  & .date-picker-container svg{
    position: absolute;
    top: 4px;
    right: -12px;
  }
  & .react-datepicker__input-container>input{
    width: 80px;
    border: 0;  
  }
  & .end-date .react-datepicker__input-container>input{
    margin-left: 36px;
  }
  & .react-datepicker__input-container>input:focus{
    outline: 0;
  }
  /* absolute 폼 */
  & .react-datepicker-popper{
    border: 1px solid ${color.lightgray};
    padding: 10px 20px;
    background-color: ${color.white};
    z-index: 10;
    width: 250px;
  }
  & .header-custom {
    display: flex;
    justify-content: center;
    align-items: center;
    width: 100%;
    position: relative;
    height: 30px;
    margin-bottom: 10px;
  }
  & .header-custom .prev-month{
    position: absolute;
    cursor: pointer;
    top: 5px;
    left: 5px;
    transform: rotate(90deg);
  }
  & .header-custom .next-month{
    position: absolute;
    cursor: pointer;
    transform: rotate(-90deg);
  }
  & .react-datepicker__header,
  & .react-datepicker__month{
    display: flex;
    flex-direction: column;
    align-items: center;
  }
  & .react-datepicker__day-names,
  & .react-datepicker__week{
    display: flex;
    text-align: center;
    justify-content: center;
    align-items: center;
  }
  & .react-datepicker__day-name,
  & .react-datepicker__day{
    width: 28px;
    height: 22px;
  }
  & .react-datepicker__day{
    cursor: pointer;
    transition: 0.15s ease-in-out;
    border : 1px solid ${color.white}
  }
  & .react-datepicker__day:hover{
    border : 1px solid ${color.black};
  }
  & .react-datepicker__day--selected{
    color : ${color.white};
    background-color: ${color.darkBlue};
    border : solid 1px ${color.black};
  }
  & .react-datepicker__day--selected:hover{
    border : solid 1px ${color.gray};
    background-color: ${color.gray};
  }
  & .react-datepicker__day--today{
    color: ${color.red};
  }
  & .react-datepicker__day--selected.react-datepicker__day--today{
    color: ${color.lightRed};
  }
  & .react-datepicker__day--selected.react-datepicker__day--today:hover{
    color: ${color.red};
  }
  & .react-datepicker__day--disabled{
    color: ${color.blue};
    cursor: default;
  }
  & .react-datepicker__day--outside-month{
    color: ${color.lightgray};
    cursor: default;
  }
  
  .range {
    position: absolute;
    top: 0px;
    left: 105px;
    font-size: 24px;
    font-weight: 100;
    
  }
`;
