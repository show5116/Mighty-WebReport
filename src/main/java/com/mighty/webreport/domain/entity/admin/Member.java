package com.mighty.webreport.domain.entity.admin;

import com.mighty.webreport.domain.entity.idclass.MemberId;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Getter
@Entity
@DynamicUpdate
@DynamicInsert
@NoArgsConstructor
@Table(name = "adm_USER_INFO")
@IdClass(MemberId.class)
@EntityListeners(AuditingEntityListener.class)
public class Member {

    @Id
    @Column(name = "USER_ID")
    private String userId;

    @Id
    @Column(name = "PLANT")
    private String plant;

    @Column(name = "PASSWORD_MD5")
    private String passwordMD5;

    @Column(name = "password")
    private String password;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "EMAIL_ID")
    private String email;

    @Column(name = "PHONE_NO")
    private String phone;

    @Column(name = "ROLE_ID")
    private String role;

    @Column(name = "REG_USER")
    private String regUser;

    @Column(name = "REG_TIME")
    private String regTime;

    @Column(name = "LANGUAGE_TYPE")
    private String languageType;

    @Column(name = "EXTERNAL_TYPE")
    private String externalType;

    @Column(name = "EXTERNAL_FLAG")
    private String externalFlag;

    @Column(name = "EXPIRE_DATE")
    private String expireDate;

    @Column(name = "EXPAND_FLAG1")
    private String expandFlagOne;

    @Column(name = "EXPAND_FLAG2")
    private String expandFlagTwo;

    @Column(name = "EXPAND_FLAG3")
    private String expandFlagThree;

    @Column(name = "EXPAND_FLAG4")
    private String expandFlagFour;

    @Column(name = "EXPAND_FLAG5")
    private String expandFlagFive;

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

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "DEPARTMENT")
    private String department;

    @Column(name = "ADMISSION")
    private String admission;

    @Column(name = "ACCESS_GROUP_ID")
    private String accessGroupId;
}
