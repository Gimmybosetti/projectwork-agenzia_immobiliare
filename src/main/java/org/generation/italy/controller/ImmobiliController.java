package org.generation.italy.controller;


import javax.validation.Valid;

import org.generation.italy.model.Immobile;
import org.generation.italy.service.AgenteService;
import org.generation.italy.service.ClasseEnergeticaService;
import org.generation.italy.service.ImmobileService;
import org.generation.italy.service.TipologiaService;
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
@RequestMapping("/administration/immobili")
public class ImmobiliController {
	
	@Autowired
	private ImmobileService service;
	
	@Autowired
	private AgenteService agenteService;
	
	@Autowired
	private ClasseEnergeticaService classeEnerService;
	
	@Autowired
	private TipologiaService tipologiaService;
	
	@GetMapping
	public String index (Model model) {
		model.addAttribute("listaImmobili",service.trovaImmobile());
		return "/amministrazione/immobili/indexImmobili";
	}
	@GetMapping("/crea")
	public String creaImmobile (Model model) {
		model.addAttribute("modifica", false);
		model.addAttribute("immobile", new Immobile());
		model.addAttribute("listaImmobili", service.trovaImmobile());
		model.addAttribute("listaAgenti", agenteService.trovaAgente());
		model.addAttribute("listaClasseEner", classeEnerService.trovaClasseEnergetica());
		model.addAttribute("listaTipologia", tipologiaService.trovaTipologia());
		return "/amministrazione/immobili/formImmobile";
	}
	@PostMapping("/crea")
	public String postImmobile(@Valid @ModelAttribute("immobile") Immobile formImmobile,BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("modifica", false);
			model.addAttribute("listaImmobili", service.trovaImmobile());
			model.addAttribute("listaAgenti", agenteService.trovaAgente());
			model.addAttribute("listaClasseEner", classeEnerService.trovaClasseEnergetica());
			model.addAttribute("listaTipologia", tipologiaService.trovaTipologia());
			return "/amministrazione/immobili/formImmobile";
		}
		service.salvaImmobile(formImmobile);
		return "redirect:/administration/immobili";
	}
	@GetMapping("/modifica/{id}")
	public String modificaImmobile(@PathVariable("id") Long id, Model model) {
		model.addAttribute("modifica", true);
		model.addAttribute("immobile", service.prendiPerId(id));
		model.addAttribute("listaImmobili", service.trovaImmobile());
		model.addAttribute("listaAgenti", agenteService.trovaAgente());
		model.addAttribute("listaClasseEner", classeEnerService.trovaClasseEnergetica());
		model.addAttribute("listaTipologia", tipologiaService.trovaTipologia());
		return "/amministrazione/immobili/formImmobile";
	}
	@PostMapping("/modifica/{id}")
	public String aggiornaImmobile(@Valid @ModelAttribute("immobile") Immobile formImmobile, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("modifica", true);
			model.addAttribute("listaImmobili", service.trovaImmobile());
			model.addAttribute("listaAgenti", agenteService.trovaAgente());
			model.addAttribute("listaClasseEner", classeEnerService.trovaClasseEnergetica());
			model.addAttribute("listaTipologia", tipologiaService.trovaTipologia());
			return "/amministrazione/immobili/formImmobile";
		}
	    service.aggiorna(formImmobile);
		return "redirect:/administration/immobili";
	}
}
