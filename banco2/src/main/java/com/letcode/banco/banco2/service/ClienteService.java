package com.letcode.banco.banco2.service;

import com.letcode.banco.banco2.dto.RequestCliente;
import com.letcode.banco.banco2.model.Cliente;
import com.letcode.banco.banco2.model.Conta;
import com.letcode.banco.banco2.model.TipoConta;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import static com.letcode.banco.banco2.Banco2Application.bancoCliente;

@Service
public class ClienteService {

    Random random = new Random();

    public Cliente cadastraCliente(RequestCliente requestCliente){
        List<Conta> contas = new ArrayList<>();
        Conta conta = new Conta(UUID.randomUUID(), random.nextInt(), requestCliente.getAgencia(), TipoConta.CONTA_CORRENTE, 0.0);
        contas.add(conta);
        Cliente cliente = new Cliente(
                UUID.randomUUID(),
                requestCliente.getNome(),
                requestCliente.getEmail(),
                requestCliente.getSenha(),
                contas
        );

        bancoCliente.adicionar(cliente);
        return cliente;
    }

    public List<Cliente> buscaTodosClientes() {
        return bancoCliente.buscarClientes();
    }

}
