package br.com.letscode.javaweb.projetofinal.controller;

import br.com.letscode.javaweb.projetofinal.dto.RequestRebelde;
import br.com.letscode.javaweb.projetofinal.dto.ResponseRebelde;
import br.com.letscode.javaweb.projetofinal.model.Localizacao;
import br.com.letscode.javaweb.projetofinal.model.Rebelde;
import br.com.letscode.javaweb.projetofinal.service.RebeldeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/rebelde")
public class RebeldeController {

    @Autowired
    RebeldeService rebeldeService;

    @PostMapping
    public ResponseEntity<ResponseRebelde> cadastro (@RequestBody RequestRebelde requestRebelde, UriComponentsBuilder uriComponentsBuilder) { // o metodo POST recebera o objeto criado e após ser aplicada a lógica necessária, enviará a resposta para outro html
        Rebelde rebelde = rebeldeService.cadastraRebelde(requestRebelde);
        URI uri = uriComponentsBuilder.path("/cliente/{id}").buildAndExpand(rebelde.getId()).toUri();
        return ResponseEntity.created(uri).body(new ResponseRebelde(rebelde));
    }

    @GetMapping// GET UTILIZADO PARA FINS DE TESTAR O BD
    public List<ResponseRebelde> mostrarListaRebeldes() {// o metodo com GET será o responsavel por enviar ao formuario o objeto a ser criado através do parametro model
        return ResponseRebelde.toResponse(rebeldeService.buscaTodosRebeldes());
    }

    @PatchMapping("/atualizaLocalizacao")
    public ResponseEntity<ResponseRebelde> atualizaLocalizacaoRebelde(@RequestHeader("rebeldeId") UUID id, @RequestBody Localizacao localizacao) throws Exception {
        return ResponseEntity.ok(new ResponseRebelde(rebeldeService.atualizaLocalizacao(id, localizacao)));
    }

    @PostMapping("/reporta")
    public ResponseEntity reporta (@RequestHeader("rebeldeId") UUID id){
        rebeldeService.reportaTraidor(id);
        return ResponseEntity.ok().build();
    }
}
