package br.com.fiap.AutoVulcano.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.AutoVulcano.model.Veiculo;

@RestController
public class VeiculoController {

    Logger log = LoggerFactory.getLogger(getClass());

    List<Veiculo> veiculos = new ArrayList<>();
    
    @GetMapping("/anunciar")
    public List<Veiculo> index() {
        return veiculos;
    }

    @PostMapping("/anunciar")
    public ResponseEntity<Object> create (@RequestBody Veiculo veiculo) {
        log.info("Cadastrando veiculo" + veiculo);
        veiculo.setId(veiculos.size() + 1L);
        veiculos.add(veiculo);
        return ResponseEntity.status(201).body(veiculo);
    }

}
