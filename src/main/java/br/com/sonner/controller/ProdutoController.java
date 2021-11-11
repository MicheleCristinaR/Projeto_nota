package br.com.sonner.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sonner.modelo.Produto;
import br.com.sonner.repository.ProdutoRepository;

@RestController	
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@GetMapping	
	public List<Produto>  listaProduto() {
		List<Produto> produto =  produtoRepository.findAll();
		return produto;
		
	}
	
	@GetMapping("/{id}")	
	public Produto  getProduto(@PathVariable Long id) {
		Optional<Produto> optional =  produtoRepository.findById(id);
		return optional.get();
		
	}
	
	@PostMapping 
	public Produto novo(@RequestBody Produto produto) {
		
		produtoRepository.save(produto);
		
		return produto;
	 }
	
	@PutMapping	
	public Produto altera(@RequestBody Produto produto) {
		
				
		return produtoRepository.save(produto);		
		
		
	 }
	
	@DeleteMapping("/{id}") 
	public void deleta(@PathVariable Long id) {
			
		produtoRepository.deleteById(id);
		
	 }

}
