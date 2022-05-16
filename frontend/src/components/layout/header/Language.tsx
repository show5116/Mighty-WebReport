import * as S from './style.Language';
import {useDispatch, useSelector} from "react-redux";
import {RootState} from "../../../modules";
import {setMenuEng, setMenuKor} from "../../../modules/action/menuAction";

const Language = () => {

    const dispatch = useDispatch();
    const langState = useSelector((state:RootState) => state.menuReducer);

    const onClick = () => {
        if(langState.isKor){
            dispatch(setMenuEng());
        }else{
            dispatch(setMenuKor());
        }
    }

    return (
        <S.Container onClick={onClick}>
            {langState.isKor ? (<span>ENG</span>) : (<span>KOR</span>)}
        </S.Container>
    );
}

export default Language;
