package com.mighty.webreport.domain.entity.admin;

import com.mighty.webreport.domain.entity.idclass.DeviceCustomerId;
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
@Table(name = "adm_device_customer")
@IdClass(DeviceCustomerId.class)
public class DeviceCustomer {

    @Id
    @Column(name = "PLANT")
    private String plant;

    @Id
    @Column(name = "DEVICE")
    private String device;

    @Id
    @Column(name = "CUSTOMER")
    private String customer;

    @Column(name = "CUSTOMER_DEVICE")
    private String customerDevice;

    @Column(name = "CUSTOMER_DEVICE_NAME")
    private String customerDeviceName;

    @Column(name = "CUSTOMER_DEVICE_ITEM")
    private String customerDeviceItem;

    @Column(name = "REG_TIME")
    private String regTime;

    @Column(name = "REG_USER")
    private String regUser;

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

    @Column(name = "UNIT_PRICE")
    private Integer unitPrice;

    @Column(name = "CURRENCY_UNIT")
    private String currencyUnit;

}
