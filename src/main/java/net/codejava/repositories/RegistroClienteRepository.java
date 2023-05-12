package net.codejava.repositories;

import net.codejava.entity.RegistroCliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistroClienteRepository extends JpaRepository<RegistroCliente, Long> {

}
