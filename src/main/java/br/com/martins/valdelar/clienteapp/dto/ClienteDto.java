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
import java.util.Collections;

@Data
public class ClienteDto {

    private Long id;
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
                .emailClientes(Collections.singletonList(emailCliente))
                .telefones(Collections.singletonList(telefone))
                .build();
    }

    public static ClienteDto toDto(Cliente entity) {
        ClienteDto dto = new ClienteDto();
        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        dto.setCpf(entity.getCpf());
        dto.setCep(entity.getEndereco().getCep());
        dto.setBairro(entity.getEndereco().getBairro());
        dto.setCidade(entity.getEndereco().getCidade());
        dto.setComplemento(entity.getEndereco().getComplemento());
        dto.setLogradouro(entity.getEndereco().getLogradouro());
        dto.setUf(entity.getEndereco().getUf());

        if (entity.getTelefones() != null && !entity.getTelefones().isEmpty()) {
            dto.setTelefone(entity.getTelefones().get(0).getNumero());
        }

        if (entity.getEmailClientes() != null && !entity.getEmailClientes().isEmpty()) {
            dto.setEmail(entity.getEmailClientes().get(0).getEmail());
        }

        return dto;
    }

}
