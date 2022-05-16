import { combineReducers } from 'redux';
import alertReducer from "./reducer/alertReducer";
import authReducer from "./reducer/authReducer";
import menuReducer from "./reducer/menuReducer";

const rootReducer = combineReducers({
    alertReducer,
    authReducer,
    menuReducer
});

export default rootReducer;

export type RootState = ReturnType<typeof rootReducer>;
