package model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Locacao {
    private LocalDateTime dt_hr_locacao, devolucao;
    private long quilometragem;
    private double valor_custacao, valor_locacao;
    private boolean devolvido;
    private int diasLocados;

    Automovel automovel;

    Cliente cliente;

    public Locacao(LocalDateTime dt_hr_locacao, LocalDateTime devolucao, long quilometragem, double valor_custacao, double valor_locacao, int devolvido, Automovel automovel, int diasLocados) {
        this.dt_hr_locacao = LocalDateTime.now();
        this.valor_locacao = valor_locacao;
        this.diasLocados = diasLocados;
        this.devolucao = LocalDateTime.now() + getDiasLocados;
        this.quilometragem = quilometragem;
        this.valor_custacao = valor_custacao;
        this.devolvido = devolvido;
        this.automovel = automovel;
        this.cliente = cliente;
    }

    public Locacao() {
    }

    public LocalDateTime getDt_hr_locacao() {
        return dt_hr_locacao;
    }

    public void setDt_hr_locacao(LocalDateTime dt_hr_locacao) {
        this.dt_hr_locacao = dt_hr_locacao;
    }

    public LocalDateTime getDevolucao() {
        return devolucao;
    }

    public void setDevolucao(LocalDateTime devolucao) {
        this.devolucao = devolucao;
    }

    public long getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(long quilometragem) {
        this.quilometragem = quilometragem;
    }

    public double getValor_custacao() {
        return valor_custacao;
    }

    public void setValor_custacao(double valor_custacao) {
        this.valor_custacao = valor_custacao;
    }

    public double getValor_locacao() {
        return valor_locacao;
    }

    public void setValor_locacao(double valor_locacao) {
        this.valor_locacao = valor_locacao;
    }

    public boolean isDevolvido() {
        return devolvido;
    }

    public void setDevolvido(boolean devolvido) {
        this.devolvido = devolvido;
    }

    public int getDiasLocados() {
        return diasLocados;
    }

    public void setDiasLocados(int diasLocados) {
        this.diasLocados = diasLocados;
    }

    public Automovel getAutomovel() {
        return automovel;
    }

    public void setAutomovel(Automovel automovel) {
        this.automovel = automovel;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Locacao{" +
                "dt_hr_locacao=" + dt_hr_locacao +
                ", devolucao=" + devolucao +
                ", quilometragem=" + quilometragem +
                ", valor_custacao=" + valor_custacao +
                ", valor_locacao=" + valor_locacao +
                ", devolvido=" + devolvido +
                ", diasLocados=" + diasLocados +
                ", automovel=" + automovel +
                ", cliente=" + cliente +
                '}';
    }
}
