import * as S from './style.TableForm';
import Table from "../common/Table";
import {CSVHeader, TableHeader} from "../../types/type";
import DatePickerForm from "./DatePickerForm";
import React, {useState} from "react";
import Icon from "../common/Icon";
import { CSVLink } from "react-csv";
import {ILotStatus} from "../../types/userData";
import color from "../../styles/color";
import {getTodayString} from "../../utils/dateUtil";
import {
    Item,
    ItemParams,
    ItemProps,
    Menu,
    Separator,
    useContextMenu
} from "react-contexify";
import "react-contexify/dist/ReactContexify.css";

interface IProps {
    name : string;
    tableHeaders : TableHeader[];
    tableBodies : JSX.Element;
    CSVHeaders : CSVHeader[];
    CSVData : ILotStatus[];
    isLookDown : boolean;
    isDatePicker? : boolean;
    isDateRange? : boolean;
}

const TableForm = ({ name , tableHeaders , tableBodies , CSVHeaders , CSVData , isLookDown , isDatePicker=false , isDateRange=false }:IProps) => {

    const MENU_ID = "table-context-menu";

    const [isViewAll,setIsViewAll] = useState(false);
    const {show} = useContextMenu({
        id : MENU_ID
    });

    const onViewAll = () => {
        setIsViewAll((prev) => !prev);
    }

    const handleItemClick = ({
         event,
         props,
         triggerEvent,
         data} : ItemParams<ItemProps, any>) => {

        switch (event.currentTarget.id) {

        }
    }

    return (
        <S.Container
            isViewAll={isViewAll}
        >
            <div className='result-header'>
                {isDatePicker &&
                    <DatePickerForm
                        isRangeSearch={isDateRange}
                    />
                }
                <div
                    className="btn-container"
                >
                    <CSVLink
                        data={CSVData}
                        headers={CSVHeaders}
                        filename={`${name}${getTodayString()}`}
                        className='excel-btn'
                    >
                        <Icon icon="excel" size={24} color={color.green} />
                    </CSVLink>
                    <button
                        className="search-btn"
                    >
                        <Icon icon="search" size={24} />
                    </button>
                    <Icon
                        icon={isViewAll ? "minimize" : "expand"}
                        size={26}
                        onClick={onViewAll}
                        className="expand-btn"
                    />
                </div>
            </div>
            <div
                className='result-main'
                onContextMenu={
                    (event)=> show(event)
                }
            >
                <Table
                    headers={tableHeaders}
                    bodies={tableBodies}
                    isViewAll={isViewAll}
                    isLookDown={isLookDown}
                />
            </div>
            <Menu id={MENU_ID}>
                {isViewAll
                    ?
                    (<Item
                        onClick={()=>setIsViewAll(false)}
                    >
                        축소하기
                    </Item>)
                    :
                    (<Item
                        onClick={()=>setIsViewAll(true)}
                    >
                        전체보기
                    </Item>)
                }

                <Item>
                    <CSVLink
                        data={CSVData}
                        headers={CSVHeaders}
                        filename={`${name}${getTodayString()}`}
                        className='excel-btn'
                    >
                        <span>액셀 다운로드</span>
                    </CSVLink>
                </Item>
                <Separator />
            </Menu>
        </S.Container>
    );
}

export default TableForm;
