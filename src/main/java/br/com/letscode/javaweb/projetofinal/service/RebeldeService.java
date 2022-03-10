package br.com.letscode.javaweb.projetofinal.service;

import br.com.letscode.javaweb.projetofinal.ProjetoFinalApplication;
import br.com.letscode.javaweb.projetofinal.dto.RequestRebelde;
import br.com.letscode.javaweb.projetofinal.model.BDRebeldes;
import br.com.letscode.javaweb.projetofinal.model.Localizacao;
import br.com.letscode.javaweb.projetofinal.model.Rebelde;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.UUID;

@Service
public class RebeldeService {

    BDRebeldes bdRebeldes = ProjetoFinalApplication.bdRebeldes;

    public Rebelde cadastraRebelde(RequestRebelde requestRebelde){
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
