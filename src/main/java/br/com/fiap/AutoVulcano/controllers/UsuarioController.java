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

import br.com.fiap.AutoVulcano.model.Usuario;

@RestController
public class UsuarioController {

    Logger log = LoggerFactory.getLogger(getClass());

    List<Usuario> usuarios = new ArrayList<>();

    @PostMapping
    public ResponseEntity<Usuario> create(@RequestBody Usuario usuario) {
        log.info("Cadastrando usuario - " + usuario);
        usuario.setId(usuarios.size() + 1L);
        usuarios.add(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }

    @GetMapping("/usuario")
    public List<Usuario> index() {
        return usuarios;
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<Usuario> show(@PathVariable Long id) {
        log.info("Exibir Usuario pelo ID - " + id);
        var usuarioEncontrado = usuarios
                                    .stream()
                                    .filter( (veiculo) -> veiculo.getId()
                                    .equals(id))
                                    .findFirst();

        if (usuarioEncontrado.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(usuarioEncontrado.get());
    }

    @PutMapping("/usuario/{id}") 
    public ResponseEntity<Usuario> update(@PathVariable Long id, @RequestBody Usuario usuario) {
        log.info("Atualizando usuario com ID - " + id);
        var usuarioEncontrado = usuarios
                                    .stream()
                                    .filter( (u) -> u.getId().equals(id) )
                                    .findFirst(); 
        
        if (usuarioEncontrado.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        usuarios.remove(usuarioEncontrado.get());
        usuario.setId(id);
        usuarios.add(usuario);

        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping("/usuario/{id}") 
    public ResponseEntity<Usuario> destroy(@PathVariable Long id) {
        log.info("Apagando usuario com ID - " + id);

        var usuarioEncontrado = usuarios
                                    .stream()
                                    .filter( (usuario) -> usuario.getId().equals(id) )
                                    .findFirst(); 
        
        if (usuarioEncontrado.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        usuarios.remove(usuarioEncontrado.get());
        return ResponseEntity.noContent().build();
        
    }

}
