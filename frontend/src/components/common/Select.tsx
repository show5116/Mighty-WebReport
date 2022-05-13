import * as S from './style.Select';
import React from "react";
import {Option} from "../../types/type";

interface IProps extends React.SelectHTMLAttributes<HTMLSelectElement> {
    options?: Option[];
    svg? : JSX.Element | JSX.Element[];
};

const Select = ({options = [{text : "PLANT"}] , svg , ...props}:IProps) => {

    return (
        <S.Container>
            <span className="select-icon">{svg}</span>
            <select className="select-box"
                {...props}
            >
                {options.map((option,i) =>(
                    <option value={option.value} key={i}>
                        {option.text}
                    </option>
                ))}
            </select>
        </S.Container>
    );
}

export default Select;
