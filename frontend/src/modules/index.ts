import {combineReducers, createStore} from 'redux';
import alertReducer from "./reducer/alertReducer";
import authReducer from "./reducer/authReducer";
import menuReducer from "./reducer/menuReducer";
import {persistReducer, persistStore} from "redux-persist";
import storage from "redux-persist/lib/storage";

const persistConfig = {
    key : "root",
    storage : storage
}

const rootReducer = combineReducers({
    alertReducer,
    authReducer,
    menuReducer
});

const myPersistReducer = persistReducer(persistConfig,rootReducer);

const store = createStore(myPersistReducer);

export const persistor = persistStore(store);
export default store;

export type RootState = ReturnType<typeof rootReducer>;
