import * as S from './style.NotFound';
import {useNavigate} from "react-router-dom";
import {RootState} from "../modules";
import {useSelector} from "react-redux";
import image from "../assets/img/error-404.png";

const NotFound = () => {
    const navigate = useNavigate();
    const langState = useSelector((state:RootState) => state.menuReducer);

    const onClick = () => {
        navigate(-1);
    };

    return (
        <S.Container>
            <img src={image} alt="404"/>
            <div className='not-found-header'>
                {langState.isKor ?
                    (<span>
                        찾을수 없는 페이지입니다.<br/>
                        요청하신 페이지가 사라졌거나, 잘못된 경로를 이용하셨습니다.
                    </span>) :
                    (<span>
                        Page Not Found
                    </span>) }

            </div>
            <button className='not-found-btn' onClick={onClick}>
                {langState.isKor ? "뒤로 가기" : "Go Back"}
            </button>
        </S.Container>
    );
}

export default NotFound;
