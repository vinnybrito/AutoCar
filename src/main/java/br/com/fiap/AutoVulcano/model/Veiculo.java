package br.com.fiap.AutoVulcano.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_VEICULO")
public class Veiculo { 
     
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_VEICULO")
    private Long id;

    @NotBlank(message = "A marca não pode estar em branco")
    @Column(name = "MARCA_VEICULO")
    private String marca;

    @NotBlank(message = "O modelo não pode estar em branco")
    @Column(name = "MODELO_VEICULO")
    private String modelo;

    @Pattern(regexp = "\\d{4}", message = "O ano de modelo deve conter 4 dígitos")
    @Column(name = "ANO_MODELO_VEICULO")
    private String anoModelo;

    @Pattern(regexp = "\\d{4}", message = "O ano de fabricação deve conter 4 dígitos")
    @Column(name = "ANO_FAB_VEICULO")
    private String anoFabricação;

    @NotBlank(message = "A versão não pode estar em branco")
    @Column(name = "VERSAO_VEICULO")
    private String versao;

    @NotBlank(message = "A cor não pode estar em branco")
    @Column(name = "COR_VEICULO")
    private String cor;  

}