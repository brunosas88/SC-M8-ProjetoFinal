package com.letcode.banco.banco2.controller;

import com.letcode.banco.banco2.dto.RequestCliente;
import com.letcode.banco.banco2.dto.RequestDeposito;
import com.letcode.banco.banco2.dto.ResponseCliente;
import com.letcode.banco.banco2.model.BancoCliente;
import com.letcode.banco.banco2.model.Cliente;
import com.letcode.banco.banco2.model.Conta;
import com.letcode.banco.banco2.model.TipoConta;
import com.letcode.banco.banco2.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import static com.letcode.banco.banco2.Banco2Application.bancoCliente;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping // RequestMapping pode receber requisições do tipo get e post
    @ResponseBody  // O returno será retornado direto ao usuário
    public List<ResponseCliente> Clientes() {
        return ResponseCliente.toResponse(clienteService.buscaTodosClientes());
    }

    @GetMapping("/cadastra/cliente")
    public String formClientes() {
        return "formCliente";
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<ResponseCliente> cadastraCliente(
            @RequestBody RequestCliente requestCliente,
            UriComponentsBuilder uriComponentsBuilder
    ) {
        Cliente cliente = clienteService.cadastraCliente(requestCliente);
        URI uri = uriComponentsBuilder.path("/cliente/{id}").buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(uri).body(new ResponseCliente(cliente));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseCliente> detalhesCliente(
            @PathVariable UUID id
    ) throws Exception{
        Cliente cliente = bancoCliente.detalhesCliente(id);
        return ResponseEntity.ok(new ResponseCliente(cliente));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseCliente> atualizaCliente(
            @PathVariable UUID id,
            @RequestBody RequestCliente requestCliente
    ) throws Exception{
        Cliente cliente = bancoCliente.atulizaCliente(id, requestCliente);
        return ResponseEntity.ok(new ResponseCliente(cliente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletaCliente(@PathVariable UUID id) throws Exception{
        bancoCliente.deletaCliente(id);
        return ResponseEntity.ok().build();
    }

}
