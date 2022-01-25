package org.generation.italy.controller;


import javax.validation.Valid;

import org.generation.italy.model.Immobile;
import org.generation.italy.service.ImmobiliService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {
	
	@Autowired
	private ImmobiliService service;
	
	@GetMapping
	public String index (Model model) {
		model.addAttribute("listaImmobili",service.trovaImmobile());
		return "/immobili/index";
	}
	@GetMapping("/crea")
	public String creaImmobile (Model model) {
		model.addAttribute("edit", false);
		model.addAttribute("immobile", new Immobile());
		model.addAttribute("listaImmobili", service.trovaImmobile());
		return "/amministrazione/formImmobile";
	}
	@PostMapping("/crea")
	public String postImmobile(@Valid @ModelAttribute("immobile") Immobile formImmobile,BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("edit", false);
			model.addAttribute("listaImmobili", service.trovaImmobile());
			return "/amministrazione/formImmobile";
		}
		service.salvaImmobile(formImmobile);
		return "redirect:/";
	}
}
