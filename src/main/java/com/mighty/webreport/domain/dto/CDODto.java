package com.mighty.webreport.domain.dto;

import lombok.*;

import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CDODto {

    private List<String> customers;

    private List<String> operations;

    private List<String> devices;
}
