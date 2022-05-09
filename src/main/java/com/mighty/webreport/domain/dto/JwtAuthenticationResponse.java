package com.mighty.webreport.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class JwtAuthenticationResponse {

    private String accessToken;

    private String tokenType;

    public JwtAuthenticationResponse(String accessToken){
        this.accessToken = accessToken;
        // JWT 혹은 OAuth에서 사용하는 토큰
        this.tokenType = "Bearer";
    }

}
