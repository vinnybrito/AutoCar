package br.com.fiap.AutoVulcano.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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

    @Column(name = "MARCA_VEICULO")
    private String marca;

    @Column(name = "MODELO_VEICULO")
    private String modelo;

    @Column(name = "ANO_MODELO_VEICULO")
    private String anoModelo;

    @Column(name = "ANO_FAB_VEICULO")
    private String anoFabricação;

    @Column(name = "VERSAO_VEICULO")
    private String versao;

    @Column(name = "COR_VEICULO")
    private String cor;  

}