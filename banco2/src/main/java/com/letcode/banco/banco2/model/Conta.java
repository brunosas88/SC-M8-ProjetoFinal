package com.letcode.banco.banco2.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class Conta {

    private UUID id;
    private Integer numeroConta;
    private Integer agencia;
    private TipoConta tipo;
    private Double saldo;

}
