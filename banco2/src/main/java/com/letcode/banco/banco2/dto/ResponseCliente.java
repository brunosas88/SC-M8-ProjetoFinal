package com.letcode.banco.banco2.dto;

import com.letcode.banco.banco2.model.Cliente;
import com.letcode.banco.banco2.model.Conta;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
public class ResponseCliente {

    private UUID id;
    private String nome;
    private String email;
    private List<Conta> contas;

    public ResponseCliente(Cliente cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.email = cliente.getEmail();
        this.contas = cliente.getContas();
    }

    public static List<ResponseCliente> toResponse(List<Cliente>  clientes) {
        List<ResponseCliente> listClientes = new ArrayList<>();
//        for (Cliente cliente : clientes){
//            ResponseCliente responseCliente = new ResponseCliente(cliente);
//            listClientes.add(responseCliente);
//        }
//
//        return listClientes;

        return clientes.stream().map(ResponseCliente::new).collect(Collectors.toList());
    }
}
