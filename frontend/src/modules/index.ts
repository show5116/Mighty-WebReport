import { combineReducers } from 'redux';
import alertReducer from "./reducer/alertReducer";
import authReducer from "./reducer/authReducer";

const rootReducer = combineReducers({
    alertReducer,
    authReducer,
});

export default rootReducer;

export type RootState = ReturnType<typeof rootReducer>;
