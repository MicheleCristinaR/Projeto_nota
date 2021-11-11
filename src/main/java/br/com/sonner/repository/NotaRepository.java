package br.com.sonner.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sonner.modelo.Nota;

public interface NotaRepository extends JpaRepository<Nota, Long> {

	
}
