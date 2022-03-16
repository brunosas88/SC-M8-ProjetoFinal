package com.letcode.banco.banco2.service;

import com.letcode.banco.banco2.dto.RequestDeposito;
import com.letcode.banco.banco2.dto.RequestSacar;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static com.letcode.banco.banco2.Banco2Application.bancoCliente;

@Service
public class OperacoesService {

    public void deposita(UUID id, RequestDeposito requestDeposito) {
        bancoCliente.deposita(id, requestDeposito);
    }

    public void sacar(UUID id, RequestSacar requestSacar) {
        bancoCliente.sacar(id, requestSacar);
    }
}
