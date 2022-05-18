import * as S from './style.H2';

interface IProps {
    text : string;
}

const H2 = ({ text }:IProps) =>{
    return (
        <S.Container>
            {text}
        </S.Container>
    );
};

export default H2;
