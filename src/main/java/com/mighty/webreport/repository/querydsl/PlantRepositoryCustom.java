package com.mighty.webreport.repository.querydsl;

import com.mighty.webreport.domain.entity.admin.Plant;

import java.util.List;

public interface PlantRepositoryCustom {

    List<Plant> findAllByUserId(String userId);
}
