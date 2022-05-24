package com.mighty.webreport.domain.entity.admin;

import com.mighty.webreport.domain.entity.idclass.DeviceSpecId;
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
@Table(name = "adm_device_spec")
@IdClass(DeviceSpecId.class)
public class DeviceSpec {

    @Id
    @Column(name = "PLANT")
    private String plant;

    @Id
    @Column(name = "DEVICE")
    private String deviceId;

    @Id
    @Column(name = "REVISION_NO")
    private String revisionNo;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "REVISION_NO" , referencedColumnName = "REVISION_NO"),
            @JoinColumn(name = "DEVICE" , referencedColumnName = "DEVICE"),
            @JoinColumn(name = "PLANT" , referencedColumnName = "PLANT")
    })
    private Device device;

    @Column(name = "CUSTOMER")
    private String customer;

    @Column(name = "CUSTOMER_DEVICE")
    private String customerDevice;

    @Column(name = "CUSTOMER_ITEM")
    private String customerItem;

    @Column(name = "DEVICE_LTYPE")
    private String deviceLType;

    @Column(name = "DEVICE_MTYPE")
    private String deviceMType;

    @Column(name = "DEVICE_STYPE")
    private String deviceSType;

    @Column(name = "PROD_TYPE")
    private Character prodType;

    @Column(name = "DISCONTINUE" , nullable = false)
    private Character disContinue;

    @Column(name = "END_USER")
    private String endUser;

    @Column(name = "CONSIGNEE")
    private String consignee;

    @Column(name = "LABEL_TYPE1")
    private String labelTypeOne;

    @Column(name = "LABEL_TYPE2")
    private String labelTypeTwo;

    @Column(name = "LABEL_TYPE3")
    private String labelTypeThree;

    @Column(name = "SHEET_TYPE1")
    private String sheetTypeOne;

    @Column(name = "SHEET_TYPE2")
    private String sheetTypeTwo;

    @Column(name = "TARGET_QTY" , nullable = false)
    private Integer targetQty;

    @Column(name = "TARGET_TAT" , nullable = false)
    private Integer targetTat;

    @Column(name = "TARGET_YIELD" , nullable = false)
    private Integer targetYield;

    @Column(name = "VALIDITY_TERM" , nullable = false)
    private Integer validityTerm;

    @Column(name = "VALIDITY_TERM_UNIT")
    private Character validityTermUnit;

    @Column(name = "REMARK")
    private String remark;

    @Column(name = "REG_TIME")
    private String regTime;

    @Column(name = "REG_USER")
    private String regUser;

    @Column(name = "ARRAYSIZE")
    private Integer arraySize;

    @Column(name = "MAT_POINT")
    private Integer matPoint;

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

    @Column(name = "EXPAND_FLAG6")
    private Character expandFlagSix;

    @Column(name = "EXPAND_FLAG7")
    private Character expandFlagSeven;

    @Column(name = "EXPAND_FLAG8")
    private Character expandFlagEight;

    @Column(name = "EXPAND_FLAG9")
    private Character expandFlagNine;

    @Column(name = "EXPAND_FLAG10")
    private Character expandFlagTen;

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

    @Column(name = "EXPAND_FIELD6")
    private String expandFieldSix;

    @Column(name = "EXPAND_FIELD7")
    private String expandFieldSeven;

    @Column(name = "EXPAND_FIELD8")
    private String expandFieldEight;

    @Column(name = "EXPAND_FIELD9")
    private String expandFieldNine;

    @Column(name = "EXPAND_FIELD10")
    private String expandFieldTen;

}
