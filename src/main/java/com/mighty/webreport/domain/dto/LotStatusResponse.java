package com.mighty.webreport.domain.dto;

import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LotStatusResponse {

    private String operation;

    private String lotNumber;

    private String mainLot;

    private Integer qtyOne;

    private String qtyUnitOne;

    private Integer qtyTwo;

    private String qtyUnitTwo;

    private String device;

    private String customer;

    private Character inHold;

    private String holdNote;

    private Character inRework;

    private String processFlag;

    private String deviceVer;

    private String deviceAttribute;

    private String shipAttribute;

    private String route;

    private String enterOperTime;

    private String equipmentId;
}
