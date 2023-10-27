package br.com.fiap.AutoVulcano.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.fiap.AutoVulcano.model.Usuario;
import br.com.fiap.AutoVulcano.model.Veiculo;
import br.com.fiap.AutoVulcano.repository.UsuarioRepository;
import br.com.fiap.AutoVulcano.repository.VeiculoRepository;

@Configuration
public class DatabaseSeeder implements CommandLineRunner {

    @Autowired
    VeiculoRepository veiculoRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    private Veiculo veiculoA = new Veiculo(null, "Mustang", "EcoBoost", "2024", "2023", "Premium Fastback", "Cardeal");

    private Veiculo veiculoB = new Veiculo(null, "Peugeot", "308cc", "2019", "2016", "Turbo gasolina 2P", "Prateado");

    private Veiculo veiculoC = new Veiculo(null, "lamborghini", "Huracan", "2022", "2021", "Evo", "Cinza");

    @Override
    public void run(String... args) throws Exception {

        veiculoRepository.saveAll(
                List.of(veiculoA, veiculoB, veiculoC));

        usuarioRepository.saveAll(
                List.of(
                        new Usuario()
                                .withNome("Vinicius")
                                .withEmail("viny@hotmail.com")
                                .withSenha("Viny@123")
                                .withNumContato("11981695726")
                                .withCep("08380-048")
                                .withEstado("SP")
                                .withCidade("São Paulo")
                                .withVeiculo(veiculoA),
                        new Usuario()
                                .withNome("William")
                                .withEmail("will@hotmail.com")
                                .withSenha("Will@321")
                                .withNumContato("11981694736")
                                .withCep("08380-048")
                                .withEstado("SP")
                                .withCidade("São Paulo")
                                .withVeiculo(veiculoB),
                        new Usuario()
                                .withNome("Matheus")
                                .withEmail("Theus@hotmail.com")
                                .withSenha("Theus@987")
                                .withNumContato("11981695577")
                                .withCep("08380-048")
                                .withEstado("SP")
                                .withCidade("São Paulo")
                                .withVeiculo(veiculoC)));

    }

}
