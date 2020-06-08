package br.com.martins.valdelar.clienteapp.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="endereco")
@Data
@Builder
public class Endereco {

    @Id
    private Long id;
    private String cep;
    private String logradouro;
    private String bairro;
    private String cidade;
    private String uf;
    private String complemento;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Cliente cliente;
}
