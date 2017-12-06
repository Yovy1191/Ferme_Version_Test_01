
package com.cgi.ferme.controlleur;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class IndexController {

	//private static final String VIEW_ACCUEIL = "index";

	@RequestMapping(value="/")
	public String index(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) {
		response.setHeader(FermeControlleur.CLE_CACHE_CONTROL, FermeControlleur.CACHE_CONTROL);	
		return "index";
	}

	@GetMapping("/admin")
	public String admin() {
		return "admin";
	}

	@GetMapping("/user")
	public String user() {
		return "/user";
	}

	@GetMapping("/login")
	public String login() {
		return "/login";
	}

	@PostMapping("/login")
	public String log() {
		return "index";
	}

	@GetMapping("/403")
	public String error403() {
		return "/error/403";
	}
	
	
	

}
