package com.example.santander.model;

import java.util.ArrayList;
import java.util.List;

public class ListaCliente {

    private static List<ClienteModel> clientes = new ArrayList<>();

    public void adicionar(ClienteModel clienteModel){
        ListaCliente.clientes.add(clienteModel);
    }

//    public List<ClienteModel> buscarCliente(){
//
//    }
}
