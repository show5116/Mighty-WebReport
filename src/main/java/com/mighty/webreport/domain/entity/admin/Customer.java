package com.mighty.webreport.domain.entity.admin;

import com.mighty.webreport.domain.dto.CustomerDto;
import com.mighty.webreport.domain.entity.idclass.CustomerId;
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
@Table(name = "adm_customer")
@IdClass(CustomerId.class)
public class Customer {

    @Id
    @Column(name = "PLANT")
    private String plant;

    @Id
    @Column(name = "CUSTOMER")
    private String customer;

    @Column(name = "CUSTOMER_NAME")
    private String customerName;

    @Column(name = "CUSTOMER_ALIAS")
    private String customerAlias;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "BUSINESS_STATUS")
    private String businessStatus;

    @Column(name = "BUSINESS_ITEM")
    private String businessItem;

    @Column(name = "BUSINESS_REGNO")
    private String businessRegno;

    @Column(name = "REPRESENTATION")
    private String rePresentation;

    @Column(name = "CONTACT_OWNER")
    private String contactOwner;

    @Column(name = "CONTACT_POINT")
    private String contactPoint;

    @Column(name = "CONSIGNEE")
    private String consignee;

    @Column(name = "VENDOR_CODE")
    private String vendorCode;

    @Column(name = "REMARK")
    private String remark;

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

    public CustomerDto toDTO(){
        return CustomerDto.builder()
                .customer(this.customer)
                .customerName(this.customerName)
                .build();
    }
}
