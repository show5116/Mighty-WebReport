import * as S from './style.Input';

interface IProps extends React.InputHTMLAttributes<HTMLInputElement> {
    place : string;
    type? : string;
    svg? : JSX.Element | JSX.Element[];
}

const Input = ({svg,place,type = "text",...props}:IProps) => {
    return (
        <S.Container>
            <span className="input-icon">{svg}</span>
            <input
                className="input-box"
                type={type}
                placeholder={place}
                {...props}
            />
        </S.Container>
    );
}

export default Input;
