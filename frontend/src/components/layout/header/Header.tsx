import * as S from './style.Header';


const Header = () => {
    return(
        <S.Container>
            <div className='header'>
                <img
                    src={require("../../../assets/img/sub_logo_sawnics.jpg")}
                    alt="logo"
                />
            </div>

        </S.Container>
    );
};

export default Header;
