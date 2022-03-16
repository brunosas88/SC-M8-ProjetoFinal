package com.letcode.banco.banco2.model;

import com.letcode.banco.banco2.dto.RequestCliente;
import com.letcode.banco.banco2.dto.RequestDeposito;
import com.letcode.banco.banco2.dto.RequestSacar;

import java.util.*;

public class BancoCliente {

    private static List<Cliente> clientes = new ArrayList<>();

    public void adicionar(Cliente cliente){
        BancoCliente.clientes.add(cliente);
    }

    public List<Cliente> buscarClientes() {
        return BancoCliente.clientes;
    }

    public Cliente detalhesCliente(UUID id) throws Exception {
        // Optional é por causa que a função pode ou não encontrar um cliente
        Optional<Cliente> resultCliente =
                BancoCliente.clientes.stream().filter( cliente -> Objects.equals(cliente.getId(), id)).findAny();

        if(resultCliente.isPresent()){
            return resultCliente.get();
        } else {
            throw  new Exception("Usuario não encontrado");
        }
    }

    public Cliente atulizaCliente(UUID id, RequestCliente requestCliente) throws Exception {
        BancoCliente.clientes.stream().filter(cliente -> Objects.equals(cliente.getId(), id))
                .forEach(cliente -> {
                    cliente.setNome(requestCliente.getNome());
                    cliente.setEmail(requestCliente.getEmail());
                    cliente.setSenha(requestCliente.getEmail());
                });
        return detalhesCliente(id);
    }

    public void deletaCliente(UUID id) throws Exception {
        Cliente cliente = detalhesCliente(id);
        BancoCliente.clientes.remove(cliente);
    }

    public void deposita(UUID id, RequestDeposito requestDeposito) {
        BancoCliente.clientes.stream().filter(cliente -> Objects.equals(cliente.getId(), id))
                .forEach(cliente -> {
                    Optional<Conta> resultConta = cliente.getContas().stream().filter( conta -> Objects.equals(conta.getId(), requestDeposito.getConta())).findAny();
                    if(resultConta.isPresent()) {
                        Double novoSaldo = resultConta.get().getSaldo() + requestDeposito.getValor();
                        resultConta.get().setSaldo(novoSaldo);
                    } else {
                        try {
                            throw new Exception("Conta não encontrada");
                        } catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                });
    }

    public void sacar(UUID id, RequestSacar requestSacar) {
        BancoCliente.clientes.stream().filter(cliente -> Objects.equals(cliente.getId(), id))
                .forEach(cliente -> {
                    Optional<Conta> resultConta = cliente.getContas().stream().filter( conta -> Objects.equals(conta.getId(), requestSacar.getConta())).findAny();
                    if(resultConta.isPresent() && requestSacar.getValor() < resultConta.get().getSaldo()) {
                        Double novoSaldo = resultConta.get().getSaldo() - requestSacar.getValor();
                        resultConta.get().setSaldo(novoSaldo);
                    } else {
                        try {
                            throw new Exception("Conta não encontrada");
                        } catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                });
    }


}
