package br.com.fiap.AutoVulcano.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TB_USUARIO")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_USUARIO")
    private Long id;

    @NotBlank(message = "O nome não pode estar em branco")
    @Column(name = "NM_USUARIO")
    private String nome;

    @NotBlank(message = "O E-mail não pode estar em branco")
    @Column(name = "EMAIL_USUARIO")
    private String email;

    @NotBlank(message = "A senha não pode estar em branco")
    @Column(name = "SENHA_USUARIO")
    private String senha;

    @Size(min = 8, max = 12, message = "O número de contato deve ter entre 8 e 12 digitos")
    @Column(name = "NM_CT_USUARIO")
    private String numContato;

    @Pattern(regexp = "\\d{5}-\\d{3}", message = "O CEP deve estar no formato XXXXX-XXX")
    @Column(name = "CEP_USUARIO")
    private String cep;

    @Column(name = "ESTADO_USUARIO")
    private String estado;

    @Column(name = "CIDADE_USUARIO")
    private String cidade;

    @ManyToOne
    @JoinColumn(name = "ID_VEICULO")
    private Veiculo veiculo;

    // -------- Métodos -------- //

    public Usuario withId(Long id) {
        this.id = id;
        return this;
    }

    public Usuario withNome(String nome) {
        this.nome = nome;
        return this;
    }

    public Usuario withEmail(String email) {
        this.email = email;
        return this;
    }

    public Usuario withSenha(String senha) {
        this.senha = senha;
        return this;
    }

    public Usuario withNumContato(String numContato) {
        this.numContato = numContato;
        return this;
    }

    public Usuario withCep(String cep) {
        this.cep = cep;
        return this;
    }

    public Usuario withEstado(String estado) {
        this.estado = estado;
        return this;
    }

    public Usuario withCidade(String cidade) {
        this.cidade = cidade;
        return this;
    }

    public Usuario withVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
        return this;
    }

}
