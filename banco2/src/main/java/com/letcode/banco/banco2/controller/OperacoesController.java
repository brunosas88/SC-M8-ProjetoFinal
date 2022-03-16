package com.letcode.banco.banco2.controller;

import com.letcode.banco.banco2.dto.RequestDeposito;
import com.letcode.banco.banco2.dto.RequestSacar;
import com.letcode.banco.banco2.service.OperacoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static com.letcode.banco.banco2.Banco2Application.bancoCliente;

@RestController
@RequestMapping("/operacoes")
public class OperacoesController {

    @Autowired
    OperacoesService operacoesService;

    @PatchMapping("/deposita")
    public ResponseEntity deposita(
            @RequestHeader("id") UUID id,
            @RequestBody RequestDeposito requestDeposito
    ) {
        operacoesService.deposita(id, requestDeposito);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/sacar")
    public ResponseEntity sacar(
            @RequestHeader("id") UUID id,
            @RequestBody RequestSacar requestSacar
            ){
        operacoesService.sacar(id, requestSacar);
        return ResponseEntity.ok().build();
    }

}
