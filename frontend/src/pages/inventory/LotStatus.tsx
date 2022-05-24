import * as S from './style.LotStatus';
import {useEffect, useState} from "react";
import {useSelector} from "react-redux";
import {RootState} from "../../modules";
import useTitle from "../../utils/UseHooks";
import H2 from "../../components/common/H2";
import SearchSelector from "../../components/form/SearchSelector";
import ApiUtil from "../../utils/ApiUtil";
import {ICustomer, IDevice, IOperation} from "../../types/userData";
import {ISearchBox} from "../../types/type";



const LotStatus = () => {

    const [checkedCustomers, setCheckedCustomers] = useState<ISearchBox[]>([]);
    const [customers, setCustomers] = useState<ISearchBox[]>([]);
    const [checkedOperations, setCheckedOperations] = useState<ISearchBox[]>([]);
    const [operations, setOperations] = useState<ISearchBox[]>([]);
    const [operationsC, setOperationsC] = useState<ISearchBox[]>([]);
    const [checkedDevices, setCheckedDevices] = useState<ISearchBox[]>([]);
    const [devices, setDevices] = useState<ISearchBox[]>([]);
    const [devicesC, setDevicesC] = useState<ISearchBox[]>([]);

    const langState = useSelector((state:RootState) => state.menuReducer);

    useTitle(" : LOT 정보 조회");

    const onSubmit = (event : React.FormEvent<HTMLFormElement>) => {
        event.preventDefault();
    }

    useEffect(()=>{
        async function callAPI(){
            const res = await ApiUtil.get(
                "/condition/customerAndOperationAndDevice",
            )
            // 초기화
            customers.splice(0,customers.length);
            res.data.customers.map((customer : ICustomer) => {
                return customers.push({
                    id: customer.customer,
                    text : customer.customerName,
                })
            })
            setCustomers(customers);
            operations.splice(0,operations.length);
            res.data.operations.map((operation : IOperation) => {
                return operations.push({
                    id: operation.operation,
                    text : operation.description,
                    condition : operation.customer
                })
            })
            setOperations(operations);
            devices.splice(0,devices.length);
            res.data.devices.map((device : IDevice) => {
                return devices.push({
                    id: device.deviceId,
                    text : device.description,
                    condition : device.customer
                })
            })
            setDevices(devices);
            changeCondition();
        }
        callAPI();
    },[ customers , operations, devices ]);

    useEffect(()=>{
        changeCondition();
    }, [checkedCustomers , operations , devices]);

    const changeCondition = () => {
        operationsC.splice(0,operationsC.length);
        devicesC.splice(0,devicesC.length);
        if(checkedCustomers.length === 0){
            operations.map((operation)=>{
                if(!!operationsC.find((element)=>operation.id === element.id)){
                    return null;
                }
                return operationsC.push(operation)
            })
            devices.map((device)=>{
                if(!!devicesC.find((element)=>device.id === element.id)){
                    return null;
                }
                return devicesC.push(device);
            })
        }else {
            operations.map((operation)=>{
                if(!checkedCustomers.find((element)=> operation.condition===element.id)){
                    return null;
                }else if(!!operationsC.find((element)=>operation.id === element.id)){
                    return null;
                }
                else operationsC.push(operation);
            })
            devices.map((device)=>{
                if(!checkedCustomers.find((element)=> device.condition===element.id)){
                    return null;
                }else if(!!devicesC.find((element)=>device.id === element.id)){
                    return null;
                }
                else devicesC.push(device);
            })
        }
        setOperationsC([...operationsC]);
        setDevicesC([...devicesC]);
    }

    return (
        <S.Container>
            <H2 text={langState.isKor ? "LOT 정보 조회" : "View Lot Status" }/>
            <form onSubmit={onSubmit}>
                <SearchSelector
                    title={langState.isKor ? "고객" : "Customer"}
                    list={customers}
                    selected={checkedCustomers}
                    selector={setCheckedCustomers}
                />
                <SearchSelector
                    title={langState.isKor ? "공정" : "Operation"}
                    list={operationsC}
                    selected={checkedOperations}
                    selector={setCheckedOperations}
                    hasDesc={true}
                />
                <SearchSelector
                    title={langState.isKor ? "제품" : "Device"}
                    list={devicesC}
                    selected={checkedDevices}
                    selector={setCheckedDevices}
                    hasDesc={true}
                />
            </form>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
        </S.Container>
    )
}

export default LotStatus;
