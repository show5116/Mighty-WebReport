import * as S from './style.DailyShippingStatus';
import {useSelector} from "react-redux";
import {RootState} from "../../modules";

const DailyShippingStatus = () => {

    const langState = useSelector((state:RootState) => state.langReducer);

    const onSubmit = (event : React.FormEvent<HTMLFormElement>) => {
        event.preventDefault();
    }

    return (
        <S.Container>
            <form onSubmit={onSubmit}>

            </form>
        </S.Container>
    )
}

export default DailyShippingStatus;
