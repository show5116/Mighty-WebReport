<h1>MIGHTY WebReport Project Front-End</h1>

<h2>Index</h2>

- <a href="#dependencies">Dependencies</a>
- <a href="#priorKnowledge">Prior Knowledge</a>
- <a href="#package">Package</a>
  * <a href="#패키지구조">패키지 구조</a> 
  * <a href="#네이밍규칙">네이밍 규칙</a> 
- <a href="#config">Config</a>
  * <a href="#index">index.tsx</a>
  * <a href="#App">App.tsx</a>
  * <a href="#api">API</a>
- <a href="#commandLine">Command Line</a>
- <a href="#guide">Guide</a>
  * <a href="#component">Component 관리</a>
  * <a href="#svg">svg 관리</a>
  * <a href="#color">color 관리</a>
  * <a href="#redux">Redux 관리</a>
  * <a href="#popup">PopUp창 사용하기</a>
  * <a href="#menu">메뉴 관리</a>
- <a href="#etc">Etc</a>

<h2 id="dependencies">Dependencies</h2>

|        **기술명**        | **버전** | **설명**                                     |
|:---------------------:|:------:|:-------------------------------------------|
|       **React**       | 18.1.0 | 함수형 Component 기반 View Template(Create App) |
| **React-Router-Dom**  | 6.3.0  | 사용자가 요청한 URI 에 맞는 화면 Routing               |
|    **React-Redux**    | 8.0.1  | 상태관리 라이브러리                                 |
|    **Redux-Saga**     | 1.1.3  | generator 기반 redux 미들웨어, 상태관리 비동기처리 담당     |
| **styled-components** | 5.3.5  | SCSS 문법으로 js를 활용해 CSS 를 동적으로 작성            |
|    **typescript**     | 4.6.4  | javascript 컴파일러 (런타임 에러 방지)                |
|       **axios**       | 0.27.2 | Promise 기반 request 요청 생성                   |

<h2 id="priorKnowledge">Prior Knowledge</h2>

- javaScript
    * <a href="https://developer.mozilla.org/ko/docs/Web/JavaScript/Reference/Global_Objects/Array">배열 다루기</a>(<a href="https://developer.mozilla.org/ko/docs/Web/JavaScript/Reference/Global_Objects/Array/map">map</a>,<a href="https://developer.mozilla.org/ko/docs/Web/JavaScript/Reference/Global_Objects/Array/find">find</a>,<a href="https://developer.mozilla.org/ko/docs/Web/JavaScript/Reference/Global_Objects/Array/splice">splice</a> 등...)
    * <a href="https://developer.mozilla.org/ko/docs/Learn/JavaScript/Objects/JSON">JSON</a>

- 리엑트 기초(<a href="https://ko.reactjs.org/tutorial/tutorial.html">참고자료</a>)
    * <a href="https://ko.reactjs.org/docs/hooks-state.html">useState Hook</a>
    * <a href="https://ko.reactjs.org/docs/hooks-effect.html">useEffect Hook</a>

- Redux 사용법(<a href="https://velog.io/@velopert/use-typescript-and-redux-like-a-pro">참고자료</a>)

- React Router dom v6 사용법(<a href="https://velog.io/@soryeongk/ReactRouterDomV6">참고자료</a>)

- typeScript(<a href="https://github.com/show5116/LearnTypeScript">참고자료</a>)

- SCSS 문법(<a href="https://seokzin.tistory.com/entry/SCSS-SCSS-%EB%AC%B8%EB%B2%95-%EC%A0%95%EB%A6%AC">참고자료</a>)
    * <a href="https://studiomeal.com/archives/197">flex 다루기</a>
    * <a href="https://studiomeal.com/archives/533">grid 다루기</a>

<h2 id="package">Package</h2>

<h3 id="패키지구조">패키지 구조</h3>

```bash
├── src/
│   ├── assets/
│   ├── components/
│   │   ├── common/
│   │   ├── form/
│   │   └── layout/
│   ├── modules/
│   │   ├── action/
│   │   ├── reducer/
│   │   └── saga/
│   ├── pages/
│   ├── router/
│   ├── styles/
│   ├── types/
│   ├── utils/
│   ├── App.tsx
│   └── index.tsx
├── config/
└── public/
```

|     패키지명     | 설명                                                |
|:------------:|:--------------------------------------------------|
|    assets    | img,png,svg 등의 정적 파일 관리                           |
|  components  | page 내부에 사용될 Component들을 관리                       |
|   modules    | redux를 통한 상태관리 폴더, action에서 상태관리 선언, reducer에서 관리 |
|    pages     | 사용자들에게 보여줄 page들 관리                               |
|    router    | URI와 pages를 매핑해주어서 화면을 구성                         |
|    styles    | 글로벌 style관리, color 변수명으로 관리                       |
|    types     | Component에서 사용할 타입들을 선언, DTO의 타입 정의               |
|    utils     | request등.. utils 관리                               |

