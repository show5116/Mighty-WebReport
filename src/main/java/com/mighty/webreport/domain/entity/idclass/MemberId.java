package com.mighty.webreport.domain.entity.idclass;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class MemberId implements Serializable {

    @Column(name = "USER_ID")
    private String userId;

    @Column(name = "PLANT")
    private String plant;

}
