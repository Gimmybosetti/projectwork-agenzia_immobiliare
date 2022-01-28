package org.generation.italy.service;

import java.util.List;

import org.generation.italy.model.SlotOrari;
import org.generation.italy.repository.SlotOrariRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SlotOrariService {
	
	@Autowired
	private SlotOrariRepository repository;
	
	public List<SlotOrari> trovaSlotOrario(){
		return repository.findAll();
	}

}
