package com.mighty.webreport.domain.entity.idclass;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class AttributeStatusId implements Serializable {

    @Column(name = "LOT_NUMBER")
    private String lotNumber;

    @Column(name = "ATTRIBUTE_INDEX")
    private Integer attributeIndex;

}
