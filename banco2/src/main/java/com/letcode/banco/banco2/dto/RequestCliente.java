package com.letcode.banco.banco2.dto;


import com.letcode.banco.banco2.utils.CPF;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
public class RequestCliente {

    @NotNull(message = "não pode ser null vacilão") @NotEmpty(message = "batata") @Length(min = 2)
    private String nome;
    private String email;
    @CPF
    private String cpf;
    private String senha;
    private Integer agencia;

}
