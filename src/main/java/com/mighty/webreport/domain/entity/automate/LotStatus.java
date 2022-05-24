package com.mighty.webreport.domain.entity.automate;

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
@Table(name = "asfc_lot_status")
public class LotStatus {

    @Id
    @Column(name = "LOT_NUMBER")
    private String lotNumber;

    @Column(name = "PLANT" , nullable = false)
    private String plant;

    @Column(name = "UPLEVEL_LOT")
    private String uplevelLot;

    @Column(name = "MAIN_LOT")
    private String mainLot;

    @Column(name = "SYSLOT_NUMBER")
    private Integer sysLotNumber;

    @Column(name = "LAST_HST_SEQ" , nullable = false)
    private String lastHistSeq;

    @Column(name = "SYS_TRANS_TIME" , nullable = false)
    private String systemTransTime;

    @Column(name = "TRANS_TIME" , nullable = false)
    private String transTime;

    @Column(name = "TRANSACTION" , nullable = false)
    private String transaction;

    @Column(name = "DEVICE" , nullable = false)
    private String device;

    @Column(name = "DEVICE_REV" , nullable = false)
    private String deviceRev;

    @Column(name = "SUB_DEVICE")
    private String subDevice;

    @Column(name = "ROUTESET" , nullable = false)
    private String routeSet;

    @Column(name = "ROUTE" , nullable = false)
    private String route;

    @Column(name = "OPERATION" , nullable = false)
    private String operation;

    @Column(name = "PROCESS_FLAG" , nullable = false)
    private Character processFlag;

    @Column(name = "STATUS" , nullable = false)
    private String status;

    @Column(name = "QTY1" , nullable = false)
    private Integer qtyOne;

    @Column(name = "QTY1_UNIT" , nullable = false)
    private String qtyUnitOne;

    @Column(name = "QTY2")
    private Integer qtyTwo;

    @Column(name = "QTY2_UNIT")
    private String qtyUnitTwo;

    @Column(name = "IN_ACTIVE" , nullable = false)
    private Character inActive;

    @Column(name = "IN_TAGGING" , nullable = false)
    private Character inTagging;

    @Column(name = "TAG_ID")
    private String tagId;

    @Column(name = "IN_STORE" , nullable = false)
    private Character inStore;

    @Column(name = "IN_HOLD" , nullable = false)
    private Character inHold;

    @Column(name = "HOLD_CODE")
    private String holdCode;

    @Column(name = "HOLD_NOTE")
    private String holdNote;

    @Column(name = "HOLD_PASSWORD")
    private String holdPassword;

    @Column(name = "IN_SHIPPING" , nullable = false)
    private Character inShipping;

    @Column(name = "FROM_PLANT")
    private String fromPlant;

    @Column(name = "FROM_OPERATION")
    private String fromOperation;

    @Column(name = "SHIPMENT_ID")
    private String shipmentId;

    @Column(name = "IN_STOCKER" , nullable = false)
    private Character inStocker;

    @Column(name = "STOCKER_SHELF")
    private String stockerShelf;

    @Column(name = "IN_RESERVED_FLOW" , nullable = false)
    private Character inReservedFlow;

    @Column(name = "RESERVATION_ID")
    private String reservationId;

    @Column(name = "IN_REWORK" , nullable = false)
    private Character inRework;

    @Column(name = "RWK_COUNT")
    private Integer rwkCount;

    @Column(name = "RWK_CODE")
    private String rwkCode;

    @Column(name = "RWK_END_ROUTESET")
    private String rwkEndRouteSet;

    @Column(name = "RWK_END_ROUTE")
    private String rwkEndRoute;

    @Column(name = "RWK_END_OPER")
    private String rwkEndOper;

    @Column(name = "RWK_RET_ROUTESET")
    private String rwkRetRouteSet;

    @Column(name = "RWK_RET_ROUTE")
    private String rwkRetRoute;

    @Column(name = "RWK_RET_OPER")
    private String rwkRetOperation;

    @Column(name = "OWNER")
    private String owner;

    @Column(name = "GROUP_ID")
    private String groupId;

    @Column(name = "BATCH_ID")
    private String batchId;

    @Column(name = "BATCHLOT_SEQ")
    private Integer batchLotSeq;

    @Column(name = "TERMINATE_CODE")
    private String terminateCode;

    @Column(name = "ACCOUNT_CODE")
    private String accountCode;

