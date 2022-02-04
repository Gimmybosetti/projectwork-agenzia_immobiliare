package org.generation.italy.controller;


import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.generation.italy.model.Agente;
import org.generation.italy.model.Foto;
import org.generation.italy.service.AgenteService;
import org.generation.italy.service.FotoService;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/administration/agenti")
public class AgentiController {

	@Autowired
	private AgenteService service;
	
	@Autowired
	private FotoService fotoServ;
	
	@GetMapping
	public String index (Model model) {
		model.addAttribute("listaAgenti", service.trovaAgente());
		return "/amministrazione/agenti/indexAgenti";
	}
	
	@RequestMapping(value="/{id}/foto", produces = MediaType.IMAGE_JPEG_VALUE)
	public ResponseEntity<byte[]> getFotoContent(@PathVariable Long id) {
		Foto foto = fotoServ.getFotoById(id);
		byte[] fotoContent = foto.getContent();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_JPEG);		
		return new ResponseEntity<byte[]>(fotoContent, headers, HttpStatus.OK);
	}
	
	@RequestMapping(value="/modifica/{agenteId}/{fotoId}/foto", produces = MediaType.IMAGE_JPEG_VALUE)
	public ResponseEntity<byte[]> getFotoContent(@PathVariable Long agenteId, @PathVariable Long fotoId, Model model) {
		Foto foto = fotoServ.getFotoById(fotoId);
		byte[] fotoContent = foto.getContent();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_JPEG);		
		return new ResponseEntity<byte[]>(fotoContent, headers, HttpStatus.OK);
	}
	
	@GetMapping("/crea")
	public String creaAgente (Model model) {
		model.addAttribute("modifica", false);
		model.addAttribute("agente", new Agente());
		model.addAttribute("listaAgenti", service.trovaAgente());
		return "/amministrazione/agenti/formAgente";
	}
	@PostMapping("/crea")
	public String postAgente(@Valid @ModelAttribute("agente") Agente formAgente, BindingResult bindingResult,
			@RequestParam("files") MultipartFile[] files, Model model, RedirectAttributes redirectAttrs) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("modifica", false);
			model.addAttribute("listaAgenti", service.trovaAgente());
			redirectAttrs.addFlashAttribute("successo", "Errore, si prega di riprovare compilando tutti i campi.");
			return "redirect:/administration/agenti/crea";
		}
		try {
	        List<Foto> fileList = new ArrayList<Foto>();
	        for (MultipartFile file : files) {
	        	Foto foto = new Foto();
	            foto.setContent(file.getBytes()) ;
	            foto.setTitolo(file.getOriginalFilename());
	            foto.setType(file.getContentType());
	            fileList.add(foto);
	            }
	            //fotoServ.saveAllFilesList(fileList);
	        formAgente.setFoto(fileList);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		service.salvaAgente(formAgente);
		redirectAttrs.addFlashAttribute("successo", "Creazione avvenuta con successo.");
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
	public String aggiornaAgente(@Valid @ModelAttribute("agente") Agente formAgente, BindingResult bindingResult,
			@RequestParam("files") MultipartFile[] files, Model model) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("modifica", true);
			model.addAttribute("listaAgenti", service.trovaAgente());
			return "/amministrazione/agenti/formAgente";
		}
		try {
	        List<Foto> fileList = new ArrayList<Foto>();
	        for (MultipartFile file : files) {
	        	Foto foto = new Foto();
	            foto.setContent(file.getBytes()) ;
	            foto.setTitolo(file.getOriginalFilename());
	            foto.setType(file.getContentType());
	            fileList.add(foto);
	            }
	            //fotoServ.saveAllFilesList(fileList);
	        formAgente.setFoto(fileList);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		service.aggiorna(formAgente);
		return "redirect:/administration/agenti";
	}
}
