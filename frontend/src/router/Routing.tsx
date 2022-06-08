import {Route, Routes, useNavigate} from "react-router-dom";
import * as S from './style.Routing';
import Home from "../pages/Home";
import Login from "../pages/auth/Login";
import {useDispatch, useSelector} from "react-redux";
import {RootState} from "../modules";
import {useEffect} from "react";
import NotFound from "../pages/NotFound";
import {setLogOut} from "../modules/action/authAction";

const Routing = () => {

    const dispatch = useDispatch();
    const authState = useSelector((state:RootState) => state.authReducer);
    const navigate = useNavigate();

    useEffect(()=>{
        if(window.location.pathname !== "/login" &&
            (!authState.isLogin ||
            localStorage.getItem("auth-token")===null ||
            localStorage.getItem("auth-token")===undefined)) {
            dispatch(setLogOut());
            navigate("/login?error=token-error");
        }
    },[dispatch,navigate,authState.isLogin]);


    return (
        <S.Container>
            <Routes>
                <Route path="/" element={<Home />} />
                <Route path="/login" element={<Login />} />
                <Route path='*' element={<NotFound />}/>
            </Routes>
        </S.Container>
    );
}

export default Routing;
