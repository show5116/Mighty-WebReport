import * as S from './style.DailyShippingStatus';
import {CSVHeader, ISearchBox, TableHeader} from "../../types/type";
import SearchSelector from "../../components/form/SearchSelector";
import TableForm from "../../components/form/TableForm";
import React, {useState} from "react";
import {useDispatch, useSelector} from "react-redux";
import {RootState} from "../../modules";

interface IDailyShippingStatus {
    device : string;
    customer : string;
    total : number;
}

const tableHeaders:TableHeader[] = [
    {text:"제품" , width: "300px"},
    {text:"고객사" , width: "300px"},
    {text:"Total" , width: "300px"}
]

const CSVHeaders:CSVHeader[] = [
    {label : "제품", key : "device"},
    {label : "고객사", key : "customer"},
    {label : "Total", key : "total"}
]

const processExample:ISearchBox[] = [
    {id: "B" , text : "B : Only Bump"},
    {id: "AVI" , text : "AVI : Only AVI"},
    {id: "BA" , text : "BA : Bump AVI"},
    {id: "BALM" , text : "BALM : Bump, AVI, LM"},
    {id: "BP" , text : "BP : Bump,Test"}
]

const DailyShippingStatus = () => {
    const [checkedCustomers, setCheckedCustomers] = useState<ISearchBox[]>([]);
    const [customers, setCustomers] = useState<ISearchBox[]>([]);
    const [checkedDevices, setCheckedDevices] = useState<ISearchBox[]>([]);
    const [devices, setDevices] = useState<ISearchBox[]>([]);
    const [process, setProcess] = useState<ISearchBox[]>([]);
    const [checkedProcess, setCheckedProcess] = useState<ISearchBox[]>([]);
    const [searchData,setSearchData] = useState<IDailyShippingStatus[]>([]);
    const [isLookDown,setIsLookDown] = useState(false);
    const [tableBodies, setTableBodies] = useState<JSX.Element>((<tbody></tbody>));
    const [startDate,setStartDate] = useState(new Date());
    const [endDate,setEndDate] = useState(new Date());

    const dispatch = useDispatch();
    const langState = useSelector((state:RootState) => state.langReducer);

    const onSubmit = (event : React.FormEvent<HTMLFormElement>) => {
        event.preventDefault();
    }

    return (
        <S.Container
            isLookDown={isLookDown}
        >
            <form onSubmit={onSubmit}>
                <div className='condition-container'>
                    <SearchSelector
                        title={langState.isKor ? "고객사" : "Customer"}
                        list={customers}
                        selected={checkedCustomers}
                        selector={setCheckedCustomers}
                    />
                    <SearchSelector
                        title={langState.isKor ? "Process Type" : "Process Type"}
                        list={process}
                        selected={checkedProcess}
                        selector={setCheckedProcess}
                    />
                    <SearchSelector
                        title={langState.isKor ? "제품" : "Device"}
                        list={devices}
                        selected={checkedDevices}
                        selector={setCheckedDevices}
                        hasDesc={true}
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
                    startDate={startDate}
                    endDate={endDate}
                    setStartDate={setStartDate}
                    setEndDate={setEndDate}
                />
            </form>
        </S.Container>
    )
}

export default DailyShippingStatus;
