package com.mighty.webreport.domain.entity.idclass;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class DeviceCustomerId implements Serializable {

    @Column(name = "PLANT")
    private String plant;

    @Column(name = "DEVICE")
    private String device;

    @Column(name = "CUSTOMER")
    private String customer;
}
