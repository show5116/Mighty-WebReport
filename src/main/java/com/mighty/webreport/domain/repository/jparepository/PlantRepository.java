package com.mighty.webreport.domain.repository.jparepository;

import com.mighty.webreport.domain.entity.admin.Plant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlantRepository extends JpaRepository<Plant,String> {
}
