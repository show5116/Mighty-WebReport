package com.mighty.webreport.domain.repository.querydsl.impl;

import com.mighty.webreport.domain.dto.DeviceResponse;
import com.mighty.webreport.domain.repository.querydsl.DeviceRepositoryCustom;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.mighty.webreport.domain.entity.admin.QDevice.device;
import static com.mighty.webreport.domain.entity.admin.QDeviceCustomer.deviceCustomer;
import static com.mighty.webreport.domain.entity.admin.QDeviceSpec.deviceSpec;

@Repository
@RequiredArgsConstructor
public class DeviceRepositoryImpl implements DeviceRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<DeviceResponse> getDevice(String plant) {
        return jpaQueryFactory
                .select(Projections.fields(DeviceResponse.class,
                        deviceSpec.device.deviceId,
                        deviceSpec.device.description,
                        deviceCustomer.customer))
                .from(deviceSpec)
                .innerJoin(deviceSpec.device , device)
                .innerJoin(deviceCustomer)
                .on(deviceSpec.deviceId.eq(deviceCustomer.device)
                .and(deviceSpec.plant.eq(deviceCustomer.plant)))
                .where(deviceSpec.device.plant.eq(plant)
                .and(deviceSpec.disContinue.eq('N')))
                .orderBy(deviceSpec.deviceId.asc())
                .fetch();
    }
}
