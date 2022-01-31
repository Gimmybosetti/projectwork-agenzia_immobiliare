package org.generation.italy.service;

import java.util.List;

import org.generation.italy.entityTransporter.AppuntamentoTransporter;
import org.generation.italy.model.Appuntamento;
import org.generation.italy.model.Cliente;
import org.generation.italy.repository.AppuntamentoRepository;
import org.generation.italy.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AppuntamentoService {
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private ClienteRepository clienteRepo;
		
	@Autowired
	private AppuntamentoRepository repository;
	
	public List<Appuntamento> trovaAppuntamento(){
		return repository.findAll();
	}
	
	public List<Appuntamento> listaAppuntamentiProssimaSettimana(){
		return repository.listaAppuntamentiProssimaSettimana();
	}
	
	public Appuntamento salvaAppuntamento(AppuntamentoTransporter appuntamentoTrans) throws Exception {
		Appuntamento appuntamento = new Appuntamento();
		appuntamento.setAgente(appuntamentoTrans.getAgente());
		appuntamento.setData(appuntamentoTrans.getData());
		appuntamento.setSlotOrari(appuntamentoTrans.getSlotOrari());
		appuntamento.setImmobile(appuntamentoTrans.getImmobile());
		Cliente cliente = clienteService.findByEmail(appuntamentoTrans.getEmail());
		if(cliente == null) {
			cliente = new Cliente(appuntamentoTrans);
			clienteRepo.save(cliente);
		}
		appuntamento.setCliente(cliente);
		return repository.save(appuntamento);
	}
	
	
}






