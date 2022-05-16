import {Route, Routes, useNavigate} from "react-router-dom";
import * as S from './style.Routing';
import Home from "../pages/Home";
import Login from "../pages/auth/Login";
import {useDispatch, useSelector} from "react-redux";
import {RootState} from "../modules";
import {useEffect} from "react";
import {setLogIn} from "../modules/action/authAction";

const Routing = () => {

    const dispatch = useDispatch();
    const authState = useSelector((state:RootState) => state.authReducer);
    const navigate = useNavigate();

    useEffect(()=>{
        if(!authState.isLogin) {
            const token = localStorage.getItem('auth-token');
            if(!!token && token!==undefined){
                dispatch(setLogIn());
            }else{
                navigate("/login");
            }
        }
    },[dispatch,navigate,authState.isLogin])


    return (
        <S.Container>
            <Routes>
                <Route path="/" element={<Home />} />
                <Route path="/login" element={<Login />} />
            </Routes>
        </S.Container>
    );
}

export default Routing;
