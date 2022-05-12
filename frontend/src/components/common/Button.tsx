import * as S from './style.Button';

interface IProps extends React.SelectHTMLAttributes<HTMLButtonElement> {
    text : string;
    color? : string;
    to?: string;
    disabled? : boolean;
}

const Button = ({ text , color , to , disabled = false , ...props }: IProps) => {
    return (
        <S.Container
            style={{
                backgroundColor : color
            }}
            disabled={disabled}
            {...props}
        >
            {text}
        </S.Container>
    );
}

export default Button;
