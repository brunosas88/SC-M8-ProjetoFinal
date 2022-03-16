package com.letcode.banco.banco2.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ErroValidacao {

    private String campo;
    private String mensagem;

}
