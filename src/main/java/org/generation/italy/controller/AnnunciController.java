package org.generation.italy.controller;

import javax.validation.Valid;

import org.generation.italy.entityTransporter.AppuntamentoTransporter;
import org.generation.italy.model.Cliente;
import org.generation.italy.service.AppuntamentoService;
import org.generation.italy.service.ClienteService;
import org.generation.italy.service.ImmobileService;
import org.generation.italy.service.SlotOrariService;
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
@RequestMapping("/GenerationsImmobiliare/home")
public class AnnunciController {

	@Autowired
	private ImmobileService service;
	
	@Autowired
	private SlotOrariService orariService;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private AppuntamentoService appService;
	
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
	
	@GetMapping("/annunci/dettaglioAnnuncio/{id}")
	public String dettaglioA (@PathVariable("id") Long id, Model model) {
		model.addAttribute("immobile", service.prendiPerId(id));
		model.addAttribute("home", false);
		return "/client/annunci/dettaglioAnnuncio";
	}
	@GetMapping("/dettaglioAnnuncio/{id}")
	public String dettaglioH (@PathVariable("id") Long id, Model model) {
		model.addAttribute("immobile", service.prendiPerId(id));
		model.addAttribute("home", true);
		return "/client/annunci/dettaglioAnnuncio";
	}
	
	@GetMapping("/dettaglio/creaAppuntamento/{id}")
	public String appuntamentoD (@PathVariable("id") Long id, Model model) {
		model.addAttribute("orari", orariService.trovaSlotOrario());
		model.addAttribute("clienti", clienteService.trovaCliente());
		model.addAttribute("immobile", service.prendiPerId(id));
		model.addAttribute("appuntamentoTrans", new AppuntamentoTransporter());
		return "/client/annunci/creaAppuntamento";
	}
	
	@PostMapping("/dettaglio/creaAppuntamento/{id}")
	public String prenotaAppuntamentoD (@Valid @ModelAttribute("appuntamentoTrans") AppuntamentoTransporter appuntamentoTrans, @PathVariable("id") Long id, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("orari", orariService.trovaSlotOrario());
			model.addAttribute("clienti", clienteService.trovaCliente());
			model.addAttribute("appuntamentoTrans", new AppuntamentoTransporter());
			model.addAttribute("immobile", service.prendiPerId(id));
			return "/client/annunci/creaAppuntamento";
		}
		Cliente cliente = clienteService.findByEmail(appuntamentoTrans.getEmail());
		if(cliente == null) {
			return "redirect:/GenerationsImmobiliare/home/dettaglio/creaAppuntamentoConUtente/{id}";
		}else {
			try {
				appService.salvaAppuntamento(appuntamentoTrans);
			} catch (Exception e) {
				model.addAttribute("orari", orariService.trovaSlotOrario());
				model.addAttribute("clienti", clienteService.trovaCliente());
				model.addAttribute("appuntamentoTrans", new AppuntamentoTransporter());
				model.addAttribute("immobile", service.prendiPerId(id));
				e.printStackTrace();
				return "/client/annunci/creaAppuntamento";
			}
			return "redirect:/GenerationsImmobiliare/home";
		}
	}

	
	@GetMapping("/dettaglio/creaAppuntamentoConUtente/{id}")
	public String appuntamentoUtente (@PathVariable("id") Long id, Model model) {
		model.addAttribute("orari", orariService.trovaSlotOrario());
		model.addAttribute("immobile", service.prendiPerId(id));
		model.addAttribute("appuntamentoTrans", new AppuntamentoTransporter());
		model.addAttribute("cliente", new Cliente());
		return "/client/annunci/creaAppuntamentoConUtente";
	}
	
	@PostMapping("/dettaglio/creaAppuntamentoConUtente/{id}")
	public String creaAppuntamentoUtente (@Valid @ModelAttribute("appuntamentoTrans") AppuntamentoTransporter appuntamentoTrans, @PathVariable("id") Long id, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("orari", orariService.trovaSlotOrario());
			model.addAttribute("appuntamentoTrans", new AppuntamentoTransporter());
			model.addAttribute("immobile", service.prendiPerId(id));
			return "/client/annunci/creaAppuntamento";
		}try {
				appService.salvaAppuntamento(appuntamentoTrans);
			} catch (Exception e) {
				model.addAttribute("orari", orariService.trovaSlotOrario());
				model.addAttribute("clienti", clienteService.trovaCliente());
				model.addAttribute("appuntamentoTrans", new AppuntamentoTransporter());
				model.addAttribute("immobile", service.prendiPerId(id));
				e.printStackTrace();
				return "/client/annunci/creaAppuntamentoConUtente";
			}
			return "redirect:/GenerationsImmobiliare/home";
		}
	
}


