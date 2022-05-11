import * as S from './style.Select';
import React from "react";
import {Option} from "../../types/type";

interface IProps extends React.SelectHTMLAttributes<HTMLSelectElement> {
    options?: Option[];
};

const Select = ({options = [{text : "PLANT"}]}:IProps) => {

    return (
        <S.Container>
            <span className="select-icon"></span>
            <select className="select-box">
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
