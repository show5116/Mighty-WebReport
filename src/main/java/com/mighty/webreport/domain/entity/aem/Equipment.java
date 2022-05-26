package com.mighty.webreport.domain.entity.aem;

import com.mighty.webreport.domain.entity.idclass.EquipmentId;
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
@Table(name = "aem_equipment")
@IdClass(EquipmentId.class)
public class Equipment {

    @Id
    @Column(name = "PLANT")
    private String plant;

    @Id
    @Column(name = "EQUIPMENT_ID")
    private String equipmentId;

    @Column(name = "WORK_CENTER")
    private String workCenter;

    @Column(name = "SYS_TRANS_TIME")
    private String sysTransTime;

    @Column(name = "TRANS_TIME")
    private String transTime;

    @Column(name = "EVENT_ID")
    private String eventId;

    @Column(name = "AVAILABILITY")
    private Character availability;

    @Column(name = "DOWN_REASON")
    private String downReason;

    @Column(name = "MAIN_STATUS")
    private String mainStatus;

    @Column(name = "STATUS_CATEGORY")
    private String statusCategory;

    @Column(name = "USER_ID")
    private String userId;

    @Column(name = "USER_COMMENT")
    private String userComment;

    @Column(name = "EQUIPMENT_UNIT")
    private String equipmentUnit;

}
