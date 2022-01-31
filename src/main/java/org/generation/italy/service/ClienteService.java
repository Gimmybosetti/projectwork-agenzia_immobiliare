package org.generation.italy.service;

import java.util.List;

import org.generation.italy.model.Cliente;
import org.generation.italy.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;
	
	public List<Cliente> trovaCliente(){
		return repository.findAll();
	}
	
	public Cliente salvaCliente(Cliente cliente) {
		return repository.save(cliente);
	}

	public Cliente prendiPerId(Long id) {
		return repository.getById(id);
	}

	public Cliente aggiorna(Cliente cliente) {
		return repository.save(cliente);
	}
	
	public Cliente findByEmail(String email) {
		return repository.findByEmailContainingIgnoreCase(email);
	}
	
}
