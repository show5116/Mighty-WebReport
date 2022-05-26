import * as S from './style.Button';

type type = "button" | "submit" | "reset" ;

interface IProps extends React.SelectHTMLAttributes<HTMLButtonElement> {
    text : string;
    color? : string;
    to?: string;
    type? : type;
    disabled? : boolean;
}

const Button = ({ text , color , to , type , disabled = false , ...props }: IProps) => {
    return (
        <S.Container
            style={{
                backgroundColor : color
            }}
            disabled={disabled}
            type={type}
            {...props}
        >
            {text}
        </S.Container>
    );
}

export default Button;
