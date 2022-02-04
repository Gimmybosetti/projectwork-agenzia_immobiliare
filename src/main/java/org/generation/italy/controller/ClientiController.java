package org.generation.italy.controller;


import javax.validation.Valid;

import org.generation.italy.model.Cliente;
import org.generation.italy.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/administration/clienti")
public class ClientiController {

	@Autowired
	private ClienteService service;
	
	@GetMapping
	public String index (Model model) {
		model.addAttribute("listaClienti", service.trovaCliente());
		return "/amministrazione/clienti/indexClienti";
	}
	
	@GetMapping("/crea")
	public String creaCliente (Model model) {
		model.addAttribute("modifica", false);
		model.addAttribute("cliente", new Cliente());
		model.addAttribute("listaClienti", service.trovaCliente());
		return "/amministrazione/clienti/formCliente";
	}
	@PostMapping("/crea")
	public String postCliente(@Valid @ModelAttribute("cliente") Cliente formCliente, BindingResult bindingResult, Model model, RedirectAttributes redirectAttrs) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("modifica", false);
			model.addAttribute("listaClienti", service.trovaCliente());
			redirectAttrs.addFlashAttribute("successo", "Errore, si prega di riprovare compilando tutti i campi.");
			return "redirect:/administration/clienti/crea";
		}
		service.salvaCliente(formCliente);
		redirectAttrs.addFlashAttribute("successo", "Creazione di un account utente avvenuta con successo.");
		return "redirect:/administration/clienti";
	}
	@GetMapping("/modifica/{id}")
	public String modificaCliente(@PathVariable("id") Long id, Model model) {
		model.addAttribute("modifica", true);
		model.addAttribute("cliente", service.prendiPerId(id));
		model.addAttribute("listaClienti", service.trovaCliente());
		return "/amministrazione/clienti/formCliente";
	}
	@PostMapping("/modifica/{id}")
	public String aggiornaCliente(@Valid @ModelAttribute("cliente") Cliente formCliente, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("modifica", true);
			model.addAttribute("listaClienti", service.trovaCliente());
			return "/amministrazione/clienti/formCliente";
		}
		service.aggiorna(formCliente);
		return "redirect:/administration/clienti";
	}
}
