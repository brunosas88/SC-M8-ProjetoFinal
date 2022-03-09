package br.com.letscode.javaweb.projetofinal.dto;

import br.com.letscode.javaweb.projetofinal.model.Inventario;
import br.com.letscode.javaweb.projetofinal.model.Localizacao;
import br.com.letscode.javaweb.projetofinal.model.Rebelde;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
@Setter
public class ResponseRebelde {
    private UUID id;
    private String nome;
    private Integer idade;
    private Character genero;
    private Localizacao localizacao;
    private Inventario inventario;

    private Boolean traidor;
    private Integer contadorReportes;

    public ResponseRebelde(Rebelde rebelde) {
        id = rebelde.getId();
        nome = rebelde.getNome();
        idade = rebelde.getIdade();
        genero = rebelde.getGenero();
        localizacao = rebelde.getLocalizacao();
        inventario = rebelde.getInventario();

        traidor = rebelde.getTraidor();
        contadorReportes = rebelde.getContadorReportes();
    }

    public static List<ResponseRebelde> toResponse(List<Rebelde> rebeldeList) {
        return rebeldeList.stream().map(ResponseRebelde::new).collect(Collectors.toList());
    }
}
