package com.mighty.webreport.domain.entity.automate;

import com.mighty.webreport.domain.entity.idclass.LbrHistoryId;
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
@Table(name = "asfc_lbr_history")
@IdClass(LbrHistoryId.class)
public class LbrHistory {

    @Id
    @Column(name = "LOT_NUMBER")
    private String lotNumber;

    @Id
    @Column(name = "TRANS_TIME")
    private String transTime;

    @Id
    @Column(name = "LBR_TYPE")
    private Character lbrType;

    @Id
    @Column(name = "LBR_CODE")
    private String lbrCode;

    @Column(name = "PLANT" , nullable = false)
    private String plant;

    @Column(name = "UPLEVEL_LOT")
    private String uplevelLot;

    @Column(name = "MAIN_LOT")
    private String mainLot;

    @Column(name = "TRANSACTION")
    private String transaction;

    @Column(name = "DEVICE")
    private String device;

    @Column(name = "DEVICE_REV")
    private String deviceRev;

    @Column(name = "OPERATION")
    private String operation;

    @Column(name = "EQUIPMENT1")
    private String equipmentOne;

    @Column(name = "EQUIPMENT2")
    private String equipmentTwo;

    @Column(name = "LBR_QTY1")
    private Integer lbrQtyOne;

    @Column(name = "LBR_QTY1_UNIT")
    private String lbrQtyOneUnit;

    @Column(name = "LBR_QTY2")
    private Integer lbrQtyTwo;

    @Column(name = "LBR_QTY2_UNIT")
    private String lbrQtyTwoUnit;

    @Column(name = "USER_ID")
    private String userId;

    @Column(name = "OPERATION_STEP")
    private String operationStep;

    @Column(name = "REMARK")
    private String remark;

}
