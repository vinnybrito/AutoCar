package br.com.fiap.AutoVulcano.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.AutoVulcano.model.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

}
