package br.com.martins.valdelar.clienteapp.model;

import br.com.martins.valdelar.clienteapp.enums.TipoTelefone;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "telefone")
@Data
public class Telefone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numero;
    @Enumerated(EnumType.STRING)
    @Column(length = 30, name = "tipo_telefone")
    private TipoTelefone tipo;
}
