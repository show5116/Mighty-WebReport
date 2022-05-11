package com.mighty.webreport.domain.entity.admin;


import com.mighty.webreport.domain.entity.idclass.AuthorityRoleId;
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
@Table(name = "adm_authority_role")
@IdClass(AuthorityRoleId.class)
public class AuthorityRole {

    @Id
    @Column(name = "PLANT")
    private String plantId;

    @Id
    @Column(name = "ROLE_ID")
    private String roleID;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "ROLE_GRADE")
    private Integer roleGrade;

    @Column(name = "PLANT_GROUP")
    private String plantGroup;

    @Column(name = "OPERATION_GROUP")
    private String operationGroup;

    @Column(name = "MES_MENU_GROUP")
    private String mesMenuGroup;

    @Column(name = "REPORT_MENU_GROUP")
    private String reportMenuGroup;

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

}
