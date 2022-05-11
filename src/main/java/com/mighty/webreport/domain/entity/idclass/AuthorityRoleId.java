package com.mighty.webreport.domain.entity.idclass;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class AuthorityRoleId implements Serializable {

    @Column(name = "PLANT")
    private String plantId;

    @Column(name = "ROLE_ID")
    private String roleID;

}
