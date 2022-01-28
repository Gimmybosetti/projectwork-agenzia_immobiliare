package org.generation.italy.repository;

import java.util.List;

import org.generation.italy.model.Immobile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ImmobileRepository extends JpaRepository<Immobile, Long> {
	
	@Query(
			value = "SELECT * FROM immobile WHERE TIMESTAMPDIFF(DAY, data_ins, CURDATE()) <=7 ",
			nativeQuery = true)
	List<Immobile> listaImmobiliRecenti();
	
	@Query(
			value = "select * from immobile order by num_visual desc ; ",
			nativeQuery = true)
	List<Immobile> listaImmobiliPiuVisualizzati();
	
	
}
