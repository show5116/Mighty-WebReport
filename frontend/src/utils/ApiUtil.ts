import axios from "axios";

export const LoginUtil = axios.create({
    baseURL : `http://${window.location.hostname}:8080`,
    timeout: 30000,
    headers: {
        "Content-Type" : 'application/json;charset=UTF-8',
        "Access-Control_Allow_Origin" : "*",
        "Accept" : "application/json",
    }
});

const ApiUtil = axios.create({
    baseURL : `http://${window.location.hostname}:8080`,
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
                // 여기선 토큰이 사라진거
                // 강제 login 페이지로 리다이렉트
                config.headers.Authorization = "";
            }else{
                config.headers.Authorization = token;
            }
        }
        return config;
    }
)

ApiUtil.interceptors.response.use(
  function (response){
      if(response.headers.code === "000"){
          window.location.href="/login";
      }else if(response.headers.code === "001"){
          window.location.href="/login";
      }else if(response.headers.code === "002"){
          window.location.href="/login";
      }else if(response.headers.code === "003"){
          window.location.href="/login";
      }else if(response.headers.code === "004"){
          window.location.href="/login";
      }else if(response.headers.code === "005"){
          window.location.href="/login";
      }else if(response.headers.code === "006"){
          window.location.href="/login";
      }else if(response.headers.code === "010"){
          window.location.href="/login";
      }
  }
);

export default ApiUtil;
