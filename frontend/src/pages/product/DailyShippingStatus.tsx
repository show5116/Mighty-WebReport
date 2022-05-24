import * as S from './style.DailyShippingStatus';
import useTitle from "../../utils/UseHooks";
import H2 from "../../components/common/H2";
import {useSelector} from "react-redux";
import {RootState} from "../../modules";

const DailyShippingStatus = () => {

    const langState = useSelector((state:RootState) => state.menuReducer);

    useTitle(" : 일별 출하 현황");

    const onSubmit = (event : React.FormEvent<HTMLFormElement>) => {
        event.preventDefault();
    }

    return (
        <S.Container>
            <H2 text={langState.isKor ? "일별 출하 현황" : "Daily Shipping Status" }/>
            <form onSubmit={onSubmit}>

            </form>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
        </S.Container>
    )
}

export default DailyShippingStatus;
