package com.mighty.webreport.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Builder
public class DefectResponse {
    private String device;

    private String operation;

    private String lotNumber;

    private Integer totalLbrQty;

    private Integer lossScrapQty;

    private Integer lossRepairQty;

    private Integer m1Scratch;

    private Integer crack;

    private Integer chip;

    private Integer scratch;
}
