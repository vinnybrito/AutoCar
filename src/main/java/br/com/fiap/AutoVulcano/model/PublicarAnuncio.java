package br.com.fiap.AutoVulcano.model;

public class PublicarAnuncio { //POJO, BO, ENTITY
    
    
    private String nome;
    private String icone;

    public PublicarAnuncio() {}

    public PublicarAnuncio(String nome, String icone) {
        this.nome = nome;
        this.icone = icone;
    }

    // ---- GETTERS AND SETTERS ---- //

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIcone() {
        return icone;
    }

    public void setIcone(String icone) {
        this.icone = icone;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((icone == null) ? 0 : icone.hashCode());
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
        PublicarAnuncio other = (PublicarAnuncio) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (icone == null) {
            if (other.icone != null)
                return false;
        } else if (!icone.equals(other.icone))
            return false;
        return true;
    }

    // ---- toString ---- //

    @Override
    public String toString() {
        return "Categoria [nome=" + nome + ", icone=" + icone + "]";
    }


}
