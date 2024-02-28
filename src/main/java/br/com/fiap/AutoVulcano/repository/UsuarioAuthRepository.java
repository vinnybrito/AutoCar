package br.com.fiap.AutoVulcano.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.fiap.AutoVulcano.model.UsuarioAuth;

public interface UsuarioAuthRepository extends JpaRepository<UsuarioAuth, Long>{

    Optional<UsuarioAuth> findByEmail(String email);

}
