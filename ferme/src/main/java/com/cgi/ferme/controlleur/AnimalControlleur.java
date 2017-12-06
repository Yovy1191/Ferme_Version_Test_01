package com.cgi.ferme.controlleur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;



import com.cgi.ferme.service.IAnimalService;


@Controller
public class AnimalControlleur {

	@Autowired
	private IAnimalService animalService;
	
	
	// Retourner liste des animaux de la ferme

    @RequestMapping("/animal")
	private String ListAnimal(Model model) {
		model.addAttribute("listanimal", animalService.findAll());
		return "animal";
	}

	// Un Animal en particulier
   
   	@RequestMapping("/animal/{id}")
	public String get(Model model, @PathVariable long id) {
		model.addAttribute("listanimal", animalService.findOne(id));
		return "redirect:/ajouterFerme";
	}
	
	
	

}
