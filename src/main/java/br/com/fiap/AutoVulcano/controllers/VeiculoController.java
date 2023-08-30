package br.com.fiap.AutoVulcano.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

@RestController
public class VeiculoController {

    Logger log = LoggerFactory.getLogger(getClass());

    List<Veiculo> veiculos = new ArrayList<>();

    @PostMapping("/anunciar")
    public ResponseEntity<Veiculo> create (@RequestBody Veiculo veiculo) {
        log.info("Cadastrando veiculo" + veiculo);
        veiculo.setId(veiculos.size() + 1L);
        veiculos.add(veiculo);
        return ResponseEntity.status(HttpStatus.CREATED).body(veiculo);
    }
    
    @GetMapping("/anunciar")
    public List<Veiculo> index() {
        return veiculos;
    }

    @GetMapping("/anunciar/{id}")
    public ResponseEntity<Veiculo> show(@PathVariable Long id) {
        log.info("Mostrando veiculo com ID - " + id);
        var veiculoEncontrado = veiculos
                                    .stream()
                                    .filter( (veiculo) -> veiculo.getId().equals(id))
                                    .findFirst();

        if (veiculoEncontrado.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        
        return ResponseEntity.ok(veiculoEncontrado.get());
    } 

    @PutMapping("/anunciar/{id}")
    public ResponseEntity<Veiculo> update(@PathVariable Long id, @RequestBody Veiculo veiculo) {
        log.info("Atualizando dados do veiculo com ID - " + id);

        var veiculoEncontrado = veiculos
                                    .stream()
                                    .filter( (v) -> v.getId().equals(id))
                                    .findFirst();   
                                    
        if (veiculoEncontrado.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        veiculos.remove(veiculoEncontrado.get());
        veiculo.setId(id);
        veiculos.add(veiculo);

        return ResponseEntity.ok(veiculo);

    }

    @DeleteMapping("/anunciar/{id}")
    public ResponseEntity<Veiculo> destroy(@PathVariable Long id) {
        log.info("Apagando veiculo com ID - " + id);

        var veiculoEncontrado = veiculos
                                    .stream()
                                    .filter( (veiculo) -> veiculo.getId().equals(id))
                                    .findFirst();
        
        if (veiculoEncontrado.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        veiculos.remove(veiculoEncontrado.get()); 
        return ResponseEntity.noContent().build();
    }

}
