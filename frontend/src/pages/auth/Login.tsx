import * as S from './style.Login';
import Button from "../../components/common/Button";
import Input from "../../components/common/Input";
import Icon from "../../assets/svg/Icon";
import color from "../../styles/color";
import Select from "../../components/common/Select";
import {useEffect, useState} from "react";
import ApiUtil from "../../utils/ApiUtil";
import {Option} from "../../types/type";
import {IPlantTable} from "../../types/userData";

const Login = () => {

    const [userId,setUserId] = useState("");
    const [password,setPassword] = useState("");
    const [plant,setPlant] = useState<Array<Option>>([]);

    const onChangeId = (event : React.ChangeEvent<HTMLInputElement>) => {
        setUserId(event.target.value);
    }

    const onChangePassword = (event : React.ChangeEvent<HTMLInputElement>) => {
        setPassword(event.target.value);
    }

    const onSubmit = (event : React.FormEvent<HTMLFormElement>) => {
        event.preventDefault();

        const user : object = {
          id : userId,
          password : password
        };

        async function callAPI(){
            const res = await ApiUtil.post("/auth/signin", user);
        }

        callAPI();
    };

    useEffect(()=>{
        const removeBlankId : string = userId.replace(/ /g,"");
        if(removeBlankId === ""){
            return
        }
        const user : object = {
            userId : removeBlankId
        }
        async function callAPI(){
            const res = await ApiUtil.get(
                "/auth/plant",
                {
                    params : {
                        userId : removeBlankId
                    }
            });
            console.log(res.data);
            setPlant([]);
            res.data.map((data : IPlantTable) => {
                setPlant((prev) => {
                    return [...prev,
                        {
                            text : data.description,
                            value : data.id
                        }]
                });
            });
        }
        callAPI();
    },[userId])

    useEffect(()=>{
        console.log(plant);
    },[plant])

    const svgSize : number = 20;
    const svgColor = color.gray;
    const Account = () => (<Icon icon="account" size={svgSize} color={svgColor} />)
    const Lock = () => (<Icon icon="lock" size={svgSize} color={svgColor} />)

    return (
        <S.Container>
            <div className='form-container'>
                <form onSubmit={onSubmit} className="login-form">
                    <div className="form-title">
                        <h2 className="form-title">로그인</h2>
                    </div>
                    <Input
                        onChange={onChangeId}
                        name="id"
                        value={userId}
                        svg={<Account />}
                        place="아이디를 입력해주세요"
                        required={true}
                        autoFocus={true}
                    />
                    <Input
                        onChange={onChangePassword}
                        name="password"
                        value={password}
                        svg={<Lock />}
                        place="비밀번호를 입력해주세요"
                        required={true}
                        type="password" />
                    <Select options={plant}/>
                    <Button text="로그인버튼" />
                </form>
            </div>
        </S.Container>
    );
}

export default Login;
