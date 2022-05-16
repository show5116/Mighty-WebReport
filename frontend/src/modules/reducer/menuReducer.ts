import * as A from '../action/menuAction';

type TMenuAction = ReturnType<typeof A.setMenuKor> | ReturnType<typeof A.setMenuEng>;

interface IMenu {
    isKor: boolean;
}

const initialState:IMenu = {
    isKor: true,
};

const menuReducer = ( state:IMenu = initialState, action:TMenuAction) => {
    switch (action.type) {
        case A.SET_MENU_KOR :
            return {
                isKor: true,
            };
        case A.SET_MENU_ENG :
            return {
                isKor: false,
            };
        default :
            return state;
    };
};

export default menuReducer;
