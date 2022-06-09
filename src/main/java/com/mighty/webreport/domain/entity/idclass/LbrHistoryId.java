package com.mighty.webreport.domain.entity.idclass;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class LbrHistoryId implements Serializable {

    @Column(name = "LOT_NUMBER")
    private String lotNumber;

    @Column(name = "TRANS_TIME")
    private String transTime;

    @Column(name = "LBR_TYPE")
    private Character lbrType;

    @Column(name = "LBR_CODE")
    private String lbrCode;
}
