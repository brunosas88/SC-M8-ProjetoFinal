package com.aula04.banco.banco.controller;

import com.aula04.banco.banco.BancoAula04Application;
import com.aula04.banco.banco.dto.RequestCliente;
import com.aula04.banco.banco.dto.RequestDeposito;
import com.aula04.banco.banco.dto.ResponseCliente;
import com.aula04.banco.banco.model.BancoCliente;
import com.aula04.banco.banco.model.Cliente;
import com.aula04.banco.banco.model.Conta;
import com.aula04.banco.banco.model.TipoConta;
import com.aula04.banco.banco.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

//@Controller
@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    public ClienteService clienteService;

    @GetMapping // requestmapping aceita tanto get quanto post
//    @ResponseBody
    public List<ResponseCliente> clientes() {
//        List<Conta> contas = new ArrayList<>();
//        Conta conta = new Conta(UUID.randomUUID(), 123, 01, TipoConta.CONTA_CORRENTE );
//        contas.add(conta);
//        Cliente cliente1 = new Cliente(UUID.randomUUID(), "teste1", "teste1@teste.com", "123456", contas);
//        Cliente cliente2 = new Cliente(UUID.randomUUID(), "teste2", "teste2@teste.com", "654321", contas);
//        bancoCliente.adicionar(cliente1);
//        bancoCliente.adicionar(cliente2);
        List<Cliente> clientes = BancoAula04Application.bancoCliente.buscarClientes();
//        model.addAttribute("clientes", clientes);
//        return "clientes";
        return ResponseCliente.toResponse(clientes);
    }

    @GetMapping("/cadastrar/cliente")
    public String formCliente() {
        return "adicionarCliente";
    }

    @PostMapping
//    @ResponseBody
    public ResponseEntity<ResponseCliente> cadastraCliente(
            @RequestBody RequestCliente requestCliente,
            UriComponentsBuilder uriComponentsBuilder){
//        List<Conta> contas = new ArrayList<>();
//        Conta conta = new Conta(UUID.randomUUID(), random.nextInt(), requestCliente.getAgencia(), TipoConta.CONTA_CORRENTE, 0.0 );
//        contas.add(conta);
//        Cliente newCliente = new Cliente(
//                UUID.randomUUID(),
//                requestCliente.getNome(),
//                requestCliente.getEmail(),
//                requestCliente.getSenha(),
//                contas
//        );
        Cliente cliente = clienteService.cadastrarCliente(requestCliente);
        URI uri = uriComponentsBuilder.path("/cliente/{id}").buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(uri).body(new ResponseCliente(cliente));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseCliente> detalhesClientes(@PathVariable UUID id) throws Exception {
        Cliente cliente = BancoAula04Application.bancoCliente.detalhesCliente(id);
        return ResponseEntity.ok(new ResponseCliente(cliente));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseCliente> atualizaCliente(
            @PathVariable UUID id,
            @RequestBody RequestCliente requestCliente
    ) throws Exception {

        Cliente cliente = BancoAula04Application.bancoCliente.atualizaCliente(id, requestCliente);

        return ResponseEntity.ok(new ResponseCliente(cliente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarCliente(@PathVariable UUID id) throws Exception {
        BancoAula04Application.bancoCliente.deletarCliente(id);
        return ResponseEntity.ok().build();
    }




}
