package br.com.sonner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.sonner.modelo.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
