package com.cgi.ferme.controlleur;



import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import com.cgi.ferme.domain.NourritureType;
import com.cgi.ferme.service.INourritureTypeService;

@Controller
@Transactional
public class NourritureControllerType {

	@Autowired
	private INourritureTypeService nourrituretypeService;
	
	
	@PreAuthorize("hasRole('ADMIN')" )
	@RequestMapping(value = "/nourritureType")
	public String NourritureTypeForm(Model model) {
		model.addAttribute("type_nourriture", new NourritureType());
		model.addAttribute("types_nourriture", nourrituretypeService.findAll());
		return "nourritureType";
	}
	
	@PreAuthorize("hasRole('ADMIN')" )
	@RequestMapping(value = "/nourritureType", method = RequestMethod.POST )
	@ResponseBody
	public void UpdateNourritureType(@Valid @ModelAttribute("NourritureType") NourritureType nourrituretype, Model model) {
			 nourrituretypeService.saveNourritureType(nourrituretype); 
			}
	

	@PreAuthorize("hasRole('ADMIN')" )
	@RequestMapping(value = "/nourritureType/{id}", method = RequestMethod.GET)
	@ResponseBody
	public String DeleteNourritureType(@PathVariable long id ) {
		String result;
		NourritureType type = nourrituretypeService.findOne(id);
	
	    if(type.getNourritures().isEmpty())
	    {
			nourrituretypeService.deleteNourritureType(id);
	    	result = "true";
	    } else  {
	    	result = "false";
	    }
	    	
		return  result; 
	}
	
//	@PreAuthorize("hasRole('ADMIN')" )	
//	@RequestMapping("/nourritureType/{id}")
//	@ResponseBody
//	public NourritureType EditNourritureType(@PathVariable long id, Model model) {
//		return nourrituretypeService.findOne(id) ;
//	}
	
	

}
