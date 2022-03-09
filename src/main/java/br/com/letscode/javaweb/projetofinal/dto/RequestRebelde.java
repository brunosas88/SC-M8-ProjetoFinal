package br.com.letscode.javaweb.projetofinal.dto;

import br.com.letscode.javaweb.projetofinal.model.Inventario;
import br.com.letscode.javaweb.projetofinal.model.Localizacao;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class RequestRebelde {
    private String nome;
    private Integer idade;
    private Character genero;
    private Localizacao localizacao;
    private Inventario inventario;
}
