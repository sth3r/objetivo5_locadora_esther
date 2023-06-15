package model;

public class Modelo {
    private String descricao;

    Marca marca;

    public Modelo(String descricao, Marca marca) {
        this.descricao = descricao;
        this.marca = marca;
    }

    public Modelo() {
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "Modelo{" +
                "descricao='" + descricao + '\'' +
                ", marca=" + marca +
                '}';
    }
}
