import {Route, Routes} from "react-router-dom";
import * as S from './style.Routing';
import Home from "../pages/Home";
import Login from "../pages/auth/Login";


const Routing = () => {
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
