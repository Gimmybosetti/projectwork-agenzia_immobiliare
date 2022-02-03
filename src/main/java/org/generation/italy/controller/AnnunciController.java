package org.generation.italy.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.generation.italy.entityTransporter.AppuntamentoTransporter;
import org.generation.italy.model.Appuntamento;
import org.generation.italy.model.Cliente;
import org.generation.italy.model.Foto;
import org.generation.italy.model.Immobile;
import org.generation.italy.service.AppuntamentoService;
import org.generation.italy.service.ClasseEnergeticaService;
import org.generation.italy.service.ClienteService;
import org.generation.italy.service.FotoService;
import org.generation.italy.service.ImmobileService;
import org.generation.italy.service.SlotOrariService;
import org.generation.italy.service.TipologiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/GenerationsImmobiliare/home")
public class AnnunciController {
	
	@Autowired
	private FotoService fotoServ;

	@Autowired
	private ImmobileService service;
	
	@Autowired
	private SlotOrariService orariService;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private AppuntamentoService appService;
	
	@Autowired
	private ClasseEnergeticaService classeEnerService;
	
	@Autowired
	private TipologiaService tipologiaService;
	
	@GetMapping
	public String index (Model model) {
		model.addAttribute("listaImmobili", service.trovaImmobile());
		List<Foto> listaUnaFoto = new ArrayList<Foto>();
		//for(Immobile immobile : service.trovaImmobile()) {
		//	List<Foto> listaTemp = fotoServ.getAllFilesById(immobile.getId());
		//	listaUnaFoto.add(listaTemp.get(0));
		//}
		model.addAttribute("listaUnaFoto", listaUnaFoto);
		model.addAttribute("listaImmobili",service.trovaImmobile());
        model.addAttribute("immobile", new Immobile());
        model.addAttribute("listaClasseEner", classeEnerService.trovaClasseEnergetica());
        model.addAttribute("listaTipologia", tipologiaService.trovaTipologia());
		return "/client/annunci/indexAnnunci";
	}
	
