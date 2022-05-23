import axios from "axios";

const ApiUtil = axios.create({
    baseURL : 'http://localhost:8080',
    timeout: 30000,
    headers: {
        "Content-Type" : 'application/json;charset=UTF-8',
        "Access-Control_Allow_Origin" : "*",
        "Accept" : "application/json",
    }
});

ApiUtil.interceptors.request.use(
    function (config) {
        if(config.headers !== undefined){
            const token = localStorage.getItem('auth-token');
            if(token===null || token === undefined){
                config.headers.Authorization = "";
            }else{
                config.headers.Authorization = token;
            }
        }
        return config;
    }
)

export default ApiUtil;
