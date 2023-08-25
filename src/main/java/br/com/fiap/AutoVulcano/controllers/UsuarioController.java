package br.com.fiap.AutoVulcano.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.AutoVulcano.model.Usuario;
import br.com.fiap.AutoVulcano.model.Veiculo;


@RestController
public class UsuarioController {

    @GetMapping("/cadastro")

        public Usuario index() {
        Veiculo veiculo_usuario = new Veiculo(1L, "PEUGEOT", "308cc", "2015", "2015", "Turbo gasolina 2P", "Cinza");

        return new Usuario(1, "Matheus Araujo", "matheus.araujo@hotmail.com", "Math@23", "11945678456", "08380074", "SP", "Santo André", veiculo_usuario);

    }
}
