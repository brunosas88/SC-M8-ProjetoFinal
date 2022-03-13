package com.letcode.banco.banco2.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class RequestDeposito {

    private Double valor;
    private UUID conta;
}
