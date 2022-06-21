package com.mighty.webreport.repository.jparepository;

import com.mighty.webreport.domain.dto.OperationResponse;
import com.mighty.webreport.domain.entity.admin.Operation;
import com.mighty.webreport.domain.entity.idclass.OperationId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OperationRepository extends JpaRepository<Operation, OperationId> {

    @Query(name = "getOperationList", nativeQuery = true)
    public List<OperationResponse> getOperationList(@Param(value = "plant") String plant);
}
