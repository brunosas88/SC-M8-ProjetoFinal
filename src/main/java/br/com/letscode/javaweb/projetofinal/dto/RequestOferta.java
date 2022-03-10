package br.com.letscode.javaweb.projetofinal.dto;

import br.com.letscode.javaweb.projetofinal.model.Item;
import br.com.letscode.javaweb.projetofinal.model.Oferta;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter @Setter
public class RequestOferta {
    private UUID idRebelde;
    private List<Item> itemList;
}
