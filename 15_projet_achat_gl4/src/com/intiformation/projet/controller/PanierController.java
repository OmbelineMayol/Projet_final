package com.intiformation.projet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

@Controller
public class PanierController {
	
	
	/* --------------- DECLARATION DES METHODES ----------------- */

	@RequestMapping(value="/consulterPanier", method=RequestMethod.GET)
	public String consulterPanier(WebRequest request) {
		
		return "consulterPanier";
	}

}
