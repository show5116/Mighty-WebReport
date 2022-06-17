import * as S from './style.PTESTYield';
import SearchSelector from "../../components/form/SearchSelector";
import TableForm from "../../components/form/TableForm";
import React, {useState} from "react";
import {CSVHeader, ISearchBox, TableHeader} from "../../types/type";
import {useDispatch, useSelector} from "react-redux";
import {RootState} from "../../modules";

interface IPTESTYield {

}

const tableHeaders:TableHeader[] = [
    {text:"일자" , width: "36px"},
    {text:"제품" , width: "36px"},
    {text:"공정" , width: "36px"},
    {text:"LOT번호" , width: "60px"},
    {text:"고객사Run" , width: "72px"},
    {text:"WAFER" , width: "56px"},
    {text:"차수" , width: "36px"},
    {text:"Slot" , width: "36px"},
    {text:"수율" , width: "36px"},
    {text:"TEST DIE" , width: "70px"},
    {text:"GOOD DIE" , width: "76px"},
    {text:"Tester ID" , width: "68px"},
    {text:"Program" , width: "68px"},
    {text:"Probe Card" , width: "84px"},
    {text:"FAIL DIE" , width: "62px"},
    {text:"#" , width: "18px"},
    {text:"0" , width: "18px"},
    {text:"2" , width: "18px"},
    {text:"3" , width: "18px"},
    {text:"4" , width: "18px"},
    {text:"5" , width: "18px"},
    {text:"6" , width: "18px"},
    {text:"7" , width: "18px"},
    {text:"8" , width: "18px"},
    {text:"?" , width: "18px"},
    {text:"A" , width: "18px"},
    {text:"B" , width: "18px"},
    {text:"C" , width: "18px"},
    {text:"D" , width: "18px"},
    {text:"E" , width: "18px"},
    {text:"F" , width: "18px"},
    {text:"G" , width: "18px"},
    {text:"H" , width: "18px"},
    {text:"I" , width: "18px"},
    {text:"J" , width: "18px"},
    {text:"K" , width: "18px"},
    {text:"L" , width: "18px"},
    {text:"M" , width: "18px"},
    {text:"N" , width: "18px"},
    {text:"O" , width: "18px"},
    {text:"P" , width: "18px"},
    {text:"Q" , width: "18px"},
    {text:"R" , width: "18px"},
    {text:"S" , width: "18px"},
    {text:"T" , width: "18px"},
    {text:"U" , width: "18px"},
    {text:"V" , width: "18px"},
    {text:"W" , width: "18px"},
    {text:"X" , width: "18px"},
    {text:"Y" , width: "18px"},
    {text:"Z" , width: "18px"},
    {text:"a" , width: "18px"},
    {text:"b" , width: "18px"},
    {text:"c" , width: "18px"},
    {text:"d" , width: "18px"},
    {text:"e" , width: "18px"},
    {text:"f" , width: "18px"},
    {text:"g" , width: "18px"},
    {text:"h" , width: "18px"},
    {text:"i" , width: "18px"},
    {text:"j" , width: "18px"},
    {text:"k" , width: "18px"},
    {text:"l" , width: "18px"},
    {text:"m" , width: "18px"},
    {text:"n" , width: "18px"},
    {text:"o" , width: "18px"},
    {text:"p" , width: "18px"},
    {text:"q" , width: "18px"},
    {text:"r" , width: "18px"},
    {text:"s" , width: "18px"},
    {text:"t" , width: "18px"},
    {text:"u" , width: "18px"},
    {text:"v" , width: "18px"},
    {text:"w" , width: "18px"},
    {text:"x" , width: "18px"},
    {text:"y" , width: "18px"},
]

const CSVHeaders:CSVHeader[] = [
    {label : "제품", key : "device"},
    {label : "고객사", key : "customer"},
    {label : "Total", key : "total"}
]

const PTESTYield = () => {
    const [checkedDevices, setCheckedDevices] = useState<ISearchBox[]>([]);
    const [devices, setDevices] = useState<ISearchBox[]>([]);
    const [searchData,setSearchData] = useState<IPTESTYield[]>([]);
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
                    <div className="test-degree-container">
                        <div className="test-type">
                            <label>TEST 유형</label>
                            <select>
                                <option>ALL</option>
                            </select>
                        </div>
                        <div className="degree">
                            <div>
                                <label>차수</label>
                                <input type="text" placeholder="3차"/>
                            </div>
                            <div>
                                <input className="check-box" type="checkbox" />
                                <label>최종차수</label>
                            </div>
                        </div>
                        <div>
                            <input className="check-box" type="checkbox" />
                            <label>불량율 보기</label>
                        </div>
                    </div>
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

export default PTESTYield;
