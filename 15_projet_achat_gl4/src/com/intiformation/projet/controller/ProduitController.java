package com.intiformation.projet.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.intiformation.projet.modele.Categorie;
import com.intiformation.projet.modele.Panier;
import com.intiformation.projet.modele.Produit;
import com.intiformation.projet.service.ICategorieService;
import com.intiformation.projet.service.IProduitService;

@Controller("produiController")
public class ProduitController {

	/* -------------- DECLARATION DES ATTRIBUTS ----------------- */

	private List<String> nomDesCategories;
	private Panier panier;

	// Getter et setter
	public List<String> getNomDesCategories() {
		this.nomDesCategories = categorieService.getNomCategorie();
		return nomDesCategories;
	}

	public void setNomDesCategories(List<String> nomDesCategories) {
		this.nomDesCategories = nomDesCategories;
	}

	/* ---------- ASSOCIATION AVEC LA COUCHE SERVICE ------------ */
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

	/* --------------- DECLARATION DES METHODES ----------------- */

	/**
	 * Methode permettant d'envoyer sur le formulaire pour modifier un produit
	 * 
	 * @param pIdProduit
	 * @param modele
	 * @return
	 */
	@RequestMapping(value = "/produit/form/udpate*", method = RequestMethod.GET)
	public ModelAndView updateProduitForm(@RequestParam("produitId") int pIdProduit, ModelMap modele) {

		// Recuperation du produit
		Produit produit = produitService.getProduitByIdService(pIdProduit);
		List<String> listNomCategorie = categorieService.getNomCategorie();
		// Insersion dans le modele
		modele.addAttribute("produitUpdate", produit);
		modele.addAttribute("nomsCategories", listNomCategorie);
		// definition de la vue
		String vue = "updateProduitForm";

		// Creation du model and view
		ModelAndView mav = new ModelAndView(vue, modele);

		return mav;
	}

	/**
	 * Permet la modification d'un produit
	 */
	@RequestMapping(value = "/produit/update", method = RequestMethod.POST)
	public String updateProduit(@ModelAttribute("produitUpdate") Produit pProduit, ModelMap modele) {

		// Recuperation de la categorie
		String nomCatg = pProduit.getCategorie().getNomCategorie();
		Categorie cat = categorieService.getCategorieByName(nomCatg);
		pProduit.setCategorie(cat);
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
	@RequestMapping(value = "/produit/supprimer/{produitId}", method = RequestMethod.GET)
	public String deleteProduit(@PathVariable("produitId") int pIdProduit, ModelMap modele) {

		// Suppression du produit
		produitService.deleteProduitService(pIdProduit);

		// MAJ de la liste des produit
		List<Produit> listOut = produitService.getAllProduitService();
		modele.addAttribute("allProduit", listOut);

		// Renvoi sur la page d'accueil ADM

		return "redirect:/accueilAdm";
	}

	/**
	 * Permet de rechercher les produits en fonction de la categorie
	 * 
	 * @return
	 */
	@RequestMapping(value = "/produit/byCategorie", method = RequestMethod.POST)
	public String rechercherPdtParCat(@ModelAttribute("categorie") Categorie categorie, ModelMap modele) {
		// Categorie cat = (Categorie) modele.get("categorie");
		// String nom = cat.getNomCategorie();
		// String test = "srth";
		if (categorie.getNomCategorie() == "srth") {
			List<Produit> listOut = produitService.getAllProduitService();
			modele.addAttribute("allProduit", listOut);

		} else {

			List<Produit> listOut = produitService.getProduitByCategorieService(categorie);
			modele.addAttribute("allProduit", listOut);

		}

		Categorie categorie2 = new Categorie();
		modele.addAttribute("categorie", categorie2);

		List<String> listNomCategorie = categorieService.getNomCategorie();
		modele.addAttribute("nomsCategories", listNomCategorie);

		return "accueil";
	}

	/**
	 * Permet d'initialiser un produit afin de l'ajouter
	 * 
	 * @param modele
	 * @return
	 */
	@RequestMapping(value = "/produit/form/ajouter", method = RequestMethod.GET)
	public ModelAndView ajouterProduitForm() {

		// initialisation du produit
		Produit produit = new Produit();

		// Creation du modele
		ModelMap modele = new ModelMap();

		// Ajout du produit au modele
		modele.addAttribute("produitAj", produit);

		// ajout de la liste des noms de categorie

		modele.addAttribute("nomsCategories", this.getNomDesCategories());

		// definition de la vue
		String vue = "ajouterProduitForm";

		// Construction du modele and vue
		ModelAndView mav = new ModelAndView(vue, modele);

		// Renvoi du modele and view
		return mav;
	}

	/**
	 * Methode permettant l'ajout d'un produit
	 * 
	 * @param produit
	 * @return
	 */
	@RequestMapping(value = "/produit/ajouter", method = RequestMethod.POST)
	public String ajouterProduit(@ModelAttribute("produitAj") Produit produit) {

		// Recuperation de la categorie
		String nomCatg = produit.getCategorie().getNomCategorie();
		Categorie cat = categorieService.getCategorieByName(nomCatg);
		produit.setCategorie(cat);

		produitService.addProduitService(produit);

		return "redirect:/accueilAdm";
	}

	@RequestMapping(value = "produit/ajout/panier")
	public ModelAndView ajouterAuPanier(@ModelAttribute("allProduit") List<Produit> listeProduit, ModelMap modele,
			WebRequest request) {

		List<Produit> listOut = new ArrayList<>();

		for (Produit produit : listeProduit) {

			if (produit.isSelectionne()) {
				listOut.add(produit);
			}

		}
		
		this.panier.setListProduits(listOut);
		request.setAttribute("panier", this.panier, WebRequest.SCOPE_SESSION);
		
		// Recuperation de la liste de tous les produits
		modele.addAttribute("allProduit", produitService.getAllProduitService());
		modele.addAttribute("nomsCategories", this.getNomDesCategories());

		return new ModelAndView("accueil", modele);
	}

}
