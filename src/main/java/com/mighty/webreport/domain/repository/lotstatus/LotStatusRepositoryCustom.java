package com.mighty.webreport.domain.repository.lotstatus;

import com.mighty.webreport.domain.dto.LotStatusResponse;

import java.util.List;

public interface LotStatusRepositoryCustom {

    public List<LotStatusResponse> getLotStatus(String plant , String[] customers, String[] operations, String[] devices);
}
