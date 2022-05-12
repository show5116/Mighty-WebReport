import { CallbackFunction } from "../../types/type";

export const SHOW_ALERT_MODAL = 'SHOW_ALERT_MODAL';

export const HIDE_ALERT_MODAL = 'HIDE_ALERT_MODAL';

export const showAlertModal = ( header:string,bold:string,text:string,callback?:CallbackFunction) =>{
    return {
        type : SHOW_ALERT_MODAL,
        payload : {
            show: true,
            header: header,
            bold: bold,
            text: text,
            callback: callback
        }
    };
};

export const hideAlertModal = () => {
    return {
        type : HIDE_ALERT_MODAL,
        payload : {
            show : false,
            header : undefined,
            bold : undefined,
            text : undefined,
            callback : undefined,
        }
    };
};
