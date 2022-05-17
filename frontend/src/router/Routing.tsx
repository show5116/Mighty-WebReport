import {Route, Routes, useNavigate} from "react-router-dom";
import * as S from './style.Routing';
import Home from "../pages/Home";
import Login from "../pages/auth/Login";
import {useDispatch, useSelector} from "react-redux";
import {RootState} from "../modules";
import {useEffect} from "react";
import NotFound from "../pages/NotFound";
import DailyShippingStatus from "../pages/product/DailyShippingStatus";
import DeviceShippingStatus from "../pages/product/DeviceShippingStatus";
import InventoryStatus from "../pages/inventory/InventoryStatus";
import LotStatus from "../pages/inventory/LotStatus";
import MonthlySalesPerformance from "../pages/sales/MonthlySalesPerformance";
import AVIYield from "../pages/yield/AVIYield";
import PTESTYield from "../pages/yield/PTESTYield";
import FinalPTESTYield from "../pages/yield/FinalPTESTYield";

const Routing = () => {

    const dispatch = useDispatch();
    const authState = useSelector((state:RootState) => state.authReducer);
    const navigate = useNavigate();

    useEffect(()=>{
        if(!authState.isLogin) {
            navigate("/login");
        }
    },[dispatch,navigate,authState.isLogin])


    return (
        <S.Container>
            <Routes>
                <Route path="/" element={<Home />} />
                <Route path="/login" element={<Login />} />
                <Route path="/product">
                    <Route path="daily-shipping-status" element={<DailyShippingStatus />} />
                    <Route path="device-shipping-status" element={<DeviceShippingStatus />} />
                </Route>
                <Route path="/inventory">
                    <Route path="status" element={<InventoryStatus />} />
                    <Route path="lot-status" element={<LotStatus />} />
                    <Route path="AVI-yield" element={<AVIYield />} />
                    <Route path="PTEST-yield" element={<PTESTYield />} />
                    <Route path="final-PTEST-yield" element={<FinalPTESTYield />} />
                </Route>
                <Route path="/sales">
                    <Route path="monthly-sales-performance" element={<MonthlySalesPerformance />} />
                </Route>
                <Route path='*' element={<NotFound />}/>
            </Routes>
        </S.Container>
    );
}

export default Routing;