	@RequestMapping(value="/{id}/foto", produces = MediaType.IMAGE_JPEG_VALUE)
	public ResponseEntity<byte[]> getFotoContent(@PathVariable Long id) {
		Foto foto = fotoServ.getFotoById(id);
		byte[] fotoContent = foto.getContent();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_JPEG);		
		return new ResponseEntity<byte[]>(fotoContent, headers, HttpStatus.OK);
	}
	
	@PostMapping
    public String indexPost (Model model,@RequestParam(name="tipologia",required=false) Long tipologia,
            @RequestParam(name="inVendita",required=false,defaultValue = "false") Boolean inVendita,
            @RequestParam(name="classeEnergetica",required=false) Long classeEnergetica) {
        model.addAttribute("listaImmobili",service.trovaImmobile());
        model.addAttribute("immobile", new Immobile());
        model.addAttribute("listaClasseEner", classeEnerService.trovaClasseEnergetica());
        model.addAttribute("listaTipologia", tipologiaService.trovaTipologia());
        model.addAttribute("listaFiltrata",service.listaImmobiliFiltarti(tipologia, inVendita, classeEnergetica));
        return "/client/annunci/annunciFiltrati";
    }
	
	@RequestMapping(value="/annunciFiltrati/{id}/foto", produces = MediaType.IMAGE_JPEG_VALUE)
	public ResponseEntity<byte[]> getFotoContentFiltrati(@PathVariable Long id) {
		Foto foto = fotoServ.getFotoById(id);
		byte[] fotoContent = foto.getContent();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_JPEG);		
		return new ResponseEntity<byte[]>(fotoContent, headers, HttpStatus.OK);
	}
	
	@GetMapping("/annunci/dettaglioAnnuncio/{id}")
	public String dettaglioA (@PathVariable("id") Long id, Model model) {
		Immobile immobile = service.prendiPerId(id);
		immobile.setNumVisual(immobile.getNumVisual() + 1);
		service.salvaImmobile(immobile);
		model.addAttribute("immobile", immobile);
		model.addAttribute("home", false);
		return "/client/annunci/dettaglioAnnuncio";
	}
	
	@GetMapping("/dettaglioAnnuncio/{id}")
	public String dettaglioH (@PathVariable("id") Long id, Model model) {
		Immobile immobile = service.prendiPerId(id);
		immobile.setNumVisual(immobile.getNumVisual() + 1);
		service.salvaImmobile(immobile);
		model.addAttribute("immobile", immobile);
		model.addAttribute("home", true);
		return "/client/annunci/dettaglioAnnuncio";
	}
	
	@GetMapping("/dettaglio/creaAppuntamento/{immobileId}")
	public String appuntamentoD (@PathVariable("immobileId") Long id, Model model) {
		model.addAttribute("orari", orariService.trovaSlotOrario());
		model.addAttribute("clienti", clienteService.trovaCliente());
		model.addAttribute("immobile", service.prendiPerId(id));
		model.addAttribute("appuntamentoTrans", new AppuntamentoTransporter());
		return "/client/annunci/creaAppuntamento";
	}
	
	@PostMapping("/dettaglio/creaAppuntamento/{immobileId}")
	public String prenotaAppuntamentoD(
			@Valid @ModelAttribute("appuntamentoTrans") AppuntamentoTransporter appuntamentoTrans,
			@PathVariable("immobileId") Long id, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("orari", orariService.trovaSlotOrario());
			model.addAttribute("clienti", clienteService.trovaCliente());
			model.addAttribute("appuntamentoTrans", new AppuntamentoTransporter());
			model.addAttribute("immobile", service.prendiPerId(id));
			return "/client/annunci/creaAppuntamento";
		}
		List<Appuntamento> app = appService.trovaAppuntamentoPerImmobile(id);
		Cliente cliente = clienteService.findByEmail(appuntamentoTrans.getEmail());
		if (cliente == null) {
			return "redirect:/GenerationsImmobiliare/home/dettaglio/creaAppuntamentoConUtente/{immobileId}";
		} else {
			try {
				Boolean exist = false;
				while (exist == false) {
					for (Appuntamento element : app) {
						if (appuntamentoTrans.getData().equals(element.getData())
								&& appuntamentoTrans.getSlotOrari().equals(element.getSlotOrari())) {
							model.addAttribute("orari", orariService.trovaSlotOrario());
							model.addAttribute("clienti", clienteService.trovaCliente());
							model.addAttribute("appuntamentoTrans", new AppuntamentoTransporter());
							model.addAttribute("immobile", service.prendiPerId(id));
							return "/client/annunci/creaAppuntamento";
						}
					}
					exist = true;
				}
				appService.salvaAppuntamento(appuntamentoTrans, id);
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

	@GetMapping("/dettaglio/creaAppuntamentoConUtente/{immobileId}")
	public String appuntamentoUtente (@PathVariable("immobileId") Long id, Model model) {
		model.addAttribute("orari", orariService.trovaSlotOrario());
		model.addAttribute("immobile", service.prendiPerId(id));
		model.addAttribute("appuntamentoTrans", new AppuntamentoTransporter());
		model.addAttribute("cliente", new Cliente());
		return "/client/annunci/creaAppuntamentoConUtente";
	}
	
	@PostMapping("/dettaglio/creaAppuntamentoConUtente/{immobileId}")
	public String creaAppuntamentoUtente(
			@Valid @ModelAttribute("appuntamentoTrans") AppuntamentoTransporter appuntamentoTrans,
			@PathVariable("immobileId") Long id, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("orari", orariService.trovaSlotOrario());
			model.addAttribute("appuntamentoTrans", new AppuntamentoTransporter());
			model.addAttribute("immobile", service.prendiPerId(id));
			return "/client/annunci/creaAppuntamento";
		}
		List<Appuntamento> app = appService.trovaAppuntamentoPerImmobile(id);
		try {
			Boolean exist = false;
			while (exist == false) {
				for (Appuntamento element : app) {
					if (appuntamentoTrans.getData().equals(element.getData())
							&& appuntamentoTrans.getSlotOrari().equals(element.getSlotOrari())) {
						model.addAttribute("orari", orariService.trovaSlotOrario());
						model.addAttribute("clienti", clienteService.trovaCliente());
						model.addAttribute("appuntamentoTrans", new AppuntamentoTransporter());
						model.addAttribute("immobile", service.prendiPerId(id));
						return "/client/annunci/creaAppuntamentoConUtente";
					}
				}
				exist = true;
			}
			appService.salvaAppuntamento(appuntamentoTrans, id);
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

