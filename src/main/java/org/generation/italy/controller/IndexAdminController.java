package org.generation.italy.controller;

import org.generation.italy.service.AgenteService;
import org.generation.italy.service.AppuntamentoService;
import org.generation.italy.service.ClienteService;
import org.generation.italy.service.ImmobileService;
import org.generation.italy.service.SlotOrariService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/administration")
public class IndexAdminController {
	
	@Autowired
	private ImmobileService service;
	
	@Autowired
	private AppuntamentoService appuntamentoService;
	
	@Autowired
	private SlotOrariService slotOrarioService;
	
	@Autowired
	private AgenteService agenteService;
	
	@Autowired
	private ClienteService clienteService;

	@GetMapping
	public String index (Model model) {
		model.addAttribute("listaImmobiliRecenti", service.listaImmobiliRecenti());
		model.addAttribute("listaImmobiliPiuVisualizzati", service.listaImmobiliPiuVisualizzati());
		model.addAttribute("listaSlotOrari", slotOrarioService.trovaSlotOrario());
		model.addAttribute("listaAgenti", agenteService.trovaAgente());
		model.addAttribute("listaClienti", clienteService.trovaCliente());
		model.addAttribute("listaImmobili", service.trovaImmobile());
		model.addAttribute("listaAppuntamentiOrdinatiPerAgente", appuntamentoService.listaAppuntamentiOrdinatiPerAgente());
		model.addAttribute("listaAppuntamentiProssimaSettimana", appuntamentoService.listaAppuntamentiProssimaSettimana());
		return "/amministrazione/indexAdministration";
	}

}
