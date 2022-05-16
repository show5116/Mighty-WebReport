package com.mighty.webreport.domain.dto;

import lombok.*;

import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MenuResponse {

    private String menuId;

    private String isActionMenu;

    private String menuNameKor;

    private String menuNameEng;

    private Character hasChild;

    private String parentKey;

    private Integer displayDepth;

    private Integer actionSeq;

    private String action;

    private List<MenuResponse> child;
}
