package org.generation.italy.repository;

import java.util.List;

import org.generation.italy.model.Appuntamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AppuntamentoRepository extends JpaRepository<Appuntamento, Long> {

	@Query(value = "select * from appuntamento a join agente ag on a.agente_id = ag.id join cliente c on a.cliente_id = c.id join immobile i on a.immobile_id = i.id join slot_orari so on a.slot_orari_id = so.id where TIMESTAMPDIFF(day , CURDATE(), a.`data` ) <=7 and TIMESTAMPDIFF(day , CURDATE(), a.`data` ) >=0 order by a.data asc", nativeQuery = true)
	List<Appuntamento> listaAppuntamentiProssimaSettimana();

	@Query(value = "select a2.nome as nomeAgente ,a2.cognome as cognomeAgente,count(a.id) as appuntamentiTotali from appuntamento a join agente a2 on a.agente_id =a2.id group by a2.nome ",nativeQuery = true )
	List<InterfacciaConteggio> listaAppuntamentiConteggioAgente();
 
	@Query(value="select COUNT(*) as conteggio, a.nome as nomeAgente ,a.cognome as cognomeAgente from immobile i join agente a on a.id=i.agente_id where i.libero <> 1 group by i.agente_id", nativeQuery = true)
	List<InterfacciaConteggioImmobili> listaAppuntamentiConteggioAgenteImmobili();
	
	@Query(value="select * from appuntamento a where immobile_id = ?1", nativeQuery = true)
	List<Appuntamento> findAllById(Long id);

}