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

import br.com.sonner.modelo.Cliente;
import br.com.sonner.repository.ClienteRepository;

@RestController	
@RequestMapping("/cliente")
public class ClienteController{
	
	@Autowired
	private ClienteRepository clienteRepository;
	

	@GetMapping	
	public List<Cliente>  listaCliente() {
		List<Cliente> cliente =  clienteRepository.findAll();
		return cliente;
		
	}
	
	@GetMapping("/{id}")	
	public Cliente  getCliente(@PathVariable Long id) {
		Optional<Cliente> optional =  clienteRepository.findById(id);
		return optional.get();
		
	}
	
	@PostMapping 
	public Cliente novo(@RequestBody Cliente cliente) {
		
		clienteRepository.save(cliente);
		
		return cliente;
	 }

	
	@PutMapping 
	public Cliente altera(@RequestBody Cliente cliente) {
		
		clienteRepository.save(cliente);
		
		return cliente;
	 }

	@DeleteMapping("/{id}") 
	public void deleta(@PathVariable Long id) {
		
		clienteRepository.deleteById(id);
		
	 }
	
	
}