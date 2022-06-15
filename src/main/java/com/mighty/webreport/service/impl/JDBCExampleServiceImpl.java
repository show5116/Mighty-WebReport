package com.mighty.webreport.service.impl;

import com.mighty.webreport.domain.dto.CDODto;
import com.mighty.webreport.domain.dto.LotStatusResponse;
import com.mighty.webreport.domain.repository.jdbcrepository.JDBCExampleRepository;
import com.mighty.webreport.security.AccountContext;
import com.mighty.webreport.service.JDBCExampleService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class JDBCExampleServiceImpl implements JDBCExampleService {

    private final JDBCExampleRepository jdbcExampleRepository;

    @Override
    @Transactional(readOnly = true)
    public void getLotStatus(HashMap<String,Object> hashMap, CDODto dto){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        AccountContext accountContext = (AccountContext) authentication.getPrincipal();

        List<LotStatusResponse> lotStatus = jdbcExampleRepository.getLotStatus(accountContext.getPlant(),
                dto.getCustomersString(),
                dto.getOperationsString(),
                dto.getDevicesString());

        hashMap.put("lotStatus",lotStatus);
    }
}
