package org.generation.italy.service;

import java.util.List;

import org.generation.italy.model.Immobile;
import org.generation.italy.repository.ImmobiliRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImmobiliService {
	
	@Autowired
	private ImmobiliRepository repository;
	
	public List<Immobile> trovaImmobile(){
		return repository.findAll();
	}
	public Immobile salvaImmobile(Immobile immobile) {
		return repository.save(immobile);
	}
}
