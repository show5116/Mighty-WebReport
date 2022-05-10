import * as S from './style.Input';
import {useState} from "react";

interface IProps extends React.InputHTMLAttributes<HTMLInputElement> {
    value : string;
    place : string;
    type? : string;
    svg? : JSX.Element | JSX.Element[];
    required? : boolean
    autoFocus? : boolean;
}

type InputValue = string | number | ReadonlyArray<string>

const Input = ({value,svg,place,type = "text",required = false,autoFocus = false}:IProps) => {
    const [inputValue, setValue] = useState<InputValue>(value);



    return (
        <S.Container>
            <span className="input-icon">{svg}</span>
            <input
                value={value}
                className="input-box"
                type={type}
                placeholder={place}
                required={required}
                autoFocus={autoFocus}
            />
        </S.Container>
    );
}

export default Input;
