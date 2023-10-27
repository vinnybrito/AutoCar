package br.com.fiap.AutoVulcano.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.AutoVulcano.model.Usuario;
import br.com.fiap.AutoVulcano.model.dto.LocalidadeVeiculo;
import br.com.fiap.AutoVulcano.repository.UsuarioRepository;

@Service
public class VeiculoService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public List<LocalidadeVeiculo> getLocalidadeDeVeiculo() {

        var usuarios = usuarioRepository.findAll();

        var resultado = usuarios.stream()
            .collect(
                Collectors.groupingBy(
                    Usuario::getVeiculo,
                    Collectors.mapping(Usuario::getCidade, Collectors.toList())
                )
            )
            .entrySet()
            .stream()
            .map(e -> new LocalidadeVeiculo(e.getKey().getMarca(), e.getValue()))
            .collect(Collectors.toList());
    
        return resultado;

    }
    
}
