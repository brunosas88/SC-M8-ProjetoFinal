package br.com.letscode.javaweb.projetofinal.model;

import br.com.letscode.javaweb.projetofinal.dto.RequestRebelde;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class Rebelde {
    private UUID id;
    private String nome;
    private Integer idade;
    private Character genero;
    private Boolean traidor;
    private Integer contadorReportes;
    private Localizacao localizacao;
    private List<Item> inventario;

    public Rebelde(RequestRebelde requestRebelde) {
        this.id = UUID.randomUUID();
        this.nome = requestRebelde.getNome();
        this.idade = requestRebelde.getIdade();
        this.genero = requestRebelde.getGenero();
        this.traidor = false;
        this.contadorReportes = 0;
        this.localizacao = requestRebelde.getLocalizacao();
        this.inventario = requestRebelde.getInventario();
    }
}

