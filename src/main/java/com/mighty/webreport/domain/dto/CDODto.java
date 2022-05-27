package com.mighty.webreport.domain.dto;

import lombok.*;

import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CDODto {

    private List<IdTextDto> customers;

    private List<IdTextDto> operations;

    private List<IdTextDto> devices;
}
