package br.com.fiap.AutoVulcano.model.dto;

import br.com.fiap.AutoVulcano.model.UsuarioAuth;
//import jakarta.validation.Valid;

public record UsuarioAuthResponse(
    Long id,
    String nome,
    String email
) {

    public static UsuarioAuthResponse fromUsuarioAuth(UsuarioAuth usuarioAuth) {
        return new UsuarioAuthResponse(usuarioAuth.getId(), usuarioAuth.getNome(), usuarioAuth.getEmail());
    }
    
}
