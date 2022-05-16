package com.mighty.webreport.domain.entity.system;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Entity
@DynamicUpdate
@DynamicInsert
@NoArgsConstructor
@Table(name = "sys_menu_action")
public class MenuAction {

    @Id
    @Column(name = "ACTION_SEQ")
    private Integer actionSeq;

    @Column(name = "MODULE_ID")
    private String moduleId;

    @Column(name = "ACTION_TYPE")
    private Character actionType;

    @Column(name = "ACTION_NAME_KOR")
    private String actionNameKor;

    @Column(name = "ACTION_NAME_ENG")
    private String actionNameEng;

    @Column(name = "ACTION_NAME_01")
    private String actionNameOne;

    @Column(name = "ACTION_NAME_02")
    private String actionNameTwo;

    @Column(name = "ACTION_NAME_03")
    private String actionNameThree;

    @Column(name = "ACTION")
    private String action;

    @Column(name = "CONTROL_TYPE")
    private String controlType;

    @Column(name = "CONTROL_VALUE")
    private String controlValue;

    @Column(name = "ENABLE_TOOLBAR")
    private Character enableToolbar;

    @Column(name = "TOOLBAR_ICON")
    private String toolbarIcon;

    @Column(name = "TOOLBAR_TEXT_KOR")
    private String toolbarTextKor;

    @Column(name = "TOOLBAR_TEXT_ENG")
    private String toolbarTextEng;

    @Column(name = "TOOLBAR_TEXT_01")
    private String toolbarTextOne;

    @Column(name = "TOOLBAR_TEXT_02")
    private String toolbarTextTwo;

    @Column(name = "TOOLBAR_TEXT_03")
    private String toolbarTextThree;

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
