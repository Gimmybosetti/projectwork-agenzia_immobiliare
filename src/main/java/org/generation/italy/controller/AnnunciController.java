package org.generation.italy.controller;

import org.generation.italy.model.Appuntamento;
import org.generation.italy.service.ClienteService;
import org.generation.italy.service.ImmobileService;
import org.generation.italy.service.SlotOrariService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/GenerationsImmobiliare/home")
public class AnnunciController {

	@Autowired
	private ImmobileService service;
	
	@Autowired
	private SlotOrariService orariService;
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping
	public String index (Model model) {
		model.addAttribute("listaImmobili",service.trovaImmobile());
		return "/client/annunci/indexAnnunci";
	}
	
	// !! DA IMPLEMENTARE !!
	@GetMapping("/annunciFiltrati")
	public String annunciFiltrati (Model model) {
		model.addAttribute("listaImmobili",service.trovaImmobile());
		return "/client/annunci/annunciFiltrati";
	}
	
	@GetMapping("/dettaglioAnnuncio/{id}")
	public String dettaglio (@PathVariable("id") Long id, Model model) {
		model.addAttribute("immobile", service.prendiPerId(id));
		return "/client/annunci/dettaglioAnnuncio";
	}
	
	@GetMapping("/annunci/prenotaAppuntamento/{id}")
	public String appuntamentoL (@PathVariable("id") Long id, Model model) {
		model.addAttribute("orari", orariService.trovaSlotOrario());
		model.addAttribute("clienti", clienteService.trovaCliente());
		model.addAttribute("immobile", service.prendiPerId(id));
		model.addAttribute("appuntamento", new Appuntamento());
		model.addAttribute("dettaglio", false);
		return "/client/annunci/prenotaAppuntamento";
	}
	
	@GetMapping("/dettaglio/prenotaAppuntamento/{id}")
	public String appuntamentoD (@PathVariable("id") Long id, Model model) {
		model.addAttribute("orari", orariService.trovaSlotOrario());
		model.addAttribute("clienti", clienteService.trovaCliente());
		model.addAttribute("immobile", service.prendiPerId(id));
		model.addAttribute("appuntamento", new Appuntamento());
		model.addAttribute("dettaglio", true);
		return "/client/annunci/prenotaAppuntamento";
	}
	
}






