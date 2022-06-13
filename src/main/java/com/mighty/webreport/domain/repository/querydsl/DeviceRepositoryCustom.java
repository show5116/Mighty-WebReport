package com.mighty.webreport.domain.repository.querydsl;

import com.mighty.webreport.domain.dto.DeviceResponse;

import java.util.List;

public interface DeviceRepositoryCustom {

    public List<DeviceResponse> getDevice(String plant);
}
