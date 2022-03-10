package br.com.letscode.javaweb.projetofinal.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Inventario {
    private Item arma, municao, agua, comida;

    public Inventario (Integer qtdArma, Integer qtdMunicao, Integer qtdAgua, Integer qtdComida){
        this.arma.setQuantidade(qtdArma);
        this.municao.setQuantidade(qtdMunicao);
        this.agua.setQuantidade(qtdAgua);
        this.comida.setQuantidade(qtdComida);

        this.arma.setPontos(4);
        this.municao.setPontos(3);
        this.agua.setPontos(2);
        this.comida.setPontos(1);

        this.arma.setTipoItem(TipoItem.ARMA);
        this.agua.setTipoItem(TipoItem.AGUA);
        this.municao.setTipoItem(TipoItem.MUNICAO);
        this.comida.setTipoItem(TipoItem.COMIDA);
    }
}

