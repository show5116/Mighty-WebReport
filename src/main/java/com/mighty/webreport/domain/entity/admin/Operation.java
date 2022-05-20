package com.mighty.webreport.domain.entity.admin;

import com.mighty.webreport.domain.entity.idclass.OperationId;
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
@Table(name = "adm_operation")
@IdClass(OperationId.class)
public class Operation {

    @Id
    @Column(name = "OPERATION")
    private String operation;

    @Id
    @Column(name = "PLANT")
    private String plant;

    @Column(name = "SHORT_DESC")
    private String shortDesc;

    @Column(name = "LONG_DESC")
    private String longDesc;

    @Column(name = "SHIPPING_FLAG")
    private Character shippingFlag;

    @Column(name = "STORE_FLAG")
    private Character storeFlag;

    @Column(name = "STORE_TYPE")
    private Character storeType;

    @Column(name = "STOCKER_FLAG")
    private Character stockerFlag;

    @Column(name = "INTRANSIT")
    private Character intRanSit;

    @Column(name = "CHANGE_ROUTESET")
    private Character changeRouteSet;

    @Column(name = "REQUEST_QA")
    private Character RequestQa;

    @Column(name = "QA_TYPE")
    private String qaType;

    @Column(name = "EXTERNAL_FLAG")
    private Character externalFlag;

    @Column(name = "PRINT_LABEL")
    private Character printLabel;

    @Column(name = "PASS_FLAG")
    private Character passFlag;

    @Column(name = "MATERIAL_USAGE")
    private Character materialUsage;

    @Column(name = "QTY_1ST_UNIT")
    private String qtyUnitOne;

    @Column(name = "QTY_2ND_UNIT")
    private String qtyUnitTwo;

    @Column(name = "PROCESS_STEP")
    private String processStep;

    @Column(name = "BATCH_PROCESS")
    private Character batchProcess;

    @Column(name = "MULTI_EQUIPMENT")
    private Character multiEquipment;

    @Column(name = "LOSS_TABLE")
    private String lossTable;

    @Column(name = "BONUS_TABLE")
    private String bonusTable;

    @Column(name = "REWORK_TABLE")
    private String reworkTable;

    @Column(name = "CV_TABLE")
    private String cvTable;

    @Column(name = "REPAIR_TABLE")
    private String repairTable;

    @Column(name = "IN_PARAMETERSET")
    private String inParameterSet;

    @Column(name = "OUT_PARAMETERSET")
    private String outParameterSet;

    @Column(name = "REWORK_PARAMETERSET")
    private String reworkParameterSet;

    @Column(name = "ADHOC_PARAMETERSET")
    private String adhocParameterSet;

    @Column(name = "REMARK")
    private String remark;

    @Column(name = "REG_TIME")
    private String regTime;

    @Column(name = "REG_USER")
    private String regUser;

    @Column(name = "EXPAND_FLAG1")
    private Character expandFlagOne;

    @Column(name = "EXPAND_FLAG2")
    private Character expandFlagTwo;

    @Column(name = "EXPAND_FLAG3")
    private Character expandFlagThree;

    @Column(name = "EXPAND_FLAG4")
    private Character expandFlagFour;

    @Column(name = "EXPAND_FLAG5")
    private Character expandFlagFive;

    @Column(name = "EXPAND_FIELD1")
    private String expandFieldOne;

    @Column(name = "EXPAND_FIELD2")
    private String expandFieldTwo;

    @Column(name = "EXPAND_FIELD3")
    private String expandFieldThree;

    @Column(name = "EXPAND_FIELD4")
    private String expandFieldFour;

    @Column(name = "EXPAND_FIELD5")
    private String expandFieldFive;

    @Column(name = "RETEST_TABLE")
    private String reTestTable;

    @Column(name = "EQP_PARAMETERSET")
    private String eqpParameterSet;

}
