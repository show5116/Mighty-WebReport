package com.mighty.webreport.domain.entity.automate;

import com.mighty.webreport.domain.entity.aem.Equipment;
import com.mighty.webreport.domain.entity.idclass.EquipmentLotStatusId;
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
@Table(name = "asfc_eqplot_status")
@IdClass(EquipmentLotStatusId.class)
public class EquipmentLotStatus {

    @Id
    @Column(name = "PLANT")
    private String plant;

    @Id
    @Column(name = "LOT_NUMBER")
    private String lotNumber;

    @Id
    @Column(name = "EQUIPMENT_ID")
    private String equipmentId;

    @MapsId
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "PLANT", referencedColumnName = "PLANT"),
            @JoinColumn(name = "EQUIPMENT_ID", referencedColumnName = "EQUIPMENT_ID")
    })
    private Equipment equipment;

    @Column(name = "UPLEVEL_LOT" , nullable = false)
    private String uplevelLot;

    @Column(name = "MAIN_LOT" , nullable = false)
    private String mainLot;

    @Column(name = "TRANSACTION")
    private String transaction;

    @Column(name = "TRANS_TIME")
    private String transTime;

    @Column(name = "DEVICE" , nullable = false)
    private String device;

    @Column(name = "DEVICE_REV" , nullable = false)
    private String deviceRev;

    @Column(name = "OPERATION" , nullable = false)
    private String operation;

    @Column(name = "LOT_QTY1" , nullable = false)
    private Integer lotQtyOne;

    @Column(name = "LOT_QTY2")
    private Integer lotQtyTwo;

    @Column(name = "LOT_QTY1_UNIT" , nullable = false)
    private String lotQtyUnitOne;

    @Column(name = "LOT_QTY2_UNIT")
    private String lotQtyUnitTwo;

    @Column(name = "PROGRAM_ID")
    private String programId;

    @Column(name = "RECIPE_ID")
    private String recipeId;

    @Column(name = "USER_ID" , nullable = false)
    private String userId;

    @Column(name = "EQUIPMENT_UNIT")
    private String equipmentUnit;

}
