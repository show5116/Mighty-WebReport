package com.mighty.webreport.domain.repository.admin.plant;

import com.mighty.webreport.domain.entity.admin.Plant;

import java.util.List;

public interface PlantRepositoryCustom {

    List<Plant> findAllByUserId(String userId);
}
