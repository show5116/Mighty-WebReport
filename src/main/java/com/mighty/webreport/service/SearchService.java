package com.mighty.webreport.service;

import com.mighty.webreport.domain.dto.CDODto;

import java.util.HashMap;

public interface SearchService {

    public void getLotStatus(HashMap<String,Object> hashMap , CDODto dto);
}
