package org.generation.italy.repository;

import java.util.List;

import org.generation.italy.model.Appuntamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AppuntamentoRepository extends JpaRepository<Appuntamento, Long> {
	
	@Query(
			value = "select * from appuntamento a join agente ag on a.agente_id = ag.id join cliente c on a.cliente_id = c.id join immobile i on a.immobile_id = i.id join slot_orari so on a.slot_orari_id = so.id where TIMESTAMPDIFF(day , CURDATE(), a.`data` ) <=7 and TIMESTAMPDIFF(day , CURDATE(), a.`data` ) >=0 order by a.data asc",
			nativeQuery = true)
	List<Appuntamento> listaAppuntamentiProssimaSettimana();

	List<Appuntamento> findAllById(Long id);



	

}