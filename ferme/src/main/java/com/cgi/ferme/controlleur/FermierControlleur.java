package com.cgi.ferme.controlleur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.cgi.ferme.service.IFermierService;

@Controller
public class FermierControlleur {

	@Autowired
	private IFermierService fermierService;


	// Retourner la liste des fermiers
	@PreAuthorize("hasRole('USER')" )
	@RequestMapping(value = "/fermier")
	private String ListFermiers(Model model) {
		model.addAttribute("listfermiers", fermierService.findAll());
		return "fermier";
	}

	
	// Un fermier en particulier
	//@PreAuthorize("hasAnyRole('ADMIN') or hasAnyRole('USER') " )
	@RequestMapping("/fermier/{id}")
	public String get(Model model, @PathVariable long id) {
		model.addAttribute("fermiers", fermierService.findOne(id));
		return "fermier";
	}


	public void setFermierService(IFermierService fermierService) {
		this.fermierService = fermierService;
	}
	
}
