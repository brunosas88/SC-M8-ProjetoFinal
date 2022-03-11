package br.com.letscode.javaweb.projetofinal.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
public class Oferta {
    private UUID idRebelde;
    private List<Item> itens;
}
