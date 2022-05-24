package com.mighty.webreport.domain.entity.system;

import com.mighty.webreport.domain.entity.idclass.MenuStructureId;
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
@Table(name = "sys_menu_structure")
@IdClass(MenuStructureId.class)
public class MenuStructure {

    @Id
    @Column(name = "PLANT")
    private String plant;

    @Id
    @Column(name = "MODULE_ID")
    private String moduleId;

    @Id
    @Column(name = "GROUP_ID")
    private String groupId;

    @Id
    @Column(name = "MENU_ID")
    private String menuId;

    @Column(name = "MENU_NAME_KOR")
    private String menuNameKor;

    @Column(name = "MENU_NAME_ENG")
    private String menuNameEng;

    @Column(name = "MENU_NAME_01")
    private String menuNameOne;

    @Column(name = "MENU_NAME_02")
    private String meuuNameTwo;

    @Column(name = "MENU_NAME_03")
    private String manuNameThree;

    @Column(name = "HAS_CHILD" , nullable = false)
    private Character hasChild;

    @Column(name = "PARENT_KEY")
    private String parentKey;

    @Column(name = "DISPLAY_DEPTH")
    private Integer displayDepth;

    @Column(name = "PATH")
    private String path;

    @Column(name = "ACTION_SEQ")
    private Integer actionSeq;

    @Column(name = "SHORTCUT_KEY")
    private String shortcutKey;

    @Column(name = "SEPERATE_BAR" , nullable = false)
    private Character seperateBar;

    @Column(name = "VISIBLE_FLAG" , nullable = false)
    private Character visibleFlag;

    @Column(name = "ENABLE_FLAG" , nullable = false)
    private Character enableFlag;

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

    @Column(name = "MENU_ROOT_KEY")
    private String menuRootKey;

    @Column(name = "MENU_PARENT_KEY")
    private String menuParentKey;

}
