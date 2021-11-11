package br.com.sonner.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sonner.modelo.ItemNota;


public interface ItemNotaRepository extends JpaRepository<ItemNota, Long> {

	public static final ItemNota findByAll = new ItemNota();

}