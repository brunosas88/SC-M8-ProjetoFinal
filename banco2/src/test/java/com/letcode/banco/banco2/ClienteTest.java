package com.letcode.banco.banco2;

import com.letcode.banco.banco2.model.Cliente;
import com.letcode.banco.banco2.service.ClienteService;

import java.util.List;

public class ClienteTest {

    public static void main(String[] args) {
        ClienteService clienteService = new ClienteService();
        List<Cliente> clienteList = clienteService.buscaTodosClientes();
        System.out.println("Clientes" + clienteList);
        if (clienteList.isEmpty()){
            System.out.println("Teste 1 passou");
        }
    }

}