    @Column(name = "CREATE_CODE")
    private String createCode;

    @Column(name = "CREATION_QTY" , nullable = false)
    private Integer creationQty;

    @Column(name = "EMERGENCY_LOT" , nullable = false)
    private Character emergencyLot;

    @Column(name = "PRIORITY" , nullable = false)
    private Integer priority;

    @Column(name = "DISPATCH_RULE")
    private String dispatchRule;

    @Column(name = "ORIGINAL_DUE_DATE")
    private String originalDueDate;

    @Column(name = "DUE_DATE")
    private String dueDate;

    @Column(name = "CREATION_TIME" , nullable = false)
    private String createTime;

    @Column(name = "ENTER_PLANT_TIME" , nullable = false)
    private String enterPlantTime;

    @Column(name = "ENTER_OPER_TIME" , nullable = false)
    private String enterOperTime;

    @Column(name = "ENTER_ROUTE_TIME" , nullable = false)
    private String enterRouteTime;

    @Column(name = "MOVEIN_TIME")
    private String moveInTime;

    @Column(name = "PRIOR_OPER_IN_TIME")
    private String priorOperInTime;

    @Column(name = "PRIOR_OPER_MOVEIN_TIME")
    private String priorOperMoveInTime;

    @Column(name = "SUBTRACKING_ID")
    private String subTrackingId;

    @Column(name = "QA_GRADE" , nullable = false)
    private Character qaGrade;

    @Column(name = "LOT_TYPE" , nullable = false)
    private Character lotType;

    @Column(name = "LOT_SUB_TYPE")
    private String lotSubType;

    @Column(name = "DEVICE_LTYPE")
    private String deviceLType;

    @Column(name = "DEVICE_MTYPE")
    private String deviceMType;

    @Column(name = "DEVICE_STYPE")
    private String deviceSType;

    @Column(name = "PROD_TYPE")
    private Character prodType;

    @Column(name = "IN_EXTERNAL" , nullable = false)
    private Character inExternal;

    @Column(name = "SUBCONTRACT")
    private String subContract;

    @Column(name = "CUSTOMER")
    private String customer;

    @Column(name = "ORDER_NO")
    private String orderNo;

    @Column(name = "ABNORMAL_FLAG" , nullable = false)
    private Character abnormalFlag;

    @Column(name = "ABNORMAL_NO")
    private String abnormalNo;

    @Column(name = "ALARM" , nullable = false)
    private Character alarm;

    @Column(name = "ALARM_ID")
    private String alarmId;

    @Column(name = "PLANT_IN_QTY" , nullable = false)
    private Integer plantInQty;

    @Column(name = "ROUTE_IN_QTY" , nullable = false)
    private Integer routeInQty;

    @Column(name = "OPER_IN_QTY" , nullable = false)
    private Integer operInQty;

    @Column(name = "PRIOR_OPER_IN_QTY" , nullable = false)
    private Integer priorOperInQty;

    @Column(name = "CUM_YIELD" , nullable = false)
    private Integer cumYield;

    @Column(name = "RESERVED_QTY")
    private Integer reservedQty;

    @Column(name = "WORK_QTY")
    private Integer workQty;

    @Column(name = "GOODS_QTY")
    private Integer goodsQty;

    @Column(name = "RUN_NUMBER")
    private String runNumber;

    @Column(name = "RUN_IMPORT_DATE")
    private String runImportDate;

    @Column(name = "IN_FUTURE_ACTION" , nullable = false)
    private Character inFutureAction;

    @Column(name = "FUTURE_ACTION_ID")
    private String futureActionId;

    @Column(name = "STORE_RET_ROUTESET")
    private String storeRetRouteSet;

    @Column(name = "STORE_RET_ROUTE")
    private String storeRetRoute;

    @Column(name = "STORE_RET_OPER")
    private String storeRetOper;

    @Column(name = "CREATE_OPT_1")
    private String createOptOne;

    @Column(name = "CREATE_OPT_2")
    private String createOptTwo;

    @Column(name = "CREATE_OPT_3")
    private String createOptThree;

    @Column(name = "CREATE_OPT_4")
    private String createOptFour;

    @Column(name = "CREATE_OPT_5")
    private String createOptFive;

    @Column(name = "USER_ID" , nullable = false)
    private String userId;

    @Column(name = "USER_COMMENT")
    private String userComment;

    @Column(name = "MAP_FORM")
    private String mapForm;

}
