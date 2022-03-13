package com.letcode.banco.banco2.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RequestCliente {

    private String nome;
    private String email;
    private String senha;
    private Integer agencia;

}
