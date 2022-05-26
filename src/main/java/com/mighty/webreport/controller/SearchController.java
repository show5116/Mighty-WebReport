package com.mighty.webreport.controller;

import com.mighty.webreport.domain.dto.CDODto;
import com.mighty.webreport.domain.dto.LotStatusResponse;
import com.mighty.webreport.domain.repository.lotstatus.LotStatusRepositoryCustom;
import com.mighty.webreport.security.AccountContext;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/search")
public class SearchController {

    private final LotStatusRepositoryCustom lotStatusRepositoryCustom;

    @PostMapping("/lot-status")
    public ResponseEntity<?> getPlantList(@RequestBody Map<String,Object> params ){
        System.out.println(params);
        System.out.println(params.get("customers"));
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        AccountContext accountContext = (AccountContext) authentication.getPrincipal();
        /*List<LotStatusResponse> lotStatus = lotStatusRepositoryCustom.getLotStatus(
                accountContext.getPlant(),
                dto.getCustomers,
                dto.getOperations,
                dto.getDevices);*/
        return ResponseEntity.ok("lotStatus");
    }
}
