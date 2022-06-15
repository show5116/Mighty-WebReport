package com.mighty.webreport.controller;

import com.mighty.webreport.domain.dto.AuthenticationDto;
import com.mighty.webreport.domain.entity.admin.Plant;
import com.mighty.webreport.domain.repository.querydsl.PlantRepositoryCustom;
import com.mighty.webreport.security.AuthCode;
import com.mighty.webreport.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private final PlantRepositoryCustom plantRepositoryCustom;

    private final LoginService loginService;

    @GetMapping("/plant")
    public ResponseEntity<?> getPlantList(@RequestParam String userId){
        List<Plant> plantList = plantRepositoryCustom.findAllByUserId(userId);
        return ResponseEntity.ok(plantList);
    }

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody AuthenticationDto authenticationDto){
        HashMap<String,Object> hashMap = loginService.setAuth(authenticationDto);
        HttpHeaders headers = new HttpHeaders();
        if((boolean)hashMap.get("isAuth")){
            headers.set("code", AuthCode.LOG_IN.getCode());
            headers.set("message",AuthCode.LOG_IN.getMessage());
        }else{
            headers.set("code", AuthCode.UNAUTHORIZED.getCode());
            headers.set("message",AuthCode.UNAUTHORIZED.getMessage());
        }
        return ResponseEntity.ok().headers(headers).body(hashMap);
    }
}
