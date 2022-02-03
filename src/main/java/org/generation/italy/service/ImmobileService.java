package org.generation.italy.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.generation.italy.model.Immobile;
import org.generation.italy.repository.ImmobileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImmobileService {
	
	@Autowired
	private ImmobileRepository repository;
	
	public List<Immobile> trovaImmobile(){
		return repository.findAll();
	}

	public Immobile salvaImmobile(Immobile immobile) {
		if(immobile.getNumVisual() == null) {
			immobile.setDataIns(LocalDateTime.now());
			immobile.setCancellato(false);
			immobile.setLibero(true);
			immobile.setNumVisual(0);
		}
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
	
	public List<Immobile> listaImmobiliRecenti(){
		return repository.listaImmobiliRecenti();
	}
	
	public List<Immobile> listaImmobiliPiuVisualizzati(){
		return repository.listaImmobiliPiuVisualizzati();
	}
	
	public List<Immobile> listaImmobiliFiltarti(Long tipologia, Boolean inVendita, Long classeEnergetica){
        List<Immobile> lista = repository.findAll();
        List<Immobile> listaFiltrata = lista.stream()
                .filter(e -> e.getTipologia().getId().equals(tipologia) || tipologia == null)
                .filter(e -> e.getInVendita().equals(inVendita) || inVendita == null) 
                .filter(e -> e.getClasseEnergetica().getId().equals(classeEnergetica) || classeEnergetica == null)
                .collect(Collectors.toList());

                return listaFiltrata;
    }
}
