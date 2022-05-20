package com.mighty.webreport.domain.entity.admin;

import com.mighty.webreport.domain.entity.idclass.RouteOperationId;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Getter
@Entity
@DynamicUpdate
@DynamicInsert
@NoArgsConstructor
@Table(name = "adm_route_operation")
@IdClass(RouteOperationId.class)
public class RouteOperation {

    @Id
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "ROUTE", referencedColumnName = "ROUTE"),
            @JoinColumn(name = "PLANT", referencedColumnName = "PLANT")
    })
    private Route routeId;

    @Id
    @Column(name = "OPERATION")
    private String operation;

    @Id
    @Column(name = "OPER_SEQ")
    private Integer operSeq;

    @Column(name = "MESSAGE_IN_OUT")
    private Character messageInOut;

    @Column(name = "MESSAGE_ID")
    private String messageId;

    @Column(name = "RWK_ROUTESET")
    private String rwkRouteSet;

    @Column(name = "RWK_ROUTE")
    private String rwkRoute;

    @Column(name = "RWK_OPERATION")
    private String rwkOperation;

    @Column(name = "RWK_RET_ROUTESET")
    private String rwkRetRouteSet;

    @Column(name = "RWK_RET_ROUTE")
    private String rwkRetRoute;

    @Column(name = "RWK_RET_OPER")
    private String rwkRetOper;

    @Column(name = "IN_PARAMETERSET")
    private String inParameterSet;

    @Column(name = "OUT_PARAMETERSET")
    private String outParameterSet;

    @Column(name = "REWORK_PARAMETERSET")
    private String reworkParameterSet;

    @Column(name = "ADHOC_PARAMETERSET")
    private String adhocParameterSet;

    @Column(name = "PLAN_QUEUE_TIME")
    private Integer planQueueTime;

    @Column(name = "PLAN_PROCESS_TIME")
    private Integer planProcessTime;

    @Column(name = "PLAN_STANDBY_TIME")
    private Integer planStandByTime;

    @Column(name = "PLAN_CYCLE_TIME")
    private Integer planCycleTime;

    @Column(name = "PLAN_YIELD")
    private Integer planYield;

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

}
