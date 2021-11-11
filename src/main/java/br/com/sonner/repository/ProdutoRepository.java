package br.com.sonner.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sonner.modelo.Produto;



public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}