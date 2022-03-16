package com.letcode.banco.banco2.service;

import com.letcode.banco.banco2.dto.RequestCliente;
import com.letcode.banco.banco2.model.Cliente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.*;

import static org.junit.jupiter.api.Assertions.fail;

public class ClienteServiceTest {

    ClienteService clienteService = new ClienteService();

    @Test
    public void deveRetornarListaClienteVazia() {
        List<Cliente> clientes = clienteService.buscaTodosClientes();
        // Validação
        Assertions.assertTrue(clientes.isEmpty());
    }

    @Test
    public void cadastraCliente() {
        RequestCliente requestCliente = new RequestCliente(
                "Adriano",
                "adriano@email.com",
                "12345678912",
                "123456",
                0
        );
        Cliente cliente = clienteService.cadastraCliente(requestCliente);
        Assertions.assertEquals(requestCliente.getNome(), cliente.getNome());
        Assertions.assertNotNull(cliente.getId());
    }

    @Test
    public void atualizaCliente() throws Exception {
        RequestCliente requestCliente = new RequestCliente(
                "Adriano",
                "adriano@email.com",
                "12345678912",
                "123456",
                0
        );
        Cliente cliente = clienteService.cadastraCliente(requestCliente);
        RequestCliente requesteClienteAtualiza = new RequestCliente(
                "Adriano Takata",
                "adriano@.com",
                "12345678912",
                "123456",
                0
        );
        Cliente clienteAtualizado = clienteService.atualizaCliente(cliente.getId(), requesteClienteAtualiza);

        Assertions.assertEquals("Adriano Takata", clienteAtualizado.getNome());
    }


    // Exceptions
    @Test
    public void buscaClienteQueNaoExiste() {
        UUID id = UUID.randomUUID();
        Assertions.assertThrows(Exception.class, () -> clienteService.detalhesCliente(id));
    }

    @Test
    public void buscaClienteQueNaoExiste2() {
        RequestCliente requestCliente = new RequestCliente(
                "Adriano",
                "adriano@email.com",
                "12345678912",
                "123456",
                0
        );
        Cliente cliente = clienteService.cadastraCliente(requestCliente);
        try {
            clienteService.detalhesCliente(cliente.getId());
            fail("Não lançou a exceção");
        } catch (Exception e){ }
    }

}
