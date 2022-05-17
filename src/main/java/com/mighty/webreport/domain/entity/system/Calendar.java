package com.mighty.webreport.domain.entity.system;

import com.mighty.webreport.domain.entity.idclass.CalendarId;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Getter
@Entity
@DynamicUpdate
@DynamicInsert
@NoArgsConstructor
@Table(name = "sys_calendar")
@IdClass(CalendarId.class)
public class Calendar {

    @Id
    @Column(name = "NATURAL_DATE")
    private String naturalDate;

    @Id
    @Column(name = "PLANT")
    private String plant;

    @Column(name = "DAY_SEQ")
    private Integer daySeq;

    @Column(name = "WORK_DAY")
    private Integer workDay;

    @Column(name = "PLAN_YEAR")
    private String planYear;

    @Column(name = "PLAN_QUARTER")
    private String planQuarter;

    @Column(name = "PLAN_MONTH")
    private String planMonth;

    @Column(name = "PLAN_WEEK")
    private String planWeek;

}
