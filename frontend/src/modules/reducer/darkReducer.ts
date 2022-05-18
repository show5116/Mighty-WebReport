import * as A from '../action/darkAction';

type TDarkAction = ReturnType<typeof A.setDarkMode> | ReturnType<typeof A.setWhiteMode>;

interface IDark {
    isDark: boolean;
}

const initialState:IDark = {
    isDark: false,
};

const darkReducer = ( state:IDark = initialState, action:TDarkAction) => {
    switch (action.type) {
        case A.SET_DARK_MODE :
            return {
                isDark: true,
            };
        case A.SET_WHITE_MODE :
            return {
                isDark: false,
            };
        default :
            return state;
    };
};

export default darkReducer;
