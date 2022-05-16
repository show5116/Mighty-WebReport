package com.mighty.webreport.domain.entity.idclass;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class MenuStructureId implements Serializable {

    @Column(name = "PLANT")
    private String plant;

    @Column(name = "MODULE_ID")
    private String moduleId;

    @Column(name = "GROUP_ID")
    private String groupId;

    @Column(name = "MENU_ID")
    private String menuId;
}
