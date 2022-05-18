import * as S from './style.DarkToggle';
import Icon from "../../common/Icon";
import {useDispatch, useSelector} from "react-redux";
import {RootState} from "../../../modules";
import {setDarkMode, setWhiteMode} from "../../../modules/action/darkAction";
import React from "react";

const DarkToggle = () => {

    const dispatch = useDispatch();
    const darkState = useSelector((state:RootState) => state.darkReducer);

    const Sun = () => (<Icon icon="sun" size={14} className='sun' />)
    const Moon = () => (<Icon icon="moon" size={13} className='moon' />)

    const onClick = (event : React.ChangeEvent<HTMLInputElement>) => {
        if(event.target.checked){
            dispatch(setDarkMode());
        }else{
            dispatch(setWhiteMode());
        }
    }

    return(
        <S.Container>
            <label htmlFor="dark-btn" className="toggler">
                <input onChange={onClick} checked={darkState.isDark} type="checkbox" id="dark-btn"/>
                <span className="ball"></span>
                <Sun />
                <Moon />
            </label>
        </S.Container>
    );
};

export default DarkToggle;
