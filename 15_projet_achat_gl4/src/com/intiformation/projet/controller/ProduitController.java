package com.intiformation.projet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.intiformation.projet.modele.Produit;
import com.intiformation.projet.service.IProduitService;

@Controller("produitControllerBean")
@RequestMapping("produitControllerBean")
public class ProduitController {
	

	/* ---------- ASSOCIATION AVEC LA COUCHE SERVICE ------------ */
	@Autowired
	IProduitService produitService;

	// Setter pour l'injection Spring
	public void setProduitService(IProduitService produitService) {
		this.produitService = produitService;
	}
	

	/* --------------- DECLARATION DES METHODES ---------------- */

	/**
	 * Permet d'afficher la liste de tous les produits <br/>
	 * Revoie sur "accueil"
	 * @param modele
	 * @return
	 */
	@RequestMapping(name = "/getAllProduit", method=RequestMethod.GET)
	public String getAllProduit(ModelMap modele) {
		
		// Definition des données à renvoyer dans la vue
		
		List<Produit> listOut = produitService.getAllProduitService();
		
		// Ajout de la liste au Model
		modele.addAttribute("allProduit", listOut);
		
		// Defintion de la clé permettant l'accés à la page
		String cleOutcome="accueil";
		
		return cleOutcome;
	}
	

} // end class
