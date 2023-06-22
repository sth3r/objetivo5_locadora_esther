package model;

import java.util.List;

public class Cliente {
    private int id_cli;
    private long cpf_cliente;
    private String nom_cliente, end_cliente, tel_cliente, email_cliente;

    private List<Locacao> locacoes;


    public Cliente(int id_cli, long cpf_cliente, String nom_cliente, String end_cliente, String tel_cliente, String email_cliente, List<Locacao> locacoes) {
        this.id_cli = id_cli;
        this.cpf_cliente = cpf_cliente;
        this.nom_cliente = nom_cliente;
        this.end_cliente = end_cliente;
        this.tel_cliente = tel_cliente;
        this.email_cliente = email_cliente;
        this.locacoes = locacoes;
    }

    public Cliente() {
    }

    public int getId_cli() {
        return id_cli;
    }

    public void setId_cli(int id_cli) {
        this.id_cli = id_cli;
    }

    public long getCpf_cliente() {
        return cpf_cliente;
    }

    public void setCpf_cliente(long cpf_cliente) {
        this.cpf_cliente = cpf_cliente;
    }

    public String getNom_cliente() {
        return nom_cliente;
    }

    public void setNom_cliente(String nom_cliente) {
        this.nom_cliente = nom_cliente;
    }

    public String getEnd_cliente() {
        return end_cliente;
    }

    public void setEnd_cliente(String end_cliente) {
        this.end_cliente = end_cliente;
    }

    public String getTel_cliente() {
        return tel_cliente;
    }

    public void setTel_cliente(String tel_cliente) {
        this.tel_cliente = tel_cliente;
    }

    public String getEmail_cliente() {
        return email_cliente;
    }

    public void setEmail_cliente(String email_cliente) {
        this.email_cliente = email_cliente;
    }

    public List<Locacao> getLocacoes() {
        return locacoes;
    }

    public void setLocacoes(List<Locacao> locacoes) {
        this.locacoes = locacoes;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id_cli=" + id_cli +
                ", cpf_cliente=" + cpf_cliente +
                ", nom_cliente='" + nom_cliente + '\'' +
                ", end_cliente='" + end_cliente + '\'' +
                ", tel_cliente='" + tel_cliente + '\'' +
                ", email_cliente='" + email_cliente + '\'' +
                ", locacoes=" + locacoes +
                '}';
    }
}
