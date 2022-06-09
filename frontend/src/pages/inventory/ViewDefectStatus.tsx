import * as S from './style.ViewDefectStatus';
import SearchSelector from "../../components/form/SearchSelector";
import React, {useState} from "react";
import {CSVHeader, ISearchBox, TableHeader} from "../../types/type";
import {useDispatch, useSelector} from "react-redux";
import {RootState} from "../../modules";
import ApiUtil from "../../utils/ApiUtil";
import {showAlertModal} from "../../modules/action/alertAction";
import {ResponsiveBar} from "@nivo/bar";
import TableForm from "../../components/form/TableForm";


const tableHeaders:TableHeader[] = [
    {text:"제품" , width: "130px"},
    {text:"공정" , width: "130px"},
    {text:"LOT_Number" , width: "44px"},
    {text:`4"_M1 Scratch` , width: "40px"},
    {text:`6"_Crack` , width: "44px"},
    {text:`6"_Chip` , width: "40px"},
    {text:`6"_Scratch` , width: "70px"},
];

const CSVHeaders:CSVHeader[] = [
    {label : "제품", key : "operation"},
    {label : "공정", key : "lotNumber"},
    {label : "LOT_Number", key : "mainLot"},
    {label : `4"_M1 Scratch`, key : "qtyOne"},
    {label : `6"_Crack`, key : "qtyUnitOne"},
    {label : `6"_Chip`, key : "qtyTwo"},
    {label : `6"_Scratch`, key : "equipmentId"},
];

const ViewDefectStatus = () => {
    const [operations, setOperations] = useState<ISearchBox[]>([]);
    const [checkedOperations, setCheckedOperations] = useState<ISearchBox[]>([]);
    const [devices, setDevices] = useState<ISearchBox[]>([]);
    const [checkedDevices, setCheckedDevices] = useState<ISearchBox[]>([]);
    const [searchData,setSearchData] = useState([]);
    const [isLookDown,setIsLookDown] = useState(false);
    const [tableBodies, setTableBodies] = useState<JSX.Element>((<tbody></tbody>));
    const dispatch = useDispatch();
    const langState = useSelector((state:RootState) => state.langReducer);

    const onSubmit = (event : React.FormEvent<HTMLFormElement>) => {
        event.preventDefault();
        /*async function callAPI(){
            const params:object = {
            }
            const res = await ApiUtil.post(
                "/search/lot-status", params);
            if(res.data.lotStatus.length === 0){
                dispatch(showAlertModal("확인 메세지","데이터","가 없습니다."));
            }
        }
        callAPI();*/
    }

    return (
        <S.Container>
            <form onSubmit={onSubmit}>
                <div className='condition-container'>
                    <SearchSelector
                        title={langState.isKor ? "공정" : "Operation"}
                        list={operations}
                        selected={checkedOperations}
                        selector={setCheckedOperations}
                    />
                    <SearchSelector
                        title={langState.isKor ? "제품" : "Device"}
                        list={operations}
                        selected={checkedOperations}
                        selector={setCheckedOperations}
                    />
                    <SearchSelector
                        title={langState.isKor ? "랏넘버" : "Lot Number"}
                        list={operations}
                        selected={checkedOperations}
                        selector={setCheckedOperations}
                    />
                </div>
                <TableForm
                    name="LotStatus"
                    tableHeaders={tableHeaders}
                    tableBodies={tableBodies}
                    CSVHeaders={CSVHeaders}
                    CSVData={searchData}
                    isLookDown={isLookDown}
                    setIsLookDown={setIsLookDown}
                    isDateRange={true}
                    isDatePicker={true}
                />
            </form>
        </S.Container>
    );
}

export default ViewDefectStatus;
