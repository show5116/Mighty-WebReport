package com.mighty.webreport.controller;

import com.mighty.webreport.domain.dto.CDODto;
import com.mighty.webreport.domain.dto.ODLDateDto;
import com.mighty.webreport.service.SearchService;
import com.mighty.webreport.service.impl.JDBCExampleServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/search")
public class SearchController {

    private final SearchService searchService;

    private final JDBCExampleServiceImpl jdbcExample;

    @PostMapping("/lot-status")
    public ResponseEntity<?> getLotStatus(@RequestBody CDODto dto ){
        HashMap<String,Object> hashMap = new HashMap<>();
        //searchService.getLotStatus(hashMap,dto);
        jdbcExample.getLotStatus(hashMap,dto);
        return ResponseEntity.ok(hashMap);
    }

    @PostMapping("/defect-status")
    public ResponseEntity<?> getDefectStatus(@RequestBody ODLDateDto dto ){
        HashMap<String,Object> hashMap = new HashMap<>();
        searchService.getDefectStatus(hashMap,dto);
        return ResponseEntity.ok(hashMap);
    }
}
