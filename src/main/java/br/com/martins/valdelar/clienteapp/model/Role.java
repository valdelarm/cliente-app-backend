package br.com.martins.valdelar.clienteapp.model;

import br.com.martins.valdelar.clienteapp.enums.RoleNames;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "roles")
@Getter
@Setter
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 60)
    private RoleNames name;
}
