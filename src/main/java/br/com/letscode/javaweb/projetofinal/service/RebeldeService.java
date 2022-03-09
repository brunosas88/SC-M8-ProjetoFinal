package br.com.letscode.javaweb.projetofinal.service;

import br.com.letscode.javaweb.projetofinal.dto.RequestRebelde;
import br.com.letscode.javaweb.projetofinal.model.Localizacao;
import br.com.letscode.javaweb.projetofinal.model.Rebelde;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.UUID;

import static br.com.letscode.javaweb.projetofinal.ProjetoFinalApplication.bdRebeldes;

@Service
public class RebeldeService {

    public Rebelde cadastraRebelde(RequestRebelde requestRebelde){
//        Localizacao localizacao = new Localizacao(requestRebelde.getLocalizacao().getLatitude(), requestRebelde.getLocalizacao().getLongitude(), requestRebelde.getLocalizacao().getNomeGalaxia());
//        Inventario inventario = new Inventario(requestRebelde.getInventario().getNumeroArma(), requestRebelde.getInventario().getNumeroMunicao(), requestRebelde.getInventario().getNumeroAgua(), requestRebelde.getInventario().getNumeroComida() );
        Rebelde rebelde = new Rebelde(requestRebelde);
        bdRebeldes.adiciona(rebelde);
        return rebelde;
    }

    public List<Rebelde> buscaTodosRebeldes() {
        return bdRebeldes.buscaRebeldes();
    }

    public Rebelde atualizaLocalizacao (UUID id, Localizacao localizacao) throws Exception {
        return bdRebeldes.atualizaLocalizacao(id, localizacao);
    }

    public void reportaTraidor (UUID id) {
        bdRebeldes.reportaTraidor(id);
    }
}
