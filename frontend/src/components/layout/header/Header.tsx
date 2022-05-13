import * as S from './style.Header';
import LogoutBtn from "./LogoutBtn";
import {useSelector} from "react-redux";
import {RootState} from "../../../modules";
import {Link} from "react-router-dom";

const Header = () => {
    const authState = useSelector((state:RootState) => state.authReducer);

    return(
        <S.Container>
            <div className='header'>
                <div>
                    <Link to="/">
                        <img
                            src={require("../../../assets/img/sub_logo_sawnics.jpg")}
                            alt="logo"
                        />
                    </Link>
                </div>
                {authState.isLogin
                    ?
                    (<div className='logout-container'>
                        <LogoutBtn />
                    </div>)
                    : null }
            </div>
        </S.Container>
    );
};

export default Header;
