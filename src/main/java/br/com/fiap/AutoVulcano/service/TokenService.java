package br.com.fiap.AutoVulcano.service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import br.com.fiap.AutoVulcano.model.UsuarioAuth;
import br.com.fiap.AutoVulcano.model.dto.Token;
import br.com.fiap.AutoVulcano.repository.UsuarioAuthRepository;
@Service
public class TokenService {

    @Autowired
    UsuarioAuthRepository repository;
    
    public Token generateToken(String email) {
        Algorithm alg = Algorithm.HMAC512("meusecretsupersecreto");
        var jwt = JWT.create()
            .withIssuer("AutoCar")
            .withSubject(email)
            .withExpiresAt(Instant.now().plus(7, ChronoUnit.DAYS))
            .sign(alg);

            return new Token(jwt, "JWT", "Bear");
    }

    public UsuarioAuth validateToken(String token){
        Algorithm alg = Algorithm.HMAC512("meusecretsupersecreto");
        String email = JWT.require(alg)
            .withIssuer("AutoCar")
            .build()
            .verify(token)
            .getSubject();

            return repository
            .findByEmail(email)
            .orElseThrow(() -> new JWTVerificationException("Erro na verificação do token"));
    }

}
