import * as S from './style.Language';
import {useDispatch, useSelector} from "react-redux";
import {RootState} from "../../../modules";
import {setLangEng, setLangKor} from "../../../modules/action/langAction";

const Language = () => {

    const dispatch = useDispatch();
    const langState = useSelector((state:RootState) => state.langReducer);

    const onClick = () => {
        if(langState.isKor){
            dispatch(setLangEng());
        }else{
            dispatch(setLangKor());
        }
    }

    return (
        <S.Container onClick={onClick}>
            {langState.isKor ? (<span>ENG</span>) : (<span>KOR</span>)}
        </S.Container>
    );
}

export default Language;