<h3 id="네이밍규칙">네이밍 규칙</h3>

- Conponents들은 (tsx 파일) 첫문자를 대문자로하는 PascalCase

- style 파일들은 style.(Component명).ts

- 이외의 파일들은 camelCase

<h2 id="config">Config</h2>

<h3 id="index"><a href="/src/index.tsx">index.tsx</a></h3>

```typescript jsx
root.render(
  <React.StrictMode>
      <BrowserRouter>
          <Provider store={store}>
              <PersistGate persistor={persistor}>
                  <App />
              </PersistGate>
          </Provider>
      </BrowserRouter>
  </React.StrictMode>
);
```

BrowerRouter => React-router-dom 사용</br>
Provider => Redux 사용</br>
PersistGate => Redux Persist 사용(새로고침이나, 브라우저 꺼졌다 켜져도 유지)

<h3 id="App"><a href="">App.tsx</a></h3>

```typescript jsx
<div className="App">
    <GlobalStyle />
    <Header />
    <Routing />
    <Footer />
    <Popup
        show={alertState.show}
        header={alertState.header}
        bold={alertState.bold}
        text={alertState.text}
        callback={alertState.callback}
    />
</div>
```

- App 레이아웃
  * Header : Logo 및 메뉴바 포함
  * Routing : 페이지 내용이 들어갈 곳
  * Footer : copyright 및 회사정보
  * Popup : redux로 호출시 부드러운 alert 사용

<h3 id="api"><a href="/src/utils/ApiUtil.ts">API</a></h3>

```typescript
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
              window.location.href="/login";
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
          const errorCode : string = response.headers.code;
          if(errorCode === "000" ||
                  errorCode === "001" ||
                  errorCode === "002" ||
                  errorCode === "003" ||
                  errorCode === "004"){
            // auth-token 에러
            const token = localStorage.getItem('auth-token');
            if(token!==null && token !== undefined){
              localStorage.removeItem("auth-token")
            }
            window.location.href="/login?error=token-error";
          }else if(errorCode === "005" ||
                  errorCode === "006" ||
                  errorCode === "010") {
            // authorized 에러
            window.location.href = "/";
          }
          return response;
        }
);
```

request 요청을 만들어주고, interceptor를 활용해서 header에 auth-token을 보내줍니다.</br>
Back-End에선 요청에 이상이 있으면 errorCode를 발급하여서 마찬가지로 interceptor에서 뺏어와서 에러처리를 해줌.</br>

<h2 id="commandLine">Command Line</h2>

```
    $ npx create-react-app frontend --template typescript
    $ cd frontend
    $ npm i axios
    $ npm i react-router-dom
    $ npm i --save-dev @types/styled-components
    $ npm i redux
    $ npm i react-redux
    $ npm i @types/react-redux
    $ npm i redux-devtools-extension
    $ npm i redux-logger
    $ npm i @reduxjs/toolkit react-redux
    $ npm i redux-saga
    $ npm i redux-persist
    $ npm i immer
```

<h2 id="guide">Guide</h2>

<h3 id="component">Component 관리</h3>

<a href="/src/components/common/Button.tsx">Button.tsx</a>

```typescript jsx
// style.Button.ts 파일을 생성 후, 아래와 같은 규칙으로 import
// import * as S from './style.~~~~~~';
import * as S from './style.Button';

// Component 내부에서만 사용할 타입을 정의해줌
type type = "button" | "submit" | "reset" ;

// Conponent props를 정의해줍니다. 
interface IProps extends React.SelectHTMLAttributes<HTMLButtonElement> {
    text : string;
    color? : string;
    to?: string;
    type? : type;
    disabled? : boolean;
}

// 정의된 props를 활용해 Component를 만들어줍니다.
// {...props}는 위에서 props 정의하지 않은값을 전부다 가져옵니다.
const Button = ({ text , color , to , type , disabled = false , ...props }: IProps) => {
    return (
        <S.Container
            style={{
                backgroundColor : color
            }}
            disabled={disabled}
            type={type}
            {...props}
        >
            {text}
        </S.Container>
    );
}

export default Button;
```

<a href="/src/components/common/style.Button.ts">style.Button.ts</a>

```typescript
import styled from "styled-components";
import color from "../../styles/color";

export const Container = styled.button`
  cursor: pointer;
  width: 100%;
  border: 0;
  border-radius: 20px;
  font-size: 20px;
  font-weight: bold;
  position: relative;
  box-shadow: rgba(0,0,0,0.20) 0px 2px 4px;
  transition: 0.15s ease-in-out;
  &:hover{
    opacity: 0.7;
  }
  &:disabled{
    cursor : default;
    color : inherit;
    opacity: 1.0;
    background-color: ${color.lightgray} !important;;
  }
  .buttonText {
    width: 100%;
    margin: 0;
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%,-50%);
  }
`;
```

디자인은 styled-components를 활용해 scss문법으로 디자인 합니다.

<h3 id="svg">svg 관리</h3>

