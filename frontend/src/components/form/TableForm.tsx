import * as S from './style.TableForm';
import Button from "../common/Button";
import Table from "../common/Table";
import {TableHeader} from "../../types/type";
import DatePickerForm from "./DatePickerForm";
import {useState} from "react";
import Icon from "../common/Icon";

interface IProps {
    tableHeaders : TableHeader[];
    tableBodies : JSX.Element;
    isLookDown : boolean;
    isDatePicker? : boolean;
    isDateRange? : boolean;
}

const TableForm = ({ tableHeaders , tableBodies , isLookDown , isDatePicker=false , isDateRange=false }:IProps) => {

    const [isViewAll,setIsViewAll] = useState(false);

    const onViewAll = () => {
        setIsViewAll((prev) => !prev);
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
            <div className='result-main'>
                <Table
                    headers={tableHeaders}
                    bodies={tableBodies}
                    isViewAll={isViewAll}
                    isLookDown={isLookDown}
                />
            </div>
        </S.Container>
    );
}

export default TableForm;
