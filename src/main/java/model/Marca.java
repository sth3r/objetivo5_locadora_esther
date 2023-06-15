package model;

public class Marca {
    private String descricao;

    public Marca(String descricao) {
        this.descricao = descricao;
    }

    public Marca() {
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Marca{" +
                "descricao='" + descricao + '\'' +
                '}';
    }
}
