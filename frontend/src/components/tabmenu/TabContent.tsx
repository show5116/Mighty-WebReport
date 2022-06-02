import * as S from './style.TabContent';

interface IProps {
    selected : boolean;
    children : JSX.Element;
}

const TabContent = ({selected , children}:IProps) => {
    return (
        <S.Container
            selected={selected}
        >
            {children}
        </S.Container>
    );
}

export default TabContent;
