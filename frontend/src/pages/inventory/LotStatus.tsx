import * as S from './style.LotStatus';
import React, {useEffect, useState} from "react";
import {useSelector} from "react-redux";
import {RootState} from "../../modules";
import useTitle from "../../utils/UseHooks";
import H2 from "../../components/common/H2";
import SearchSelector from "../../components/form/SearchSelector";
import ApiUtil from "../../utils/ApiUtil";
import {ICustomer, IDevice, ILotStatus, IOperation } from "../../types/userData";
import {ISearchBox, TableHeader} from "../../types/type";
import TableForm from "../../components/form/TableForm";
import Icon from "../../components/common/Icon";
import {getDate, getMonthToMinute} from "../../utils/dateUtil";

interface OperationCol {
    colCount: number;
    colName: string;
    colQty1: number;
    colQty2: number;
}

const LotStatus = () => {
    const [checkedCustomers, setCheckedCustomers] = useState<ISearchBox[]>([]);
    const [customers, setCustomers] = useState<ISearchBox[]>([]);
    const [checkedOperations, setCheckedOperations] = useState<ISearchBox[]>([]);
    const [operations, setOperations] = useState<ISearchBox[]>([]);
    const [operationsC, setOperationsC] = useState<ISearchBox[]>([]);
    const [checkedDevices, setCheckedDevices] = useState<ISearchBox[]>([]);
    const [devices, setDevices] = useState<ISearchBox[]>([]);
    const [devicesC, setDevicesC] = useState<ISearchBox[]>([]);
    const [searchData,setSearchData] = useState<ILotStatus[]>([]);
    const [isLookDown,setIsLookDown] = useState(false);
    const [tableBodies, setTableBodies] = useState<JSX.Element>((<tbody></tbody>));

    const langState = useSelector((state:RootState) => state.menuReducer);

    useTitle(" : LOT 정보 조회");

    const tableHeaders:TableHeader[] = [
        {text:"공정" , width: "130px"},
        {text:"LOT" , width: "130px"},
        {text:"Main Lot" , width: "80px"},
        {text:"수량1" , width: "44px"},
        {text:"단위" , width: "40px"},
        {text:"수량2" , width: "44px"},
        {text:"단위" , width: "40px"},
        {text:"제품" , width: "70px"},
        {text:"고객사" , width: "80px"},
        {text:"잠금" , width: "34px"},
        {text:"재작업" , width: "48px"},
        {text:"HOLD 메모" , width: "10px"},
        {text:"상태" , width: "40px"},
        {text:"제품 버전" , width: "10px"},
        {text:"제품 특성" , width: "10px"},
        {text:"출하 특성" , width: "10px"},
        {text:"라우트" , width: "90px"},
        {text:"입고시간" , width: "80px"},
        //{text:"정체시간" , width: "10px"},
        {text:"장비" , width: "10px"},
    ];

    const onSubmit = (event : React.FormEvent<HTMLFormElement>) => {
        event.preventDefault();
        async function callAPI(){
            const params:object = {
                customers : checkedCustomers,
                operations : checkedOperations,
                devices : checkedDevices
            }
            const res = await ApiUtil.post(
                "/search/lot-status", params);
            setSearchData(res.data);
        }
        callAPI();
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

    useEffect(()=>{
        let operation:string = "";
        let operationNum:number = -1;
        let counter:number = 0;
        let qty1:number =0;
        let qty2:number =0;
        const operationCol:OperationCol[] = [];

        searchData.map((element)=>{
            if(typeof  element.qtyOne === "number"){
                qty1 += element.qtyOne;
            }
            if(typeof  element.qtyTwo === "number"){
                qty2 += element.qtyTwo;
            }
            if(element.operation !== operation &&
                element.operation !== null &&
                element.operation !== undefined){
                operation = element.operation;
                operationNum++;
                operationCol.push({
                    colCount : 1,
                    colName : typeof element.operation=== "string" ? element.operation : "",
                    colQty1 : typeof element.qtyOne === "number" ? element.qtyOne : 0,
                    colQty2 : typeof element.qtyTwo === "number" ? element.qtyTwo : 0
                });
            }else{
                operationCol[operationNum].colCount++;
                if(typeof element.qtyOne === "number" ){
                    operationCol[operationNum].colQty1 += element.qtyOne;
                }
                if(typeof element.qtyTwo === "number" ){
                    operationCol[operationNum].colQty2 += element.qtyTwo;
                }
            }
        });

        operationNum = 0;

        for(let i=0; i<operationCol.length;i++){
            searchData.splice(counter,0,
                {
                    operation : operationCol[operationNum].colName,
                    qtyOne : operationCol[operationNum].colQty1,
                    qtyTwo : operationCol[operationNum].colQty2,
                    colSpan : operationCol[operationNum].colCount,
                    isOperation : true,
                    lotNumber : "total"
                }
            );
            counter += operationCol[operationNum++].colCount + 1 ;
        }

        setTableBodies((
            <tbody
                key={"bodies"}
            >
            {searchData.map((element,index) => (
                <React.Fragment
                    key={"body"+index}
                >
                    <tr>
                        {element.isOperation && (
                            <td
                                style={{
                                    // @ts-ignore
                                    gridRow : `span ${element.colSpan+1}`
                                }}
                            >
                                <span>{element.operation}</span>
                            </td>
                        )}
                        <td><span>{element.lotNumber}</span></td>
                        <td><span>{element.mainLot}</span></td>
                        <td><span>{element.qtyOne}</span></td>
                        <td><span>{element.qtyUnitOne}</span></td>
                        <td><span>{element.qtyTwo}</span></td>
                        <td><span>{element.qtyUnitTwo}</span></td>
                        <td><span>{element.device}</span></td>
                        <td><span>{element.customer}</span></td>
                        <td><span>{element.inHold}</span></td>
                        <td><span>{element.inRework}</span></td>
                        <td><span>{element.holdNote}</span></td>
                        <td><span>{element.processFlag}</span></td>
                        <td><span>{element.deviceVer}</span></td>
                        <td><span>{element.deviceAttribute}</span></td>
                        <td><span>{element.shipAttribute}</span></td>
                        <td><span>{element.route}</span></td>
                        <td><span>{
                            typeof element.enterOperTime === "string" &&
                            getMonthToMinute(getDate(element.enterOperTime))
                        }</span></td>
                        <td><span>{element.equipmentId}</span></td>
                    </tr>
                </React.Fragment>
            ))}
            </tbody>
        ));

        return
    },[searchData]);

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
        <S.Container
            isLookDown={isLookDown}
        >
            <H2 text={langState.isKor ? "LOT 정보 조회" : "View Lot Status" }/>
            <Icon
                icon={isLookDown ? "doubleUp" : "doubleDown"}
                size={40}
                onClick={()=>setIsLookDown((prev) => !prev)}
                className="look-down"
            />
            <form onSubmit={onSubmit}>
                <div className='condition-container'>
                    <SearchSelector
                        title={langState.isKor ? "고객사" : "Customer"}
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
                </div>
                <TableForm
                    tableHeaders={tableHeaders}
                    tableBodies={tableBodies}
                    isLookDown={isLookDown}
                    isDatePicker={true}
                    isDateRange={true}
                />
            </form>
        </S.Container>
    )
}

export default LotStatus;
