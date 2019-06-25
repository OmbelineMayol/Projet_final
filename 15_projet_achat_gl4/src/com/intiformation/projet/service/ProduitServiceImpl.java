package com.intiformation.projet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiformation.projet.dao.IProduitDao;
import com.intiformation.projet.modele.Categorie;
import com.intiformation.projet.modele.Produit;

@Service("produitServiceBean")
public class ProduitServiceImpl implements IProduitService {

	/* ------------ ASSOCIATION AVEC LA COUCHE DAO -------------- */
	@Autowired
	private IProduitDao produitDao;

	// Setter de produitDao pour l'injection Spring
	public void setProduitDao(IProduitDao produitDao) {
		this.produitDao = produitDao;
	}

	/* --------------- REDEFINITION DES METHODES ---------------- */

	/**
	 * Ajouter un produit à la BD
	 */
	@Override
	public void addProduitService(Produit produit) {
		produitDao.addProduit(produit);

	}

	/**
	 * Modifier un produit dans la BD
	 */

	@Override
	public void updateProduitService(Produit pProduit) {
		produitDao.updateProduit(pProduit);

	}

	/**
	 * Supprimer un produit de la bd
	 */
	@Override
	public void deleteProduitService(int pIdProduit) {
		produitDao.deleteProduit(pIdProduit);
	}

	/**
	 * Rechercher un produit par son id
	 */

	@Override
	public Produit getProduitByIdService(int pIdProduit) {
		return produitDao.getProduitById(pIdProduit);
	}

	/**
	 * Recuperation des produits par catégorie
	 */
	@Override
	public List<Produit> getProduitByCategorieService(Categorie categorie) {
		return produitDao.getProduitByCategorie(categorie);
	}

	@Override
	public List<Produit> getAllProduitService() {
		return produitDao.getAllProduit();
	}

}
