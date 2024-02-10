package br.com.fiap.AutoVulcano.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.AutoVulcano.model.dto.Token;

@RestController
public class UserController {
    
    @PostMapping("/login")
    public ResponseEntity<Token> login() {
        return ResponseEntity.ok(new Token("token_falso", "JWT", "Bearer"));
    }
    
}
