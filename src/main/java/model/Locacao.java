package model;

import java.time.LocalDateTime;

public class Locacao {
    private LocalDateTime dt_locacao, hora_locacao, dt_devolucao, hora_devolucao;
    private long quilometragem;
    private double valor_custacao, valor_locacao;
    private int devolvido;

    Automovel automovel;
}
