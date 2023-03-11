package com.gec.attendance.attendancesystem.controller;

import com.gec.attendance.attendancesystem.service.JwtTokenRequest;
import com.gec.attendance.attendancesystem.service.JwtTokenResponse;
import com.gec.attendance.attendancesystem.service.JwtTokenService;
import org.springframework.security.authentication.AuthenticationManager;


import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JwtAuthenticationResource {

    private final JwtTokenService tokenService;

    private final AuthenticationManager authenticationManager;

    public JwtAuthenticationResource(JwtTokenService tokenService,
                                     AuthenticationManager authenticationManager) {
        this.tokenService = tokenService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<JwtTokenResponse> generateToken(
            @RequestBody JwtTokenRequest jwtTokenRequest) {

        var authenticationToken =
                new UsernamePasswordAuthenticationToken(
                        jwtTokenRequest.username(),
                        jwtTokenRequest.password());

        var authentication =
                authenticationManager.authenticate(authenticationToken);

        var token = tokenService.generateToken(authentication);

        return ResponseEntity.ok(new JwtTokenResponse(token));
    }
}