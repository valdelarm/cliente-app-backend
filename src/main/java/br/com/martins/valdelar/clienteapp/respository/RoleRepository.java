package br.com.martins.valdelar.clienteapp.respository;

import br.com.martins.valdelar.clienteapp.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
