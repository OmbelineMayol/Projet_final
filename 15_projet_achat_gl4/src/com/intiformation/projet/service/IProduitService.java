package com.intiformation.projet.service;

import java.util.List;

import com.intiformation.projet.modele.Categorie;
import com.intiformation.projet.modele.Produit;


public interface IProduitService {
	

	public void addProduitService(Produit produit);

	public void updateProduitService(Produit pProduit);

	public void deleteProduitService(int pIdProduit);

	public Produit getProduitByIdService(int pIdProduit);
	
	public List<Produit> getProduitByCategorieService(Categorie categorie);

	public List<Produit> getAllProduitService();

}
