package org.generation.italy.service;

import java.util.List;

import org.generation.italy.model.Foto;

public interface FotoServiceInterface {

	List<Foto> getAllFiles();
    void saveAllFilesList(List<Foto> fileList);
	List<Foto> getAllFilesById(Long id);
	
}
