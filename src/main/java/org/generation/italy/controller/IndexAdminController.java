package org.generation.italy.controller;


import org.generation.italy.service.AppuntamentoService;
import org.generation.italy.service.ImmobileService;
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
	
	

	@GetMapping
	public String index (Model model) {
		model.addAttribute("listaImmobiliRecenti", service.listaImmobiliRecenti());
		model.addAttribute("listaImmobiliPiuVisualizzati", service.listaImmobiliPiuVisualizzati());
		model.addAttribute("listaAppuntamentiProssimaSettimana", appuntamentoService.listaAppuntamentiProssimaSettimana());
		return "/amministrazione/indexAdministration";
	}

}
