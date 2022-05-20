package com.mighty.webreport.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@Builder
public class CustomerDto {
    public String customer;

    public String customerName;
}
