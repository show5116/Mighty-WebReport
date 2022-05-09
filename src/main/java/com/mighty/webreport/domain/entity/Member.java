package com.mighty.webreport.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;

@Getter
@Entity
@DynamicUpdate
@DynamicInsert
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Member {

    @Id
    @Column(name = "USER_ID")
    private String userId;

    private String PASSWORD_MD5;

    private String password;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "PLANT")
    private String plant;

    @Column(name = "EMAIL_ID")
    private String email;

    @Column(name = "PHONE_NO")
    private String phone;

    @Column(name = "ROLE_ID")
    private String role;

    private String REG_USER;
    private String REG_TIME;
    private String LANGUAGE_TYPE;
    private String EXTERNAL_TYPE;
    private String EXTERNAL_FLAG;
    private String EXPIRE_DATE;
    private String EXPAND_FLAG5;
    private String EXPAND_FLAG4;
    private String EXPAND_FLAG3;
    private String EXPAND_FLAG2;
    private String EXPAND_FLAG1;
    private String EXPAND_FIELD9;
    private String EXPAND_FIELD8;
    private String EXPAND_FIELD7;
    private String EXPAND_FIELD6;
    private String EXPAND_FIELD5;
    private String EXPAND_FIELD4;
    private String EXPAND_FIELD3;
    private String EXPAND_FIELD2;
    private String EXPAND_FIELD10;
    private String EXPAND_FIELD1;
    private String DESCRIPTION;
    private String DEPARTMENT;
    private String ADMISSION;
    private String ACCESS_GROUP_ID;
}
