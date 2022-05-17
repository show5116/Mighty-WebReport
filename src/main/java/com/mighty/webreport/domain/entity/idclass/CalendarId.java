package com.mighty.webreport.domain.entity.idclass;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class CalendarId implements Serializable {

    @Column(name = "NATURAL_DATE")
    private String naturalDate;

    @Column(name = "PLANT")
    private String plant;

}
