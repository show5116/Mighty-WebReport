package com.mighty.webreport.service;

import com.mighty.webreport.domain.dto.AuthenticationDto;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;

public interface LoginService {
    public HashMap<String,Object> setAuth(AuthenticationDto authenticationDto);
}
