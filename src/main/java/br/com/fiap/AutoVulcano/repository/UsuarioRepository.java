package br.com.fiap.AutoVulcano.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.AutoVulcano.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
}
