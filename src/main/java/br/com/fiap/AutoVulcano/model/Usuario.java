package br.com.fiap.AutoVulcano.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_USUARIO")
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_USUARIO")
    private Long id;

    @NotBlank
    @Column(name = "NM_USUARIO")
    private String nome;

    @NotBlank
    @Column(name = "EMAIL_USUARIO")
    private String email;

    @NotBlank
    @Column(name = "SENHA_USUARIO")
    private String senha;

    @Min(value = 0)
    @Max(value = 9)
    @Column(name = "NM_CT_USUARIO")
    private String numContato;

    @Min(value = 0, message = "CEP precisa ter 8 digitos")
    @Max(value = 8, message = "CEP precisa ter no máximo 8 digitos")
    @Column(name = "CEP_USUARIO")
    private String cep;

    @Column(name = "ESTADO_USUARIO")
    private String estado;

    @Column(name = "CIDADE_USUARIO")
    private String cidade;

    @ManyToOne
    @JoinColumn(name = "USUARIO_VEICULO")
    private Veiculo veiculo;

}