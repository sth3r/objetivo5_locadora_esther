package model;

import java.time.LocalDateTime;

public class Locacao {
    private LocalDateTime dt_locacao, hora_locacao, dt_devolucao, hora_devolucao;
    private long quilometragem;
    private double valor_custacao, valor_locacao;
    private int devolvido;

    Automovel automovel;

    public Locacao(LocalDateTime dt_locacao, LocalDateTime hora_locacao, LocalDateTime dt_devolucao, LocalDateTime hora_devolucao, long quilometragem, double valor_custacao, double valor_locacao, int devolvido, Automovel automovel) {
        this.dt_locacao = dt_locacao;
        this.hora_locacao = hora_locacao;
        this.dt_devolucao = dt_devolucao;
        this.hora_devolucao = hora_devolucao;
        this.quilometragem = quilometragem;
        this.valor_custacao = valor_custacao;
        this.valor_locacao = valor_locacao;
        this.devolvido = devolvido;
        this.automovel = automovel;
    }

    public Locacao() {
    }

    public LocalDateTime getDt_locacao() {
        return dt_locacao;
    }

    public void setDt_locacao(LocalDateTime dt_locacao) {
        this.dt_locacao = dt_locacao;
    }

    public LocalDateTime getHora_locacao() {
        return hora_locacao;
    }

    public void setHora_locacao(LocalDateTime hora_locacao) {
        this.hora_locacao = hora_locacao;
    }

    public LocalDateTime getDt_devolucao() {
        return dt_devolucao;
    }

    public void setDt_devolucao(LocalDateTime dt_devolucao) {
        this.dt_devolucao = dt_devolucao;
    }

    public LocalDateTime getHora_devolucao() {
        return hora_devolucao;
    }

    public void setHora_devolucao(LocalDateTime hora_devolucao) {
        this.hora_devolucao = hora_devolucao;
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

    public int getDevolvido() {
        return devolvido;
    }

    public void setDevolvido(int devolvido) {
        this.devolvido = devolvido;
    }

    public Automovel getAutomovel() {
        return automovel;
    }

    public void setAutomovel(Automovel automovel) {
        this.automovel = automovel;
    }

    @Override
    public String toString() {
        return "Locacao{" +
                "dt_locacao=" + dt_locacao +
                ", hora_locacao=" + hora_locacao +
                ", dt_devolucao=" + dt_devolucao +
                ", hora_devolucao=" + hora_devolucao +
                ", quilometragem=" + quilometragem +
                ", valor_custacao=" + valor_custacao +
                ", valor_locacao=" + valor_locacao +
                ", devolvido=" + devolvido +
                ", automovel=" + automovel +
                '}';
    }
}
