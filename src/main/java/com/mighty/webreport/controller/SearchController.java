package com.mighty.webreport.controller;

import com.mighty.webreport.domain.dto.CDODto;
import com.mighty.webreport.domain.dto.LotStatusResponse;
import com.mighty.webreport.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/search")
public class SearchController {

    private final SearchService searchService;

    @PostMapping("/lot-status")
    public ResponseEntity<?> getPlantList(@RequestBody CDODto dto ){
        HashMap<String,Object> hashMap = new HashMap<>();
        searchService.getLotStatus(hashMap,dto);
        return ResponseEntity.ok(hashMap);
    }
}
