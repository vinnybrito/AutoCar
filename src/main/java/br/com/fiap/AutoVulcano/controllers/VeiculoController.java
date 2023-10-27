package br.com.fiap.AutoVulcano.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.AutoVulcano.model.Veiculo;
import br.com.fiap.AutoVulcano.model.dto.LocalidadeVeiculo;
import br.com.fiap.AutoVulcano.repository.VeiculoRepository;
import br.com.fiap.AutoVulcano.service.VeiculoService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("anunciar")
public class VeiculoController {

    @Autowired
    VeiculoRepository repository;

    @Autowired
    VeiculoService service;

    @PostMapping
    public ResponseEntity<Veiculo> create (@RequestBody @Valid Veiculo veiculo) {
        log.info("Cadastrando veiculo" + veiculo);
        repository.save(veiculo);
        return ResponseEntity.status(HttpStatus.CREATED).body(veiculo);
    }

    @GetMapping
    public List<Veiculo> index() {
        log.info("Buscando todos os anuncios");
        return repository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Veiculo> show(@PathVariable Long id) {
        log.info("Mostrando veiculo com ID - " + id);
        return ResponseEntity.ok(getVeiculoById(id));
    } 

    @PutMapping("{id}")
    public ResponseEntity<Veiculo> update(@PathVariable Long id, @RequestBody Veiculo veiculo) {
        log.info("Atualizando dados do veiculo com ID - " + id);
        getVeiculoById(id);
        veiculo.setId(id);
        repository.save(veiculo);

        return ResponseEntity.ok(veiculo);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Veiculo> destroy(@PathVariable Long id) {
        log.info("Apagando veiculo com ID - " + id);
        repository.delete(getVeiculoById(id));
        return ResponseEntity.noContent().build();
    }

    @GetMapping("cidade")
    public ResponseEntity<List<LocalidadeVeiculo>> localidadeDeVeiculo() {
        var lista = service.getLocalidadeDeVeiculo();
        return ResponseEntity.ok(lista);
    }

    private Veiculo getVeiculoById(Long id) {
        return repository.findById(id).orElseThrow(() -> {
            return new RuntimeException();
        });
    }

}
