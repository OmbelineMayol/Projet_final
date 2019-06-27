package com.intiformation.projet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.intiformation.projet.modele.Produit;
import com.intiformation.projet.service.IProduitService;

@Controller("produiController")
public class ProduitController {
	
	/* -------------- DECLARATION DES ATTRIBUTS ----------------- */
	

	/* ---------- ASSOCIATION AVEC LA COUCHE SERVICE ------------ */
	@Autowired
	IProduitService produitService;

	// Setter pour l'injection Spring
	public void setProduitService(IProduitService produitService) {
		this.produitService = produitService;
	}
	
	/* --------------- DECLARATION DES METHODES ----------------- */

	/**
	 * Methode permettant d'envoyer sur le formulaire pour modifier un produit
	 * @param pIdProduit
	 * @param modele
	 * @return
	 */
	@RequestMapping(value="/produit/form/udpate", method=RequestMethod.GET)
	public ModelAndView updateProduitForm(@RequestParam("produitId") int pIdProduit, ModelMap modele) {
		
		//Recuperation du produit
		Produit produit = produitService.getProduitByIdService(pIdProduit);
		
		//Insersion dans le modele
		modele.addAttribute("produitUpdate", produit);
		
		// definition de la vue 
		String vue = "updateProduitForm";
		
		// Creation du model and view
		ModelAndView mav = new ModelAndView(vue, modele);
		
		return mav;
	}
	
	/**
	 * Permet la modification d'un produit
	 */
	@RequestMapping(value="/produit/update", method=RequestMethod.POST)
	public String updateProduit(@ModelAttribute("produitUpdate") Produit pProduit, ModelMap modele) {
		
		// Modification du produit dans la bdd
		produitService.updateProduitService(pProduit);
		
		// récupération de la nouvelle liste de produit
		modele.addAttribute("allProduit", produitService.getAllProduitService());
		
		// redirection vers la page accueil ADM
		
		return "redirect:/accueilAdm";
		
	}
	
	/**
	 * Permet la suppression d'un produit
	 */
	@RequestMapping(value="/produit/supprimer/{produitId}", method=RequestMethod.GET)
	public String deleteProduit(@PathVariable("produitId") int pIdProduit, ModelMap modele) {
		
		// Suppression du produit
		produitService.deleteProduitService(pIdProduit);
		
		// MAJ de la liste des produit
		List<Produit> listOut = produitService.getAllProduitService();
		modele.addAttribute("allProduit", listOut);
		
		// Renvoi sur la page d'accueil ADM
		
		return "redirect:/accueilAdm";
	}

}
