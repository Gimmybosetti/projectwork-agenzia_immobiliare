package org.generation.italy.service;

import java.util.List;

import org.generation.italy.model.Tipologia;
import org.generation.italy.repository.TipologiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipologiaService {

	@Autowired
	private TipologiaRepository repository;
	
	public List<Tipologia> trovaTipologia(){
		return repository.findAll();
	}
}
