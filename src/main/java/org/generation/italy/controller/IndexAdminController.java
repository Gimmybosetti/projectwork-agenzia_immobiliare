package org.generation.italy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/administration")
public class IndexAdminController {

	@GetMapping
	public String index (Model model) {
		return "/amministrazione/indexAdministration";
	}

}
