package br.com.fiap.AutoVulcano.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.AutoVulcano.model.Veiculo;

@RestController
public class AnuncioController {
    
    @GetMapping("/anunciar")
    // O Spring usa uma biblioteca chamada "jaackson" para converter objetos para o JSON e vice versa;
    public Veiculo index() {
        return new Veiculo(
            1, 
            "PEUGEOT", 
            "308cc", 
            "2015", 
            "2015", 
            "Turbo gasolina 2P", 
            "Cinza"
            );
    }

}
