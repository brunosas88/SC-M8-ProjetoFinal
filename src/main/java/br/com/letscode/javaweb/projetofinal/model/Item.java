package br.com.letscode.javaweb.projetofinal.model;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class Item {
    private TipoItem tipoItem;
    private Integer quantidade;
    private Integer pontos;

    public Item(TipoItem tipoItem, Integer quantidade) {
        this.tipoItem = tipoItem;
        this.quantidade = quantidade;
        this.pontos = especificaPontos(tipoItem);
    }

    public Integer especificaPontos (TipoItem tipoItem) {
        int pontos = 0;
        switch (tipoItem) {
            case ARMA:
                pontos = 4;
                break;
            case MUNICAO:
                pontos = 3;
                break;
            case AGUA:
                pontos = 2;
                break;
            case COMIDA:
                pontos = 1;
                break;
        }
        return pontos;
    }
}

