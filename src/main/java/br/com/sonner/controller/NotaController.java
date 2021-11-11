package br.com.sonner.controller;


import java.math.BigDecimal;
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


import br.com.sonner.modelo.ItemNota;
import br.com.sonner.modelo.Nota;
import br.com.sonner.repository.ItemNotaRepository;
import br.com.sonner.repository.NotaRepository;

@RestController	
@RequestMapping("/emissao")
public class NotaController{
	
	@Autowired
	private NotaRepository notaRepository;
	
	@Autowired
    private ItemNotaRepository itemnotarepository;

	
	
	@GetMapping	
	public List<Nota>  notas() {
		List<Nota> notas=  notaRepository.findAll();
		return notas;
		
	}
	
	@GetMapping("/{id}")	
	public Nota  getNota(@PathVariable Long id) {
		Optional<Nota> optional =  notaRepository.findById(id);
		return optional.get();
		
	}
	
	
	
	@PostMapping 
	public Nota nova(@RequestBody Nota nota) {
		
		 			
		nota.setTotalNota(BigDecimal.ZERO);
		for(ItemNota item: nota.getItens()) {
			item.setNota(nota);
			
			item.setValorTotal(item.getQuantidade().multiply(item.getProduto().getValor_unitario()));
			
			nota.setTotalNota(nota.getTotalNota().add(item.getValorTotal()));
		}
		
		 
		notaRepository.save(nota);
		
		return nota;
		}
	 
	
	

	@PutMapping 
	public Nota altera(@RequestBody Nota nota) {
		
		nota.setTotalNota(BigDecimal.ZERO);
		for(ItemNota item: nota.getItens()) {
			item.setNota(nota);
			
			item.setValorTotal(item.getQuantidade().multiply(item.getProduto().getValor_unitario()));
			
			nota.setTotalNota(nota.getTotalNota().add(item.getValorTotal()));
		}
				
		notaRepository.save(nota);
		
		return nota;
	 }
	
	@DeleteMapping("/{id}") 
	public void deleta(@PathVariable Long id) {
		
		notaRepository.deleteById(id);
		
	 }
	
	
	public ItemNotaRepository getItemnotarepository() {
		return itemnotarepository;
	}

	public void setItemnotarepository(ItemNotaRepository itemnotarepository) {
		this.itemnotarepository = itemnotarepository;
	}

	
	
}