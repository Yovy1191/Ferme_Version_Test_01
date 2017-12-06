package com.cgi.ferme.controlleur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cgi.ferme.domain.Animal;
import com.cgi.ferme.domain.Ferme;
import com.cgi.ferme.domain.Fermier;
import com.cgi.ferme.domain.Nourriture;
import com.cgi.ferme.domain.NourritureAnimal;
import com.cgi.ferme.domain.NourritureAnimalId;
import com.cgi.ferme.service.IAnimalService;
import com.cgi.ferme.service.IFermeService;
import com.cgi.ferme.service.IFermierService;
import com.cgi.ferme.service.INourritureAnimalService;
import com.cgi.ferme.service.INourritureService;

@Controller
public class NourritureControlleur {

	@Autowired
	private INourritureService nourritureService;
	
	@Autowired
	private IFermeService fermeService;
	
	
	@Autowired
	private IAnimalService animalService;
	
	@Autowired
	private INourritureAnimalService nourritureAnimalService;
	
	@Autowired
	private IFermierService fermierService;
	
	

	@RequestMapping("/nourriture")
	private String ListAnimal(Model model) {
		model.addAttribute("listnourriture", nourritureService.findAll());
    	return "nourriture";
	}

	// Une nourriture en particulier
	@RequestMapping("/nourriture/{id}")
	public String get(Model model, @PathVariable long id) {
		model.addAttribute("nourriture", nourritureService.findOne(id));
		return "nourriture";
	}
	
	
	
	  // Add food animal 

	  @RequestMapping("/ajouterNourritureAnimal/{id}")
		      public  String getFormNourritureAnimal(Model model,@PathVariable long id) {
	    	           Ferme f = fermeService.findOne(id);
		               model.addAttribute("ferme",f);
		               model.addAttribute("nourriture", nourritureService.findAll());
		      return "ajouterNourritureAnimal" ;
		    }
	  
	  
	
	  @RequestMapping(value="ajouterNourritureAnimal", method=RequestMethod.POST)
	  public String saveNourritureAnimalFerme(Model model, Ferme ferme, Animal animal, @RequestParam("nourriture_id") long nourriture_id, 
	  		@RequestParam("ferme_id") long ferme_id, @RequestParam("animal_id") long animal_id, @RequestParam("quantite") long quantite
	         )
	    {
	        
		  NourritureAnimal na = new NourritureAnimal();
		  NourritureAnimalId id = new NourritureAnimalId();
		  Animal a = animalService.findOne(animal_id);
		  id.setAnimal(a);
	      Nourriture n = nourritureService.findOne(nourriture_id);
	  	  id.setNourriture(n);
	  	  na.setId(id);
	  	  na.setQuantite(quantite);
	  	  ferme = fermeService.findOne(ferme_id);
	  	  nourritureAnimalService.saveNourritureAnimal(na);
		return "redirect:/ajouterNourritureAnimal/" +  ferme.getId() ;
	   }

	  @RequestMapping(value="ajouterNourritureAnimal", method=RequestMethod.POST, params="action=continuer" )
	  public String SortirAjouterANimalFerme(Model model, Ferme ferme, Animal animal, @RequestParam("ferme_id") long ferme_id, 
	  		 @RequestParam(value="action", required=true) String action )
	    {
	 
	   	return "redirect:/ferme/" +  ferme_id ;
	   }


	  
	  //Nourrir l'animal 
	  
	  
	  // Mapping - Nourrir Animal

		@RequestMapping(value = "/nourrirAnimal")
		public String nourrirAnimalFormInit(Model model) {
			model.addAttribute("ferme", new Ferme());
			 //model.addAttribute("", fermeService.findAll());
			return "nourrirAnimal";
		}
		
		
		// Nourrir les animaux de ferme selected
	
		@RequestMapping(value = "nourrirAnimal", method = RequestMethod.POST, params = "action=nourrir")
		public String saveNourrirFerme(@RequestParam("ferme_id") long ferme_id,
				@RequestParam(value = "action", required = true) String action, Ferme ferme) {
			ferme = fermeService.findOne(ferme_id);
			fermeService.eatAllFoodAvailable(ferme);
			fermeService.saveFerme(ferme);
			return "redirect:/ferme/" + ferme.getId();
		}

		
		// Search une ferme pour Adresse
	
		@RequestMapping(value = "nourrirAnimal", method = RequestMethod.POST, params = "action=Searchadresse")
		public String findByAdresse(Model model, Ferme ferme, @RequestParam("adresse") String adresse,
				@RequestParam(value = "action", required = true) String action) {
			model.addAttribute("ferme", fermeService.getByAdresseStartsWith(adresse));
			return "nourrirAnimal";
		}
		

		// Search une ferme pour Fermier
	
		@RequestMapping(value = "nourrirAnimal", method = RequestMethod.POST, params = "action=SearchFermier")
		public String findByFermier(Model model, Ferme ferme, Fermier fermier,
				@RequestParam("fermier_nom") String fermier_nom,
				@RequestParam(value = "action", required = true) String action) {
			Fermier f = fermierService.getByNomStartsWith(fermier_nom);
			model.addAttribute("ferme", fermeService.findOne(f.getId()));
			return "nourrirAnimal";
		}


	  
	  

}
