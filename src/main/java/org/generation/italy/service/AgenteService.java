package org.generation.italy.service;

import java.util.List;

import org.generation.italy.model.Agente;
import org.generation.italy.repository.AgenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgenteService {

	@Autowired
	private AgenteRepository repository;
	
	public List<Agente> trovaAgente(){
		return repository.findAll();
	}
	
	public Agente salvaAgente(Agente agente) {
		return repository.save(agente);
	}

	public Agente prendiPerId(Long id) {
		return repository.getById(id);
	}

	public Agente aggiorna(Agente agente) {
		return repository.save(agente);
	}
	
}
