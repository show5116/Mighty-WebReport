package com.mighty.webreport.domain.repository.system;

import com.mighty.webreport.domain.dto.MenuResponse;

import java.util.List;

public interface MenuRepositoryCustom {

    public List<MenuResponse> getMenu(String plant);
}
