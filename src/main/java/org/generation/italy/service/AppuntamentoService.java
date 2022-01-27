package org.generation.italy.service;

import java.util.List;

import org.generation.italy.model.Appuntamento;
import org.generation.italy.repository.AppuntamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppuntamentoService {
	
	@Autowired
	private AppuntamentoRepository repository;
	
	public List<Appuntamento> trovaAppuntamento(){
		return repository.findAll();
	}
	
	public List<Appuntamento> listaAppuntamentiProssimaSettimana(){
		return repository.listaAppuntamentiProssimaSettimana();
	}

}
