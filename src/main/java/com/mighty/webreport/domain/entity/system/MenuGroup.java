package com.mighty.webreport.domain.entity.system;

import com.mighty.webreport.domain.entity.idclass.MenuGroupId;
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
@Table(name = "sys_menu_group")
@IdClass(MenuGroupId.class)
public class MenuGroup {

    @Id
    @Column(name = "PLANT")
    private String plant;

    @Id
    @Column(name = "MODULE_ID")
    private String moduleId;

    @Id
    @Column(name = "GROUP_ID")
    private String groupId;

    @Column(name = "GROUP_NAME")
    private String groupName;

    @Column(name = "VISIBLE_FLAG")
    private Character visibleFlag;

    @Column(name = "DESCRIPTION")
    private String description;

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

    @Column(name = "EXP_DESCRIPTION")
    private String expDescription;

}
