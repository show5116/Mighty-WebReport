package com.mighty.webreport.controller;

import com.mighty.webreport.domain.dto.AuthenticationDto;
import com.mighty.webreport.domain.dto.JwtAuthenticationResponse;
import com.mighty.webreport.domain.entity.admin.Plant;
import com.mighty.webreport.domain.repository.admin.member.MemberRepository;
import com.mighty.webreport.domain.repository.admin.plant.PlantRepositoryCustom;
import com.mighty.webreport.security.AccountContext;
import com.mighty.webreport.security.JwtAuthProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;

    private final PlantRepositoryCustom plantRepositoryCustom;

    private final JwtAuthProvider provider;

    @GetMapping("/plant")
    public ResponseEntity<?> getPlantList(@RequestParam String userId){
        List<Plant> plantList = plantRepositoryCustom.findAllByUserId(userId);
        return ResponseEntity.ok(plantList);
    }

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody AuthenticationDto authenticationDto){
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(
                authenticationDto.getId(),
                authenticationDto.getPassword()
        );

        Authentication authentication = authenticationManager.authenticate(
          usernamePasswordAuthenticationToken
        );

        AccountContext accountContext = (AccountContext) authentication.getPrincipal();
        accountContext.setPlant(authenticationDto.getPlant());

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = provider.createToken(authentication);
        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
    }
}
