import * as S from './style.Popup';
import {useDispatch} from "react-redux";
import {hideAlertModal} from "../../modules/action/alertAction";
import {IAlert} from "../../types/type";
import Button from "./Button";
import {useEffect, useRef} from "react";

const Popup = ({ header , bold , text , show , callback }:IAlert) => {
    const dispatch = useDispatch();
    const popUpRef = useRef<HTMLInputElement>(null);

    const onKeydown = (event : React.KeyboardEvent) => {
        if(event.key ==="Enter" || event.key ==="Escape"){
            dispatch(hideAlertModal());
        }
    };

    const onClick = (event : React.MouseEvent) => {
        if(event.currentTarget === event.target){
            dispatch(hideAlertModal());
        }
    }

    useEffect(()=>{
        // @ts-ignore
        popUpRef.current.focus();
    },[show])

    return (
        <S.Container
            tabIndex={0}
            show={show}
            onKeyDown={onKeydown}
            onClick={onClick}
        >
            <div className='modal-body'>
                <div className='modal-header'>
                    <h3>{header}</h3>
                </div>
                <div className='modal-content'>
                    <span className='modal-bold'>
                        {bold}
                    </span>
                    <span className='modal-text'>
                        {text}
                    </span>
                </div>
                <div className='button-container'>
                    <Button text="닫기" onClick={onClick}/>
                </div>
                <input className="hidden" type="text" ref={popUpRef}/>
            </div>
        </S.Container>
    );
}

export default Popup;
