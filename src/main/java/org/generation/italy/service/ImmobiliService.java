package org.generation.italy.service;

import java.time.LocalDateTime;
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
		immobile.setDataIns(LocalDateTime.now());
		immobile.setLibero(true);
		return repository.save(immobile);
	}

	public Immobile prendiPerId(Long id) {
		return repository.getById(id);
	}

	public Immobile aggiorna(Immobile immobile) {
		Immobile immToUpdate = prendiPerId(immobile.getId());
		immobile.setDataIns(immToUpdate.getDataIns());
		return repository.save(immobile);
	}
}
