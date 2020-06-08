package br.com.martins.valdelar.clienteapp.respository;

import br.com.martins.valdelar.clienteapp.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository <Cliente, Long> {
}
