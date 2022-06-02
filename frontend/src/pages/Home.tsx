import * as S from './style.Home';
import {useDispatch, useSelector} from "react-redux";
import {RootState} from "../modules";
import {useEffect} from "react";
import {initTabList} from "../modules/action/tabMenuAction";
import TabMenu from "../components/tabmenu/TabMenu";
import useTitle from "../utils/UseHooks";

const Home = () => {

    const tabList = useSelector((state:RootState)=>state.tabMenuReducer);
    const dispatch = useDispatch();

    useEffect(()=>{
        dispatch(initTabList());
    },[])

    useTitle("");

    return (
        <S.Container>
            {tabList.length === 0
                ?
                (<div className='home-container' />)
                :
                (<TabMenu />)
            }

        </S.Container>
    );
}

export default Home;
