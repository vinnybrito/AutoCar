package br.com.fiap.AutoVulcano.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.AutoVulcano.model.UsuarioAuth;
import br.com.fiap.AutoVulcano.model.dto.Credenciais;
import br.com.fiap.AutoVulcano.model.dto.Token;
import br.com.fiap.AutoVulcano.model.dto.UsuarioAuthResponse;
import br.com.fiap.AutoVulcano.repository.UsuarioAuthRepository;
import br.com.fiap.AutoVulcano.service.TokenService;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
public class UsuarioAuthController {
    
    @Autowired
    TokenService service;

    @Autowired
    UsuarioAuthRepository repository;

    @Autowired
    AuthenticationManager authManager;

    @Autowired
    PasswordEncoder encoder;

    @PostMapping("/login")
    public ResponseEntity<Token> login(@RequestBody Credenciais credenciais){
        log.info(credenciais);
        authManager.authenticate(credenciais.toAuthentication());
        return ResponseEntity.ok(service.generateToken(credenciais.email()));

    }

    @PostMapping("/usuarioauth")
    public ResponseEntity<UsuarioAuthResponse> create(@RequestBody @Valid UsuarioAuth usuarioAuth){
        usuarioAuth.setSenha(encoder.encode(usuarioAuth.getSenha()));
        repository.save(usuarioAuth);
        return ResponseEntity.status(HttpStatus.CREATED).body(UsuarioAuthResponse.fromUsuarioAuth(usuarioAuth));

    }
}
