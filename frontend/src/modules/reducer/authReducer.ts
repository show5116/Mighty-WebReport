import * as A from '../action/authAction';

type TAuthAction = ReturnType<typeof A.setLogIn> | ReturnType<typeof A.setLogOut>;

interface IAuth {
    isLogin: boolean;
}

const initialState:IAuth = {
    isLogin: false,
};

const authReducer = ( state:IAuth = initialState, action:TAuthAction) => {
    switch (action.type) {
        case A.SET_LOG_IN :
            return {
                isLogin: true,
            };
        case A.SET_LOG_OUT :
            return {
                isLogin: false,
            };
        default :
            return state;
    };
};

export default authReducer;
