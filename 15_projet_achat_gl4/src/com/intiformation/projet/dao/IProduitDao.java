package com.intiformation.projet.dao;

import java.util.List;

import com.intiformation.projet.modele.Categorie;
import com.intiformation.projet.modele.Produit;

public interface IProduitDao {
	
	public void addProduit(Produit produit);

	public void updateProduit(Produit pProduit);

	public void deleteProduit(int pIdProduit);

	public Produit getProduitById(int pIdProduit);
	
	public List<Produit> getProduitByCategorie(Categorie categorie);

	public List<Produit> getAllProduit();
	
	

}
