import * as A from "../action/alertAction";
import { IAlert } from "../../types/type";

type TAlertAction = ReturnType<typeof A.hideAlertModal> | ReturnType<typeof A.showAlertModal>;

const initialState:IAlert = {
    show : false,
    header : undefined,
    bold : undefined,
    text : undefined,
    callback : undefined,
};

const alertReducer = ( state:IAlert = initialState, action:TAlertAction) => {
    switch (action.type) {
        case A.SHOW_ALERT_MODAL:
            return {
                show : true,
                header: action.payload.header,
                bold: action.payload.bold,
                text : action.payload.text,
                callback: action.payload.callback
            };
        case A.HIDE_ALERT_MODAL:
            return {
                show : false,
                header : undefined,
                bold : undefined,
                text : undefined,
                callback : undefined,
            };
        default :
            return state;
    };
};

export default alertReducer;
