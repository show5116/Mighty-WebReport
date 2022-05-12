import * as S from './style.Login';
import Button from "../../components/common/Button";
import Input from "../../components/common/Input";
import Icon from "../../components/common/Icon";
import color from "../../styles/color";
import Select from "../../components/common/Select";
import {useEffect, useState} from "react";
import ApiUtil from "../../utils/ApiUtil";
import {Option} from "../../types/type";
import {IPlantTable} from "../../types/userData";
import {useDispatch} from "react-redux";
import {showAlertModal} from "../../modules/action/alertAction";

const Login = () => {
    const dispatch = useDispatch();
    const [userId,setUserId] = useState("");
    const [password,setPassword] = useState("");
    const [plant,setPlant] = useState("");
    const [plants,setPlants] = useState<Array<Option>>([{text: "PLANT", value: "NotC"}]);

    const onChangeId = (event : React.ChangeEvent<HTMLInputElement>) => {
        setUserId(event.target.value);
    }

    const onChangePassword = (event : React.ChangeEvent<HTMLInputElement>) => {
        setPassword(event.target.value);
    }

    const onChangeSelect = (event : React.ChangeEvent<HTMLSelectElement>) => {
        setPlant(event.target.value);
    }

    const onSubmit = (event : React.FormEvent<HTMLFormElement>) => {
        event.preventDefault();

        const user : object = {
            id : userId,
            password : password,
            plant : plant
        };

        async function callAPI(){
            await ApiUtil.post("/auth/signin", user)
                .then((res)=>{
                    console.log(res);
                })
                .catch((error)=>{
                    console.log(error);
                    dispatch(showAlertModal('경고 메세지','비밀번호','가 틀렸습니다.',undefined));
                });
        }

        callAPI();
    };

    useEffect(()=>{
        const removeBlankId : string = userId.replace(/ /g,"");
        if(removeBlankId === ""){
            return
        }
        async function callAPI(){
            const res = await ApiUtil.get(
                "/auth/plant",
                {
                    params : {
                        userId : removeBlankId
                    }
            });
            if(res.data.length===0){
                setPlants([{text: "PLANT", value: "NotC"}]);
                return;
            }else{
                setPlants([]);
                res.data.map((data : IPlantTable) => {
                    return setPlants((prev) => {
                        return [...prev,
                            {
                                text : data.id,
                                value : data.id
                            }]
                    });
                });
            }
        }
        callAPI();
    },[userId])

    useEffect(()=>{
        if(plants[0].text==="PLANT"
            &&plants[0].value==="NotC"){
            setPlant("");
            return
        }
        setPlant(plants[0].text);
    },[plants])

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
                    <Select options={plants} onChange={onChangeSelect} />
                    <div className="button-container">
                        <Button
                            disabled={plant===""}
                            color={color.babyBlue}
                            text="로그인"
                        />
                    </div>
                </form>
            </div>
        </S.Container>
    );
}

export default Login;
