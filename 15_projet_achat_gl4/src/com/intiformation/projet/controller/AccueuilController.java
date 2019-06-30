package com.intiformation.projet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.intiformation.projet.modele.Categorie;
import com.intiformation.projet.modele.Client;
import com.intiformation.projet.modele.Produit;
import com.intiformation.projet.service.ClientServicesImpl;
import com.intiformation.projet.service.ICategorieService;
import com.intiformation.projet.service.IClientService;
import com.intiformation.projet.service.IProduitService;

@Controller
@RequestMapping("/welcome")
public class AccueuilController {
	

	/* ---------- ASSOCIATION AVEC LA COUCHE SERVICE ------------ */
	
	// 1. De produit
	@Autowired
	IProduitService produitService;

	// Setter pour l'injection Spring
	public void setProduitService(IProduitService produitService) {
		this.produitService = produitService;
	}
	
	// 2. de Catégorie
	@Autowired
	ICategorieService categorieService;
	
	public void setCategorieService(ICategorieService categorieService) {
		this.categorieService = categorieService;
	}
	
	
	// 3. de Client
	@Autowired
	IClientService clientService;
	

	public void setClientService(IClientService clientService) {
		this.clientService = clientService;
	}



	/* --------------- DECLARATION DES METHODES ---------------- */

	/**
	 * Permet d'initialiser tous les objets dans le Model <br/>
	 * Revoie sur "accueil"
	 * @param modele
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET)
	public String getAllProduit(ModelMap modele) {
		
		
		// Definition des données à renvoyer dans la vue
		
		List<Produit> listProduits = produitService.getAllProduitService();
		List<String> listNomCategorie = categorieService.getNomCategorie();
		Categorie categorie = new Categorie();
		Produit produit = new Produit();
		List<Categorie> listCategorie = categorieService.getAllCategories();
		List<Client> listClient = clientService.findAllClientsService();
		Client client = new Client();
		
		// Ajout de la liste au Model
		modele.addAttribute("allProduit", listProduits);
		modele.addAttribute("allCategorie", listCategorie);
		modele.addAttribute("allClients", listClient);
		modele.addAttribute("nomsCategories", listNomCategorie);
		modele.addAttribute("produit", produit);
		modele.addAttribute("categorie", categorie);
		modele.addAttribute("client", client);
		
		// Defintion de la clé permettant l'accés à la page
		String cleOutcome="accueil";
		
		return cleOutcome;
	}
	

} // end class
