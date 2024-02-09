package br.com.fiap.AutoVulcano.repository;

//import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;

import br.com.fiap.AutoVulcano.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Page<Usuario> findByCidadeContainingIgnoreCase(String busca, Pageable pageRequest);
    
}
