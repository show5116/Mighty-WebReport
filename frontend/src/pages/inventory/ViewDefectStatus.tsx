import * as S from './style.ViewDefectStatus';
import SearchSelector from "../../components/form/SearchSelector";
import React, {useEffect, useState} from "react";
import {CSVHeader, ISearchBox, TableHeader} from "../../types/type";
import {useDispatch, useSelector} from "react-redux";
import {RootState} from "../../modules";
import ApiUtil from "../../utils/ApiUtil";
import {showAlertModal} from "../../modules/action/alertAction";
import TableForm from "../../components/form/TableForm";
import {Bar, Line} from "react-chartjs-2";
import VerticalBar, {IBarDataSet} from "../../components/common/VerticalBar";
import {getRGBA} from "../../utils/RGBAUtil";
import Icon from "../../components/common/Icon";

const tableHeaders:TableHeader[] = [
    {text:"제품" , width: "130px"},
    {text:"공정" , width: "130px"},
    {text:"LOT_Number" , width: "100px"},
    {text:`4"_M1 Scratch` , width: "60px"},
    {text:`6"_Crack` , width: "60px"},
    {text:`6"_Chip` , width: "60px"},
    {text:`6"_Scratch` , width: "60px"},
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

interface IDefectStatus {
    device : string;
    operation: string;
    lotNumber: string;
    totalLbrQty: number;
    lossScrapQty: number;
    lossRepairQty: number;
    M1Scratch : number;
    Crack : number;
    Chip : number;
    Scratch : number;
}

const resultExample:IDefectStatus[] = [
    {
        device : "FCSDU0001 : CSP/Dual Filter(6 inch)/1.5x1.1mm" ,
        operation: "F60201 : Wafer Input" ,
        lotNumber:"S622504-01",
        totalLbrQty:4,
        lossScrapQty:4,
        lossRepairQty:0,
        M1Scratch :0,
        Crack : 1,
        Chip : 2,
        Scratch : 1
    },
    {
        device : "FRCAT0001 : RFC/Antenna(4 inch)/36x36mm" ,
        operation: "F40102 : M1Dep" ,
        lotNumber:"S4224W-01",
        totalLbrQty:1,
        lossScrapQty:1,
        lossRepairQty:0,
        M1Scratch :1,
        Crack : 0,
        Chip : 0,
        Scratch : 0
    },
]

const labels:string[] = ['4"_M1 Scratch', '6"_Crack', '6"Chip', '6"_Scratch', '합계' ];

const datasets:IBarDataSet[] = [
    {
        label: 'Dataset 1',
        data: labels.map(() => 1),
        backgroundColor: getRGBA(0),
    },
    {
        label: 'Dataset 2',
        data: labels.map(() =>  1),
        backgroundColor: getRGBA(11),
    },  {
        label: 'Dataset 2',
        data: labels.map(() =>  1),
        backgroundColor: getRGBA(11),
    },  {
        label: 'Dataset 2',
        data: labels.map(() =>  1),
        backgroundColor: getRGBA(11),
    },  {
        label: 'Dataset 2',
        data: labels.map(() =>  1),
        backgroundColor: getRGBA(11),
    },  {
        label: 'Dataset 2',
        data: labels.map(() =>  1),
        backgroundColor: getRGBA(11),
    },
];

const ViewDefectStatus = () => {
    const [operations, setOperations] = useState<ISearchBox[]>([]);
    const [checkedOperations, setCheckedOperations] = useState<ISearchBox[]>([]);
    const [devices, setDevices] = useState<ISearchBox[]>([]);
    const [checkedDevices, setCheckedDevices] = useState<ISearchBox[]>([]);
    const [searchData,setSearchData] = useState<IDefectStatus[]>([]);
    const [isLookDown,setIsLookDown] = useState(true);
    const [tableBodies, setTableBodies] = useState<JSX.Element>((<tbody></tbody>));
    const [isTable,setIsTable] = useState(true);
    const dispatch = useDispatch();
    const langState = useSelector((state:RootState) => state.langReducer);

    const onSubmit = (event : React.FormEvent<HTMLFormElement>) => {
        event.preventDefault();
        setSearchData(resultExample);
    }

    const setGridView = () => {
        setIsTable((prev) => !prev);
    }

    return (
        <S.Container
            isLookDown={isLookDown}
        >
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
                        title={langState.isKor ? "Lot Number" : "Lot Number"}
                        list={operations}
                        selected={checkedOperations}
                        selector={setCheckedOperations}
                    />
                </div>
                {isTable &&
                    (<TableForm
                    name="LotStatus"
                    tableHeaders={tableHeaders}
                    tableBodies={tableBodies}
                    CSVHeaders={CSVHeaders}
                    CSVData={searchData}
                    isLookDown={isLookDown}
                    setIsLookDown={setIsLookDown}
                    isDateRange={true}
                    isDatePicker={true}
                    />)}

                <div className="chart-container">
                    <div className="chart-menu">
                        <Icon
                            icon={isTable ? "gridOff" : "grid" }
                            size={26}
                            onClick={setGridView}
                        />
                    </div>
                    <div className="charts">
                        <VerticalBar
                            title="제품별 불량현황"
                            labels={labels}
                            datasets={datasets}
                        />
                        <VerticalBar
                            title="공정별 불량현황"
                            labels={labels}
                            datasets={datasets}
                        />
                        <VerticalBar
                            title="Lot별 불량현황"
                            labels={labels}
                            datasets={datasets}
                        />
                    </div>
                </div>
            </form>
        </S.Container>
    );
}

export default ViewDefectStatus;
