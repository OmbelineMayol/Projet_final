package com.intiformation.projet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.intiformation.projet.modele.Categorie;
import com.intiformation.projet.service.ICategorieService;



public class CategorieController {

	//d�claration du service
	@Autowired
	private ICategorieService categorieService;
	/**
	 * setter du service pour injection spring
	 */
	public void setCategorieService(ICategorieService categorieService) {
		this.categorieService = categorieService;
	}
	
	/* --------------- DECLARATION DES METHODES ---------------- */
	
	/**
	 * recup la liste des categories dans la BDD (modele1)<br/>
	 * recup la liste des noms des categories dans la BDD (modele2)<br/>
	 * @param modele
	 * @return 
	 */
	@RequestMapping(name="/getAllCategorie", method=RequestMethod.GET)
	public String listeNomCategorie (ModelMap modele1, ModelMap modele2) {
		
		//D�finir les donn�es � renvoyer vers la vue (liste des clients de la bdd)
		
		List<Categorie> listeCategorie = categorieService.getAllCategories();
		List<String> listeNomsCategories = categorieService.getNomCategorie();
		
		modele1.addAttribute("allCategorie",listeCategorie);
		modele2.addAttribute("allNomsCategories",listeNomsCategories);
		
		// Retourner la cl� permettant l'acc�s � la page
		
		return "categorie";
	}
	
	

	
}