<a href="/src/assets/svg/constants.ts">constants.ts</a>

```typescript
// 이곳에 사용할 icon 이름을 정의해주면 됩니다.
export type iconName = "account" | "lock" | "logout" | "factory" |
    "sun" | "moon" | "search" | "x" | "change" | "caretDown" | "arrow" |
    "expand" | "minimize" | "doubleUp" | "doubleDown" | "excel";
```

```typescript
// 이곳에 svg파일의 path, viewBox 등의 정보를 기입해줍니다.
const IconSet: Record<iconName, icon> = {
  account: {
    path: "M15.71,12.71a6,6,0,1,0-7.42,0,10,10,0,0,0-6.22,8.18,1,1,0,0,0,2,.22,8,8,0,0,1,15.9,0,1,1,0,0,0,1,.89h." +
            "11a1,1,0,0,0,.88-1.1A10,10,0,0,0,15.71,12.71ZM12,12a4,4,0,1,1,4-4A4,4,0,0,1,12,12Z",
    viewBox: "0 0 24 24",
  },
  moon: {
    path: "M18 9.79A9 9 0 1 1 8.21 0 7 7 0 0 0 18 9.79z",
    viewBox: "0 0 20 20",
    fill: "none",
    fillRule: "evenodd",
    stroke: "#000",
    strokeLinecap: "round",
    strokeLinejoin: "round",
    strokeWidth: "2",
    transform: "translate(1 1)"
  },
}
```

<a href="/src/pages/auth/Login.tsx">Login.tsx</a>의 일부

```typescript jsx
    const Account = () => (<Icon icon="account" size={svgSize} color={svgColor} />)
    const Lock = () => (<Icon icon="lock" size={svgSize} color={svgColor} />)
    const Factory = () => (<Icon icon="factory" size={20} />);
```

<a href="/src/components/common/Icon.tsx">Icon.tsx</a>컴포넌트를 불러내어서 svg를 자유롭게 다뤄줄 수 있습니다.

<h3 id="color">color 관리</h3>

<a href="/src/styles.color.ts">color.ts</a>
```typescript
const color = {
    blue : '#7FB5FF',
    babyBlue : '#C4DDFF',
    darkBlue: '#1d3557',
    grayBlue: '#457b9d',
}
```
추가할 color를 json 형식으로 추가해주고, 불러올때 color.blue 로 불러와서 사용(<a href="/src/components/common/style.H2.ts">참고</a>)

<h3 id="redux">Redux 관리</h3>

<a href="/src/modules/index.ts">index.ts</a>
```typescript
// blacklist 는 새로고침할 시 데이터를 잃어버릴것을 넣어주면됩니다.
const persistConfig = {
    key : "root",
    storage : storage,
    blacklist: ["tabMenuReducer"]
}

// 새로이 reducer를 만들어줄때는 여기에 사용하는것을 정의해줍니다.
const rootReducer = combineReducers({
    alertReducer,
    authReducer,
    langReducer,
    tabMenuReducer,
    darkReducer,
});
```

<h3 id="popup">PopUp창 사용하기</h3>

<a href="/src/pages/auth/Login.tsx">Login.tsx</a>의 일부
```typescript
const dispatch = useDispatch();
dispatch(showAlertModal('경고 메세지','비밀번호','가 틀렸습니다.',undefined));
// 첫번째 인자는 Popup title, 두번째 인자는 강조Text(빨간색), 세번째는 나머지 Text, 네번째 인자는 CallbackFunction 입니다.
```

<h3 id="menu">메뉴 관리</h3>

<a href="/src/components/layout/header/Menu.tsx">Menu.tsx</a>

```typescript jsx
// DataBase에서 끌고올 메뉴를 미리 선언해주어야 합니다.(typeScript는 미선언시 에러)
// Router방식을 통해서 페이지를 로드할 경우에는 DB 데이터 자체만으로 연동이 가능하나,
// TabMenu 방식과 typescript와의 연동때문에 반드시 선언을 해주어야합니다.
type menuName = string | "Daily Movement" | "Operation Movement Monitoring" |
    "Daily Shipping Status" | "Fab Out Status By Device" | "View LOT Status" |
    "AVI Yield Report" | "PTEST Yield Report" | "Final PTEST Yield Report" |
    "Current Month Sales Status" | "View Defect Status" |
    "TEST";

// 위에서 선언한 메뉴 Data를 Component와 엮어줘야합니다.
const MenuSet: Record<menuName, ITab> = {
  "Daily Movement": {
    label: "Daily Movement",
    labelKor: "Daily Movement",
    children: <LotStatus / >
  }
}
```

<h2 id="etc">Etc</h2>

- 사용한 폰트 : <a href="https://cactus.tistory.com/306">Pretendard</a>

- Component들의 사용법은 IProps 선언한 것을 보면 알 수 있습니다. 그래도 이해가 안가는 부분이나 궁금한점은 연락 부탁드립니다.

