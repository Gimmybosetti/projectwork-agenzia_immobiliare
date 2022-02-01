package org.generation.italy.service;

import java.util.List;

import org.generation.italy.entityTransporter.AppuntamentoTransporter;
import org.generation.italy.model.Appuntamento;
import org.generation.italy.model.Cliente;
import org.generation.italy.model.Immobile;
import org.generation.italy.repository.AppuntamentoRepository;
import org.generation.italy.repository.ClienteRepository;
import org.generation.italy.repository.InterfacciaConteggio;
import org.generation.italy.repository.InterfacciaConteggioImmobili;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AppuntamentoService {
	
	@Autowired ImmobileService immServ;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private ClienteRepository clienteRepo;
		
	@Autowired
	private AppuntamentoRepository repository;
	
	public List<Appuntamento> trovaAppuntamento(){
		return repository.findAll();
	}
	
	public List<Appuntamento> trovaAppuntamentoPerImmobile(Long id){
		return repository.findAllById(id);
	}
	
	public List<Appuntamento> listaAppuntamentiProssimaSettimana(){
		return repository.listaAppuntamentiProssimaSettimana();
	}
	
	public Appuntamento salvaAppuntamento(AppuntamentoTransporter appuntamentoTrans, Long id, List<Appuntamento> app) throws Exception {
		Appuntamento appuntamento = new Appuntamento();
		
		Immobile immobile = immServ.prendiPerId(id);
		appuntamento.setAgente(immobile.getAgente());
		appuntamento.setData(appuntamentoTrans.getData());
		appuntamento.setSlotOrari(appuntamentoTrans.getSlotOrari());
		appuntamento.setImmobile(immobile);
		Cliente cliente = clienteService.findByEmail(appuntamentoTrans.getEmail());
		if(cliente == null) {
			cliente = new Cliente(appuntamentoTrans);
			clienteRepo.save(cliente);
		}
		appuntamento.setCliente(cliente);
		return repository.save(appuntamento);
	}
	
	public List<InterfacciaConteggio> AppuntamentiTotali() {
		return repository.listaAppuntamentiConteggioAgente();
	}
	public List<InterfacciaConteggioImmobili> ConteggioImmobiliPerAgente() {
		return repository.listaAppuntamentiConteggioAgenteImmobili();
	}
	
	
}






