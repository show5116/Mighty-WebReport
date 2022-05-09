package com.mighty.webreport.controller;

import com.mighty.webreport.domain.dto.AuthenticationDto;
import com.mighty.webreport.domain.dto.JwtAuthenticationResponse;
import com.mighty.webreport.domain.repository.MemberRepository;
import com.mighty.webreport.security.JwtAuthProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;

    private final MemberRepository memberRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtAuthProvider provider;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody AuthenticationDto authenticationDto){

        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                authenticationDto.getId(),
                authenticationDto.getPassword()
            )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = provider.createToken(authentication);

        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
    }


}
