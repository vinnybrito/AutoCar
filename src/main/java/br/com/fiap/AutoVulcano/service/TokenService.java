package br.com.fiap.AutoVulcano.service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import br.com.fiap.AutoVulcano.model.dto.Token;

@Service
public class TokenService {
    
    public Token generateToken(String email) {
        Algorithm alg = Algorithm.HMAC512("meusecretsupersecreto");
        var jwt = JWT.create()
            .withIssuer("AutoCar")
            .withSubject(email)
            .withExpiresAt(Instant.now().plus(10, ChronoUnit.MINUTES))
            .sign(alg);

            return new Token(jwt, "JWT", "Bear");
    }

}
