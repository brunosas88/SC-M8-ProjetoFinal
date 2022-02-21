package com.aula04.banco.banco.model;

import java.util.ArrayList;
import java.util.List;

public class BancoCliente {

    private static List<Cliente> clientes = new ArrayList<>();

    public void adicionar(Cliente cliente) {
        BancoCliente.clientes.add(cliente);
    }

    public List<Cliente> buscarClientes(){
        return BancoCliente.clientes;
    }

}
