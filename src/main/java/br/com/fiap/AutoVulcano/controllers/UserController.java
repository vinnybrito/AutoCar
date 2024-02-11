package br.com.fiap.AutoVulcano.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.AutoVulcano.model.dto.Token;
import br.com.fiap.AutoVulcano.service.TokenService;

@RestController
public class UserController {

    @Autowired
    TokenService service;
    
    @PostMapping("/login")
    public ResponseEntity<Token> login() {
        return ResponseEntity.ok( service.generateToken("vini@fiap.com.br") );
    }
    
}
