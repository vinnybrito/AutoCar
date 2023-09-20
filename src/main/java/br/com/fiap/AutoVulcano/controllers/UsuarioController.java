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
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.AutoVulcano.model.Usuario;
import br.com.fiap.AutoVulcano.repository.UsuarioRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class UsuarioController {

    @Autowired
    UsuarioRepository repository;

    @PostMapping("/usuario")
    public ResponseEntity<Usuario> create(@RequestBody @Valid Usuario usuario) {
        log.info("Cadastrando usuario - " + usuario);
        repository.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }

    @GetMapping("/usuario")
    public List<Usuario> index() {
        return repository.findAll();
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<Usuario> show(@PathVariable Long id) {
        log.info("Exibir Usuario pelo ID - " + id);
        return ResponseEntity.ok(getUsuarioById(id));
    }

    @PutMapping("/usuario/{id}") 
    public ResponseEntity<Usuario> update(@PathVariable Long id, @RequestBody Usuario usuario) {
        log.info("Atualizando usuario com ID - " + id);
        getUsuarioById(id);
        usuario.setId(id);
        repository.save(usuario);

        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping("/usuario/{id}") 
    public ResponseEntity<Usuario> destroy(@PathVariable Long id) {
        log.info("Apagando usuario com ID - " + id);
        repository.delete(getUsuarioById(id));
        return ResponseEntity.noContent().build();   
    }

    private Usuario getUsuarioById(Long id) {
        return repository.findById(id).orElseThrow(() -> {
            return new RuntimeException();
        });
    }

}
