package model;

public class Automovel {
    private String placa, cor, chassi;
    private int nr_portas, tipo_combustivel;
    private long quilometragem, renavam;
    private double valor_locacao;

    Modelo modelo;

    public Automovel(String placa, String cor, String chassi, int nr_portas, int tipo_combustivel, long quilometragem, long renavam, double valor_locacao, Modelo modelo) {
        this.placa = placa;
        this.cor = cor;
        this.chassi = chassi;
        this.nr_portas = nr_portas;
        this.tipo_combustivel = tipo_combustivel;
        this.quilometragem = quilometragem;
        this.renavam = renavam;
        this.valor_locacao = valor_locacao;
        this.modelo = modelo;
    }

    public Automovel() {
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public int getNr_portas() {
        return nr_portas;
    }

    public void setNr_portas(int nr_portas) {
        this.nr_portas = nr_portas;
    }

    public int getTipo_combustivel() {
        return tipo_combustivel;
    }

    public void setTipo_combustivel(int tipo_combustivel) {
        this.tipo_combustivel = tipo_combustivel;
    }

    public long getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(long quilometragem) {
        this.quilometragem = quilometragem;
    }

    public long getRenavam() {
        return renavam;
    }

    public void setRenavam(long renavam) {
        this.renavam = renavam;
    }

    public double getValor_locacao() {
        return valor_locacao;
    }

    public void setValor_locacao(double valor_locacao) {
        this.valor_locacao = valor_locacao;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "Automovel{" +
                "placa='" + placa + '\'' +
                ", cor='" + cor + '\'' +
                ", chassi='" + chassi + '\'' +
                ", nr_portas=" + nr_portas +
                ", tipo_combustivel=" + tipo_combustivel +
                ", quilometragem=" + quilometragem +
                ", renavam=" + renavam +
                ", valor_locacao=" + valor_locacao +
                ", modelo=" + modelo +
                '}';
    }
}
