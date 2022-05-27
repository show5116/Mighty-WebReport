package com.mighty.webreport.service.impl;

import com.mighty.webreport.domain.dto.CDODto;
import com.mighty.webreport.domain.dto.IdTextDto;
import com.mighty.webreport.domain.dto.LotStatusResponse;
import com.mighty.webreport.domain.repository.lotstatus.LotStatusRepositoryCustom;
import com.mighty.webreport.security.AccountContext;
import com.mighty.webreport.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchServiceImpl implements SearchService {

    private final LotStatusRepositoryCustom lotStatusRepositoryCustom;

    @Override
    public void getLotStatus(HashMap<String,Object> hashMap , CDODto dto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        AccountContext accountContext = (AccountContext) authentication.getPrincipal();

        List<String> customers = new ArrayList<>();
        List<String> operations = new ArrayList<>();
        List<String> devices = new ArrayList<>();

        for (IdTextDto idTextDto : dto.getCustomers()) {
            customers.add(idTextDto.getId());
        }

        for (IdTextDto idTextDto : dto.getOperations()) {
            operations.add(idTextDto.getId());
        }

        for (IdTextDto idTextDto : dto.getDevices()) {
            devices.add(idTextDto.getId());
        }

        List<LotStatusResponse> lotStatus = lotStatusRepositoryCustom.getLotStatus(
                accountContext.getPlant(),
                customers,
                operations,
                devices);

        hashMap.put("lotStatus",lotStatus);
    }
}
