import * as S from './style.Button';

interface IProps extends React.SelectHTMLAttributes<HTMLButtonElement> {
    text : string;
    color? : string;
    to?: string;
}

const Button = ({ text , color , to }: IProps) => {
    return (
        <S.Container
            color={color}>
            {text}
        </S.Container>
    );
}

export default Button;
