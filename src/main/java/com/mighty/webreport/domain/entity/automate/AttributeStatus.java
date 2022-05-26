package com.mighty.webreport.domain.entity.automate;

import com.mighty.webreport.domain.entity.idclass.AttributeStatusId;
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
@Table(name = "asfc_attribute_status")
@IdClass(AttributeStatusId.class)
public class AttributeStatus {

    @Id
    @Column(name = "LOT_NUMBER")
    private String lotNumber;

    @Id
    @Column(name = "ATTRIBUTE_INDEX")
    private Integer attributeIndex;

    @Column(name = "PLANT" , nullable = false)
    private String plant;

    @Column(name = "UPLEVEL_LOT")
    private String uplevelLot;

    @Column(name = "MAIN_LOT")
    private String mainLot;

    @Column(name = "SYS_LOT_NUMBER")
    private String sysLotNumber;

    @Column(name = "TRANS_TIME")
    private String transTime;

    @Column(name = "ATTRIBUTE_NAME")
    private String attributeName;

    @Column(name = "ATTRIBUTE_VALUE")
    private String attributeValue;

    @Column(name = "USER_ID")
    private String userId;

}
