package com.mighty.webreport.domain.entity.admin;

import com.mighty.webreport.domain.entity.idclass.DeviceId;
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
@Table(name = "adm_device")
@IdClass(DeviceId.class)
public class Device {

    @Id
    @Column(name = "PLANT")
    private String plant;

    @Id
    @Column(name = "DEVICE")
    private String deviceId;

    @Id
    @Column(name = "REVISION_NO")
    private String revisionNo;


    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "APPROVAL")
    private String approval;

    @Column(name = "APPROVAL_DATE")
    private String approvalDate;

    @Column(name = "APPROVAL_USER")
    private String approvalUser;

    @Column(name = "REVISION_DATE")
    private String revisionDate;

    @Column(name = "REVISION_USER")
    private String revisionUser;

    @Column(name = "REVISION_REMARK")
    private String revisionRemark;

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

    @Column(name = "TRAY_WIDTH")
    private String trayWidth;

    @Column(name = "TRAY_HEIGHT")
    private String trayHeight;

}
