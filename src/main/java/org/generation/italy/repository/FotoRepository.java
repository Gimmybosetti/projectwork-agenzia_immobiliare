package org.generation.italy.repository;

import java.util.List;

import org.generation.italy.model.Foto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FotoRepository extends JpaRepository<Foto, Long> {

	@Query(value="select * from immobile_foto if2 inner join foto f on if2.foto_id = f.id where immobile_id = ?1", nativeQuery = true)
	List<Foto> findAllById(Long id);
	
}
