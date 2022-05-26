import * as S from './style.DatePickerForm';
import DatePicker from 'react-datepicker';
import React, {useState} from "react";
import Icon from "../common/Icon";
import {useSelector} from "react-redux";
import {RootState} from "../../modules";

interface IProps {
    isRangeSearch?: boolean
}

const DatePickerForm = ({ isRangeSearch = false}:IProps) => {

    const langState = useSelector((state:RootState) => state.menuReducer);
    const [startDate,setStartDate] = useState(new Date());
    const [endDate,setEndDate] = useState(new Date());

    const monthsKor = [
        "1월",
        "2월",
        "3월",
        "4월",
        "5월",
        "6월",
        "7월",
        "8월",
        "9월",
        "10월",
        "11월",
        "12월"
    ]

    const monthsEng = [
        "January",
        "February",
        "March",
        "April",
        "May",
        "June",
        "July",
        "August",
        "September",
        "October",
        "November",
        "December"
    ]

    return (
      <S.Container isRangeSearch={isRangeSearch}>
          <div className="date-picker-container">
              <DatePicker
                  selected={startDate}
                  dateFormat="yyyy-MM-dd"
                  onChange={date => date!==null && setStartDate(date)}
                  maxDate={endDate}
                  selectsStart={true}
                  renderCustomHeader={({
                    date,
                    decreaseMonth,
                    increaseMonth,
                    prevMonthButtonDisabled,
                    nextMonthButtonDisabled,
                  }) =>(
                      <div className="header-custom">
                          {!prevMonthButtonDisabled &&
                              (<Icon
                                  icon="arrow"
                                  size={20}
                                  className="prev-month"
                                  onClick={decreaseMonth}
                              />)
                          }
                          {!nextMonthButtonDisabled &&
                              (<Icon
                                  icon="arrow"
                                  size={20}
                                  className="next-month"
                                  onClick={increaseMonth}
                              />)
                          }
                          <div>
                              {date.getFullYear()} {langState.isKor ? monthsKor[date.getMonth()] : monthsEng[date.getMonth()] }
                          </div>
                      </div>
                  )}
              />
              <Icon icon="caretDown" size={10} />
          </div>
          {isRangeSearch && (
              <React.Fragment>
                  <span className="range">
                      ~
                  </span>
                  <div className="date-picker-container end-date">
                      <DatePicker
                          selected={endDate}
                          dateFormat="yyyy-MM-dd"
                          onChange={date => date!==null && setEndDate(date)}
                          minDate={startDate}
                          maxDate={new Date()}
                          selectsStart={true}
                          renderCustomHeader={({
                               date,
                               decreaseMonth,
                               increaseMonth,
                               prevMonthButtonDisabled,
                               nextMonthButtonDisabled,
                                               }) =>(
                              <div className="header-custom">
                                  {!prevMonthButtonDisabled &&
                                      (<Icon
                                          icon="arrow"
                                          size={20}
                                          className="prev-month"
                                          onClick={decreaseMonth}
                                      />)
                                  }
                                  {!nextMonthButtonDisabled &&
                                      (<Icon
                                          icon="arrow"
                                          size={20}
                                          className="next-month"
                                          onClick={increaseMonth}
                                      />)
                                  }
                                  <div>
                                      {date.getFullYear()} {langState.isKor ? monthsKor[date.getMonth()] : monthsEng[date.getMonth()] }
                                  </div>
                              </div>
                          )}
                      />
                      <Icon icon="caretDown" size={10} />
                  </div>

              </React.Fragment>
          )}
      </S.Container>
    );
}

export default DatePickerForm;
