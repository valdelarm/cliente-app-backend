package br.com.martins.valdelar.clienteapp.dto;

import br.com.martins.valdelar.clienteapp.enums.TipoTelefone;
import br.com.martins.valdelar.clienteapp.model.Cliente;
import br.com.martins.valdelar.clienteapp.model.EmailCliente;
import br.com.martins.valdelar.clienteapp.model.Endereco;
import br.com.martins.valdelar.clienteapp.model.Telefone;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.Collections;

@Data
public class ClienteDto {
    @NotBlank
    private String nome;
    @CPF
    @NotBlank
    private String cpf;
    @NotBlank
    private String cep;
    @NotBlank
    private String logradouro;
    @NotBlank
    private String bairro;
    @NotBlank
    private String cidade;
    @NotBlank
    private String uf;
    private String complemento;
    @NotBlank
    private String telefone;
    @Email
    @NotBlank
    private String email;


    public Cliente toModel() {
        EmailCliente emailCliente = new EmailCliente();
        emailCliente.setEmail(this.email);

        Telefone telefone = new Telefone();
        telefone.setNumero(this.telefone);
        telefone.setTipo(TipoTelefone.COMERCIAL);

        return Cliente.builder()
                .nome(this.nome)
                .cpf(this.cpf)
                .endereco(Endereco.builder()
                        .cep(this.cep).bairro(this.bairro).cidade(this.cidade)
                        .complemento(this.complemento).uf(this.uf).logradouro(this.logradouro)
                        .build())
                .emailClientes(Collections.singleton(emailCliente))
                .telefones(Collections.singletonList(telefone))
                .build();
    }

}
