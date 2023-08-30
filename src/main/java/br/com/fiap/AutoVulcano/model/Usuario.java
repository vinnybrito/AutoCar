package br.com.fiap.AutoVulcano.model;

public class Usuario {
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private String numContato;
    private String cep;
    private String estado;
    private String cidade;
    private Veiculo veiculo;

    public Usuario() {}

    public Usuario(Long id, String nome, String email, String senha, String numContato, String cep, String estado, String cidade, Veiculo veiculo) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.numContato = numContato;
        this.cep = cep;
        this.estado = estado;
        this.cidade = cidade;
        this.veiculo = veiculo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNumContato() {
        return numContato;
    }

    public void setNumContato(String numContato) {
        this.numContato = numContato;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((senha == null) ? 0 : senha.hashCode());
        result = prime * result + ((numContato == null) ? 0 : numContato.hashCode());
        result = prime * result + ((cep == null) ? 0 : cep.hashCode());
        result = prime * result + ((estado == null) ? 0 : estado.hashCode());
        result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
        result = prime * result + ((veiculo == null) ? 0 : veiculo.hashCode());
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
        Usuario other = (Usuario) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (senha == null) {
            if (other.senha != null)
                return false;
        } else if (!senha.equals(other.senha))
            return false;
        if (numContato == null) {
            if (other.numContato != null)
                return false;
        } else if (!numContato.equals(other.numContato))
            return false;
        if (cep == null) {
            if (other.cep != null)
                return false;
        } else if (!cep.equals(other.cep))
            return false;
        if (estado == null) {
            if (other.estado != null)
                return false;
        } else if (!estado.equals(other.estado))
            return false;
        if (cidade == null) {
            if (other.cidade != null)
                return false;
        } else if (!cidade.equals(other.cidade))
            return false;
        if (veiculo == null) {
            if (other.veiculo != null)
                return false;
        } else if (!veiculo.equals(other.veiculo))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Usuario [id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha + ", numContato="
                + numContato + ", cep=" + cep + ", estado=" + estado + ", cidade=" + cidade + ", veiculo=" + veiculo
                + "]";
    }

}