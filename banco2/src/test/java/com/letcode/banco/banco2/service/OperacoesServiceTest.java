package com.letcode.banco.banco2.service;

import com.letcode.banco.banco2.dto.RequestCliente;
import com.letcode.banco.banco2.dto.RequestDeposito;
import com.letcode.banco.banco2.dto.RequestSacar;
import com.letcode.banco.banco2.model.Cliente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OperacoesServiceTest {

    ClienteService clienteService = new ClienteService();
    OperacoesService operacoesService = new OperacoesService();

    @Test
    public void depoista() {
        RequestCliente requestCliente = new RequestCliente(
                "Adriano",
                "adriano@email.com",
                "12345678912",
                "123456",
                0
        );

        Cliente cliente = clienteService.cadastraCliente(requestCliente);
        RequestDeposito requestDeposito = new RequestDeposito(
                100.0,
                cliente.getContas().get(0).getId()
        );
        operacoesService.deposita(cliente.getId(), requestDeposito);

        Assertions.assertEquals(100.0, cliente.getContas().get(0).getSaldo());

    }

    @Test
    public void sacar() {
        RequestCliente requestCliente = new RequestCliente(
                "Adriano",
                "adriano@email.com",
                "12345678912",
                "123456",
                0
        );

        Cliente cliente = clienteService.cadastraCliente(requestCliente);
        RequestDeposito requestDeposito = new RequestDeposito(
                100.0,
                cliente.getContas().get(0).getId()
        );
        operacoesService.deposita(cliente.getId(), requestDeposito);
        RequestSacar requestSacar = new RequestSacar(
                50.0,
                cliente.getContas().get(0).getId()
        );
        operacoesService.sacar(cliente.getId(), requestSacar);

        Assertions.assertEquals(50.0, cliente.getContas().get(0).getSaldo());

    }

}
