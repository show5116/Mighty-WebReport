package com.mighty.webreport.repository.querydsl;

import com.mighty.webreport.domain.dto.MenuResponse;

import java.util.List;

public interface MenuRepositoryCustom {

    public List<MenuResponse> getMenu(String plant);
}
