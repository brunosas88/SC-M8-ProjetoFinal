package br.com.letscode.javaweb.projetofinal.controller;

import br.com.letscode.javaweb.projetofinal.dto.ResponseRebelde;
import br.com.letscode.javaweb.projetofinal.model.Localizacao;
import br.com.letscode.javaweb.projetofinal.service.AcoesRebeldeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/acoes")
public class AcoesController {

    @Autowired
    AcoesRebeldeService acoesRebelde;

    @PatchMapping("/atualizaLocalizacao")
    public ResponseEntity<ResponseRebelde> atualizaLocalizacaoRebelde(@RequestHeader("rebeldeId") UUID id, @RequestBody Localizacao localizacao) throws Exception {
        return ResponseEntity.ok(new ResponseRebelde(acoesRebelde.atualizaLocalizacao(id, localizacao)));
    }

    @PostMapping("/reporta")
    public ResponseEntity reporta (@RequestHeader("rebeldeId") UUID id){
        acoesRebelde.reportaTraidor(id);
        return ResponseEntity.ok().build();
    }

}
