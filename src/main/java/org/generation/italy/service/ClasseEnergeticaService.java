package org.generation.italy.service;

import java.util.List;

import org.generation.italy.model.ClasseEnergetica;
import org.generation.italy.repository.ClasseEnergeticaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClasseEnergeticaService {

	@Autowired
	private ClasseEnergeticaRepository repository;
	
	public List<ClasseEnergetica> trovaClasseEnergetica(){
		return repository.findAll();
	}
}
