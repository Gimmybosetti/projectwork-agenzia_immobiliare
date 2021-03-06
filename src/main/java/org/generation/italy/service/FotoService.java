package org.generation.italy.service;

import java.util.List;

import org.generation.italy.model.Foto;
import org.generation.italy.repository.FotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FotoService implements FotoServiceInterface {

	@Autowired
	private FotoRepository fotoRepo;
	
	@Override
	public List<Foto> getAllFiles() {
		return fotoRepo.findAll();
	}
	
	@Override
	public List<Foto> getAllFilesById(Long id) {
		return fotoRepo.findImmobileFotoById(id);
	}

	@Override
	public void saveAllFilesList(List<Foto> fileList) {
		for (Foto foto : fileList)
            fotoRepo.save(foto);
	}

	public List<Foto> findAllAgentiFoto() {
		return fotoRepo.findAgenteFoto();
	}
	
	public Foto getFotoById(Long id) {
		return fotoRepo.findById(id).get();
	}
	
}
