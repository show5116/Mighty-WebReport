import * as S from './style.Menu';
import LotStatus from "../../../pages/inventory/LotStatus";
import {ITab} from "../../../modules/reducer/tabMenuReducer";
import {useDispatch, useSelector} from "react-redux";
import {RootState} from "../../../modules";
import DailyShippingStatus from "../../../pages/product/DailyShippingStatus";
import DeviceShippingStatus from "../../../pages/product/DeviceShippingStatus";
import AVIYield from "../../../pages/yield/AVIYield";
import PTESTYield from "../../../pages/yield/PTESTYield";
import FinalPTESTYield from "../../../pages/yield/FinalPTESTYield";
import MonthlySalesPerformance from "../../../pages/sales/MonthlySalesPerformance";
import {setTabList} from "../../../modules/action/tabMenuAction";
import ViewDefectStatus from "../../../pages/inventory/ViewDefectStatus";
import DailyMovement from '../../../pages/product/DailyMovement';

type menuName = string | "Daily Movement" | "Operation Movement Monitoring" |
    "Daily Shipping Status" | "Fab Out Status By Device" | "View LOT Status" |
    "AVI Yield Report" | "PTEST Yield Report" | "Final PTEST Yield Report" |
    "Current Month Sales Status" | "View Defect Status" |
    "TEST";

const MenuSet: Record<menuName, ITab> = {
    "Daily Movement" : {
        label : "Daily Movement",
        labelKor : "Daily Movement",
        children : <DailyMovement />
    },
    "View LOT Status" : {
        label : "View LOT Status",
        labelKor : "LOT 정보 조회",
        children : <LotStatus />
    },
    "View Defect Status" : {
        label : "View Defect Status",
        labelKor : "불량현황 조회",
        children : <ViewDefectStatus />
    },
    "Operation Movement Monitoring" : {
        label : "Operation Movement Monitoring",
        labelKor : "Operation Movement Monitoring",
        children : <LotStatus />
    },
    "Daily Shipping Status" : {
        label : "Daily Shipping Status",
        labelKor : "Daily Shipping Status",
        children : <DailyShippingStatus />
    },
    "Fab Out Status By Device" : {
        label : "Fab Out Status By Device",
        labelKor : "Device 출하기준(Yield,TAT)",
        children : <DeviceShippingStatus />
    },
    "AVI Yield Report" : {
        label : "AVI Yield Report",
        labelKor : "AVI Yield Report",
        children : <AVIYield />
    },
    "PTEST Yield Report" : {
        label : "PTEST Yield Report",
        labelKor : "PTEST Yield Report",
        children : <PTESTYield />
    },
    "Final PTEST Yield Report" : {
        label : "Final PTEST Yield Report",
        labelKor : "최종 PTEST Yield Report",
        children : <FinalPTESTYield />
    },
    "Current Month Sales Status" : {
        label : "Current Month Sales Status",
        labelKor : "당월 판매실적 현황",
        children : <MonthlySalesPerformance />
    },
    "TEST" : {
        label : "TEST",
        labelKor : "테스트",
        children : <LotStatus />
    }
}

interface IProps {
    menuName : string;
};

const Menu = ({menuName}:IProps) => {

    const langState = useSelector((state:RootState)=>state.langReducer);
    const tabList = useSelector((state:RootState)=>state.tabMenuReducer);
    const dispatch = useDispatch();

    const onClick = () => {
        if(tabList.find((element)=>
            element.label===menuName) !==undefined){
            return;
        }

        dispatch(setTabList([...tabList, MenuSet[menuName]]));
    };

    return (
        <S.Container
            onClick={onClick}
        >
            &gt; {langState.isKor ? MenuSet[menuName].labelKor : MenuSet[menuName].label}
        </S.Container>
    );
}

export default Menu;
