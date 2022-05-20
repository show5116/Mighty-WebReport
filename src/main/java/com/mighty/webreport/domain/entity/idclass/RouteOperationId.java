package com.mighty.webreport.domain.entity.idclass;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class RouteOperationId implements Serializable {

    private RouteId routeId;

    @Column(name = "OPERATION")
    private String operation;

    @Column(name = "OPER_SEQ")
    private Integer operSeq;

}
