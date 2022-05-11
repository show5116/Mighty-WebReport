package com.mighty.webreport.domain.entity.admin;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Entity
@DynamicUpdate
@DynamicInsert
@NoArgsConstructor
@Table(name = "adm_PLANT")
public class Plant {

    @Id
    @Column(name = "PLANT")
    private String id;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "NUMBER_OF_SHIFT",nullable = false)
    private Integer numberOfShift;

    @Column(name = "SHIFT_1_START", nullable = false)
    private String shiftStartOne;

    @Column(name = "SHIFT_2_START")
    private String shiftStartTwo;

    @Column(name = "SHIFT_3_START")
    private String shiftStartThree;

    @Column(name = "SHIFT_4_START")
    private String shiftStartFour;

    @Column(name = "STD_DAYS_PER_WEEK", nullable = false)
    private Integer daysPerWeek;

    @Column(name = "STD_HOURS_PER_DAY", nullable = false)
    private Integer hoursPerDay;

    @Column(name = "ACTIVE_PLANT", nullable = false)
    private Character activePlant;

    @Column(name = "REG_TIME")
    private String regTime;

    @Column(name = "REG_USER")
    private String regUser;
}
