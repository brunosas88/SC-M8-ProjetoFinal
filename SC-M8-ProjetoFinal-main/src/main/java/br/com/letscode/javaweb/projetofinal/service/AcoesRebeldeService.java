package br.com.letscode.javaweb.projetofinal.service;

import br.com.letscode.javaweb.projetofinal.ProjetoFinalApplication;
import br.com.letscode.javaweb.projetofinal.model.BDRebeldes;
import br.com.letscode.javaweb.projetofinal.model.Localizacao;
import br.com.letscode.javaweb.projetofinal.model.Rebelde;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class AcoesRebeldeService {

    BDRebeldes bdRebeldes = ProjetoFinalApplication.bdRebeldes;

    public Rebelde atualizaLocalizacao (UUID id, Localizacao localizacao) throws Exception {
        return bdRebeldes.atualizaLocalizacao(id, localizacao);
    }

    public void reportaTraidor (UUID id) {
        bdRebeldes.reportaTraidor(id);
    }

}
