import {combineReducers, createStore} from 'redux';
import {persistReducer, persistStore} from "redux-persist";
import storage from "redux-persist/lib/storage";
import alertReducer from "./reducer/alertReducer";
import authReducer from "./reducer/authReducer";
import langReducer from "./reducer/langReducer";
import darkReducer from "./reducer/darkReducer";
import tabMenuReducer from "./reducer/tabMenuReducer";

const persistConfig = {
    key : "root",
    storage : storage,
    blacklist: ["tabMenuReducer"]
}

const rootReducer = combineReducers({
    alertReducer,
    authReducer,
    langReducer,
    tabMenuReducer,
    darkReducer,
});

const myPersistReducer = persistReducer(persistConfig,rootReducer);

const store = createStore(myPersistReducer);

export const persistor = persistStore(store);
export default store;

export type RootState = ReturnType<typeof rootReducer>;
