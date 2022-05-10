import * as S from './style.Select';
import React from "react";

interface IProps extends React.SelectHTMLAttributes<HTMLSelectElement> {
    options?: string[];
};

const Select = ({options = ["PLANT"]}:IProps) => {

    return (
        <S.Container>
            <span className="select-icon"></span>
            <select className="select-box">
                {options.map((option,i) =>(
                    <option value={option} key={i}>
                        {option}
                    </option>
                ))}
            </select>
        </S.Container>
    );
}

export default Select;
