package com.cgi.ferme.controlleur;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cgi.ferme.domain.Animal;
import com.cgi.ferme.domain.Ferme;
import com.cgi.ferme.domain.Fermier;
import com.cgi.ferme.domain.TypeAnimal;
import com.cgi.ferme.service.IAnimalService;
import com.cgi.ferme.service.IFermeService;
import com.cgi.ferme.service.IFermierService;
import com.cgi.ferme.service.INourritureService;
import com.cgi.ferme.service.ITypeAnimalService;





@Controller
public class FermeControlleur {

	@Autowired
	private IFermeService fermeService;
	
	@Autowired
	private IFermierService fermierService;
	
	@Autowired
	private IAnimalService animalService;
	
		
	@Autowired
	private ITypeAnimalService typeAnimalService;
	
	@Autowired
	private INourritureService nourritureService;


	public static final String CLE_CACHE_CONTROL = "Cache-Control";
    public static final String CACHE_CONTROL = "no-cache, must-revalidate";

    public static final String MIME_MANIFEST = "text/cache-manifest";
    public static final String MIME_HTML = "text/html";

	

    @RequestMapping(value = "/offline.manifest", method = RequestMethod.GET)
    public void getManifeste(HttpServletRequest request, HttpServletResponse reponse) throws IOException {
        retournerAvecEnTetes(reponse, "static/css/offline.manifest", MIME_MANIFEST);
    }


    @RequestMapping(value = "/offline.html", method = RequestMethod.GET)
    public void getOfflineHTML(HttpServletRequest request, HttpServletResponse reponse) throws IOException {
        retournerAvecEnTetes(reponse, "static/css/offline.html", MIME_HTML);
    }
    
    
    private void retournerAvecEnTetes(HttpServletResponse reponse, String ressource, String typeMIME) throws IOException {
    //    LOG.debug("Desserte du fichier {} avec en-têtes particuliers.", ressource);
        reponse.setContentType(typeMIME);
        reponse.setHeader(CLE_CACHE_CONTROL, CACHE_CONTROL);
        final ServletOutputStream outputStream = reponse.getOutputStream();
        outputStream.write(getRessource(ressource));
        outputStream.flush();
    }

	
	private static byte[] getRessource(String chemin) throws IOException {
		byte[] buffer = new byte[1024];    
		int bytesRead;        
		java.io.InputStream input = new ClassPathResource(chemin).getInputStream();       
		ByteArrayOutputStream output = new ByteArrayOutputStream();      
		while ((bytesRead = input.read(buffer, 0, buffer.length)) != -1) 
		{         output.write(buffer, 0, bytesRead);        }     
		output.flush();     
		
		return output.toByteArray();
	
	}

	
	
	

	// Retourner  une liste de fermes
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER') " )
	@RequestMapping(value = "/ferme")
	public String getAll(Model model) {
		model.addAttribute("fermes", fermeService.findAll());
		return "ferme";
	}

	// Un ferme en particulier
	@PreAuthorize("hasRole('USER')" )
	@RequestMapping("/ferme/{id}")
	public String get(Model model, @PathVariable long id) {
						
		model.addAttribute("fermes", fermeService.findOne(id));
		return "ferme";
	}
	
	

	//Ajouter un Ferme
	@PreAuthorize("hasRole('ADMIN')" )
	@RequestMapping(value = "/ajouterFerme")
	public String fermeForm(Model model) {
		model.addAttribute("ferme", new Ferme());
		model.addAttribute("fermier", new Fermier());
		return "ajouterFerme";
	}

	// Save Ferme BD
	@PreAuthorize("hasRole('ADMIN')" )
	@RequestMapping(value = "ajouterFerme", method = RequestMethod.POST)
	public String saveFerme(Ferme ferme, Fermier fermier) {
		fermier = fermierService.saveFermier(fermier);
		ferme.setFermier(fermier);
		fermeService.saveFerme(ferme);
		return "redirect:/ajouterAnimalFerme/" + ferme.getId();
	}

	

	
	 
	 // Page Initial -  Add Animal the farm
	@PreAuthorize("hasRole('ADMIN')" )
   @RequestMapping("/ajouterAnimalFerme/{id}")
	   public  String getFormAnimalFerme(Model model,@PathVariable long id) {
	               model.addAttribute("ferme",fermeService.findOne(id));
	               model.addAttribute("AnimalPourAjouter", typeAnimalService.findAll());
	              return "ajouterAnimalFerme" ;
	    }
	 
	
   // Add more animal farms - Button Ajouter Animal
	@PreAuthorize("hasRole('ADMIN')" )
   @RequestMapping(value="ajouterAnimalFerme", method=RequestMethod.POST,  params="action=AddPlusAnimals")
         public String savePlusAnimalFerme(Ferme ferme, Animal animal, @RequestParam("ferme_id") long ferme_id, 
   	        		  @RequestParam("type_animal_id") long animal_id,
   	        		  @RequestParam(value="action", required=true) String action) 
           {
   	          ferme = fermeService.findOne(ferme_id);
   	          animal.setNourritureConsomme(0);
   	          animal.setFerme(ferme);
   	          TypeAnimal idAnimal = new TypeAnimal();
   	          idAnimal.setId(animal_id);
   	          animal.setType(idAnimal);
   	          animalService.saveAnimal(animal);
    	          ferme.getAnimaux().add(animal);
   	          fermeService.saveFerme(ferme);
   	                 
   	           return "redirect:/ajouterAnimalFerme/" +  ferme.getId() ;
   }
   

   // Next step  - ajouterNourriture Ferme
	@PreAuthorize("hasRole('ADMIN')" )
   @RequestMapping(value="ajouterAnimalFerme", method=RequestMethod.POST,  params="action=continuer")
   public String saveAnimalFerme(Ferme ferme, Animal animal, @RequestParam("ferme_id") long ferme_id, 
	        		  @RequestParam("type_animal_id") long animal_id,
	        		  @RequestParam(value="action", required=true) String action) 
     {
    return "redirect:/ajouterNourritureAnimal/" +  ferme_id ;
     }
	
	
	
	

	// Ajouter un Animal dans ferme
	@PreAuthorize("hasRole('ADMIN')" )
		@RequestMapping(value = "/ajouterAnimal")
		public String AnimalForm(Model model) {
			model.addAttribute("Animal", new Animal());
			model.addAttribute("animaux", animalService.findAll());
			model.addAttribute("nourriture", nourritureService.findAll());
			return "ajouterAnimal";
		}

		// Save information de l'animal dans la BD
	   @PreAuthorize("hasRole('ADMIN')" )
		@RequestMapping(value = "ajouterAnimal", method = RequestMethod.POST)
		public String saveAnimal(Animal animal) {
			animalService.saveAnimal(animal);
			return "redirect:/animal/" + animal.getId();
		}

	

}
