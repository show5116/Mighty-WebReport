import React, { useDebugValue, useEffect, useState } from 'react';
import { useDispatch } from 'react-redux';
import { useSelector } from 'react-redux';
import SearchSelector from '../../components/form/SearchSelector';
import TableForm from '../../components/form/TableForm';
import { RootState } from '../../modules';
import { showAlertModal } from '../../modules/action/alertAction';
import { CSVHeader, ISearchBox, TableHeader } from '../../types/type';
import { IDevice, ILotNumber, IOperation } from '../../types/userData';
import ApiUtil from '../../utils/ApiUtil';
import { getDateString } from '../../utils/dateUtil';
import ViewDefectStatus from '../inventory/ViewDefectStatus';
import * as S from './style.DailyMovement';

const DailyMovement = () =>{

    const langState = useSelector((state:RootState) =>state.langReducer);
    const [operatons,setOperations] = useState<ISearchBox[]>([]);
    const [checkedOperations, setCheckedOperations] = useState<ISearchBox[]>([]);

    const[devices,setDevices] = useState<ISearchBox[]>([]);
    const[checkedDevices,setCheckedDevices] = useState<ISearchBox[]>([]);

    const[lotNumbers, setLotNumbers] = useState<ISearchBox[]>([]);
    const[checkedLotNumbers, setCheckedLotNumbers] = useState<ISearchBox[]>([]);


useEffect(() =>{
    async function CallAPI (){
            const res = await ApiUtil.get("/condition/operationAndDeviceAndLotNumber",)
            res.data.operations.map((operation: IOperation) =>{
                return operatons.push({
                    id:operation.operation,
                    text : operation.description
                })
            })
            setOperations(operatons);

            res.data.devices.map((device:IDevice) =>{
                return devices.push({
                    id:device.deviceId,
                    text:device.description
                })
            })
            setDevices(devices);
            console.log(res);
            res.data.lotNumbers.map((lotNumber:ILotNumber) =>{
                return lotNumbers.push({
                        id:lotNumber.id,
                        text:lotNumber.text
                })
            })
            setLotNumbers(lotNumbers);
    }
    CallAPI();
},[operatons])


    return(
        <S.Container>
            <form>
                <div>
                    <SearchSelector 
                    title = {langState.isKor? "공정" : "Operation"}
                    list = {operatons}
                    selected ={checkedOperations}
                    selector = {setCheckedOperations}
                    />
                    <SearchSelector
                        title = {langState.isKor? "제품" : "Device"}
                        list = {devices}
                        selected ={checkedDevices}
                        selector = {setCheckedDevices}
                    />
                    <SearchSelector
                        title = {langState.isKor? "LOT Number" : "LOT Number"}
                        list = {lotNumbers}
                        selected = {checkedLotNumbers}
                        selector = {setCheckedLotNumbers}
                    />
                </div>
            </form>
        </S.Container>
    )

}
export default DailyMovement;