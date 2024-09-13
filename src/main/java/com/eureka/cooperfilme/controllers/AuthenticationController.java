package com.eureka.cooperfilme.controllers;

import com.eureka.cooperfilme.domain.user.User;
import com.eureka.cooperfilme.services.useCases.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import com.eureka.cooperfilme.domain.user.userDTOs.AuthenticationDTO;
import com.eureka.cooperfilme.domain.user.userDTOs.LoginResponseDTO;

@RestController
@RequestMapping(value = "/auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping(value = "/login")
    public ResponseEntity<?> login (@RequestBody @Valid AuthenticationDTO authenticationDTO) {
        var userNamePassword = new UsernamePasswordAuthenticationToken(authenticationDTO.email(), authenticationDTO.password());

        var auth = this.authenticationManager.authenticate(userNamePassword);
        var user = (User) auth.getPrincipal();

        if (!user.getRole().equals(authenticationDTO.role())) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body("Invalid role");
        }
        var token = tokenService.generateToken((User) auth.getPrincipal());
        return ResponseEntity.ok(new LoginResponseDTO(token));
    }
}
