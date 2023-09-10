package br.com.fiap.AutoVulcano.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Veiculo { 
     
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String marca;
    private String modelo;
    private String anoModelo;
    private String anoFabricação;
    private String versao;
    private String cor;

    public Veiculo() {}

    public Veiculo(Long id, String marca, String modelo, String anoModelo, String anoFabricação, String versao, String cor) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.anoModelo = anoModelo;
        this.anoFabricação = anoFabricação;
        this.versao = versao;
        this.cor = cor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(String anoModelo) {
        this.anoModelo = anoModelo;
    }

    public String getAnoFabricação() {
        return anoFabricação;
    }

    public void setAnoFabricação(String anoFabricação) {
        this.anoFabricação = anoFabricação;
    }

    public String getVersao() {
        return versao;
    }

    public void setVersao(String versao) {
        this.versao = versao;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((marca == null) ? 0 : marca.hashCode());
        result = prime * result + ((modelo == null) ? 0 : modelo.hashCode());
        result = prime * result + ((anoModelo == null) ? 0 : anoModelo.hashCode());
        result = prime * result + ((anoFabricação == null) ? 0 : anoFabricação.hashCode());
        result = prime * result + ((versao == null) ? 0 : versao.hashCode());
        result = prime * result + ((cor == null) ? 0 : cor.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Veiculo other = (Veiculo) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (marca == null) {
            if (other.marca != null)
                return false;
        } else if (!marca.equals(other.marca))
            return false;
        if (modelo == null) {
            if (other.modelo != null)
                return false;
        } else if (!modelo.equals(other.modelo))
            return false;
        if (anoModelo == null) {
            if (other.anoModelo != null)
                return false;
        } else if (!anoModelo.equals(other.anoModelo))
            return false;
        if (anoFabricação == null) {
            if (other.anoFabricação != null)
                return false;
        } else if (!anoFabricação.equals(other.anoFabricação))
            return false;
        if (versao == null) {
            if (other.versao != null)
                return false;
        } else if (!versao.equals(other.versao))
            return false;
        if (cor == null) {
            if (other.cor != null)
                return false;
        } else if (!cor.equals(other.cor))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Veiculo [id=" + id + ", marca=" + marca + ", modelo=" + modelo + ", anoModelo=" + anoModelo
                + ", anoFabricação=" + anoFabricação + ", versao=" + versao + ", cor=" + cor + "]";
    }

    public boolean isEmpty() {
        return false;
    }

}