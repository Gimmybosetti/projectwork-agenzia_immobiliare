package org.generation.italy.controller;


import javax.validation.Valid;

import org.generation.italy.model.Agente;
import org.generation.italy.service.AgenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/administration/agenti")
public class AgentiController {

	@Autowired
	private AgenteService service;
	
	@GetMapping
	public String index (Model model) {
		model.addAttribute("listaAgenti", service.trovaAgente());
		return "/amministrazione/agenti/indexAgenti";
	}
	
	@GetMapping("/crea")
	public String creaAgente (Model model) {
		model.addAttribute("modifica", false);
		model.addAttribute("agente", new Agente());
		model.addAttribute("listaAgenti", service.trovaAgente());
		return "/amministrazione/agenti/formAgente";
	}
	@PostMapping("/crea")
	public String postAgente(@Valid @ModelAttribute("agente") Agente formAgente, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("modifica", false);
			model.addAttribute("listaAgenti", service.trovaAgente());
			return "/amministrazione/agenti/formAgente";
		}
		service.salvaAgente(formAgente);
		return "redirect:/administration/agenti";
	}
	@GetMapping("/modifica/{id}")
	public String modificaAgente(@PathVariable("id") Long id, Model model) {
		model.addAttribute("modifica", true);
		model.addAttribute("agente", service.prendiPerId(id));
		model.addAttribute("listaAgenti", service.trovaAgente());
		return "/amministrazione/agenti/formAgente";
	}
	@PostMapping("/modifica/{id}")
	public String aggiornaAgente(@Valid @ModelAttribute("agente") Agente formAgente, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("modifica", true);
			model.addAttribute("listaAgenti", service.trovaAgente());
			return "/amministrazione/agenti/formAgente";
		}
		service.aggiorna(formAgente);
		return "redirect:/administration/agenti";
	}
}
