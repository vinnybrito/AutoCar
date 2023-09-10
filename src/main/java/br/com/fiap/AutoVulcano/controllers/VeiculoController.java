package br.com.fiap.AutoVulcano.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.AutoVulcano.model.Veiculo;
import br.com.fiap.AutoVulcano.repository.VeiculoRepository;
import ch.qos.logback.core.joran.util.beans.BeanUtil;

@RestController
public class VeiculoController {

    Logger log = LoggerFactory.getLogger(getClass());

    List<Veiculo> veiculos = new ArrayList<>();

    @Autowired
    VeiculoRepository repository;

    @PostMapping("/anunciar")
    public ResponseEntity<Veiculo> create (@RequestBody Veiculo veiculo) {
        log.info("Cadastrando veiculo" + veiculo);
        repository.save(veiculo);
        return ResponseEntity.status(HttpStatus.CREATED).body(veiculo);
    }
    
    @GetMapping("/anunciar")
    public List<Veiculo> index() {
        return repository.findAll();
    }

    @GetMapping("/anunciar/{id}")
    public ResponseEntity<Veiculo> show(@PathVariable Long id) {
        log.info("Mostrando veiculo com ID - " + id);
        return ResponseEntity.ok(getVeiculoById(id));
    } 

    @PutMapping("/anunciar/{id}")
    public ResponseEntity<Veiculo> update(@PathVariable Long id, @RequestBody Veiculo veiculo) {
        log.info("Atualizando dados do veiculo com ID - " + id);
        getVeiculoById(id);
        veiculo.setId(id);
        repository.save(veiculo);

        return ResponseEntity.ok(veiculo);

    }

    @DeleteMapping("/anunciar/{id}")
    public ResponseEntity<Veiculo> destroy(@PathVariable Long id) {
        log.info("Apagando veiculo com ID - " + id);
        repository.delete(getVeiculoById(id));
        return ResponseEntity.noContent().build();
    }

    private Veiculo getVeiculoById(Long id){
        return repository.findById(id).orElseThrow(() -> {
            return new RuntimeException();
        });
    }

}
