package com.example.exercicio1.servletexercicio1.model;

import java.util.ArrayList;
import java.util.List;

public class ListaClientes {

    private static List<ClienteModel> clientes = new ArrayList<>();

    public void adicionar(ClienteModel clienteModel){
        ListaClientes.clientes.add(clienteModel);
    }

    public List<ClienteModel> buscarClientes() {
        return ListaClientes.clientes;
    }

}
