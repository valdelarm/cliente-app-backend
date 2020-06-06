package br.com.martins.valdelar.clienteapp.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class Login {

    @NotBlank
    private String userName;
    @NotBlank
    private String password;
}
