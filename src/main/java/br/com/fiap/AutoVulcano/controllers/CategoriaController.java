package br.com.fiap.AutoVulcano.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.AutoVulcano.model.Categoria;

@RestController
public class CategoriaController {
    
    @GetMapping("/categorias")
    // O Spring usa uma biblioteca chamada "jaackson" para converter objetos para o JSON e vice versa;
    public Categoria index() {
        return new Categoria("Educação", "Graduate");
    }

}
