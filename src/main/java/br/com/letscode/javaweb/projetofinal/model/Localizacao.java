package br.com.letscode.javaweb.projetofinal.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class Localizacao {
    private Double latitude;
    private Double longitude;
    private String nomeGalaxia;

    public Localizacao (Localizacao localizacao) {
        latitude = localizacao.getLatitude();
        longitude = localizacao.getLongitude();
        nomeGalaxia = localizacao.getNomeGalaxia();
    }
}
