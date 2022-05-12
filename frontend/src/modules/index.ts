import { combineReducers } from 'redux';
import alertReducer from "./reducer/alertReducer";

const rootReducer = combineReducers({
    alertReducer
});

export default rootReducer;

export type RootState = ReturnType<typeof rootReducer>;
