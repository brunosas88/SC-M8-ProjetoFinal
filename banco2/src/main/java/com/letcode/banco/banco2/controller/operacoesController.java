package com.letcode.banco.banco2.controller;

import com.letcode.banco.banco2.dto.RequestDeposito;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static com.letcode.banco.banco2.Banco2Application.bancoCliente;

@RestController
@RequestMapping("/operacoes")
public class operacoesController {

    @PatchMapping("/deposita")
    public ResponseEntity deposita(
            @RequestHeader("id") UUID id,
            @RequestBody RequestDeposito requestDeposito
    ) {
        bancoCliente.deposita(id, requestDeposito);
        return ResponseEntity.ok().build();
    }

}
