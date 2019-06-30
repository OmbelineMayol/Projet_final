package com.intiformation.projet.modele;

import java.util.List;

public class Panier {
	
	/* ---------------- DECLARATION DES CHAMPS ------------------ */
	
	private List<Produit> listProduits;

	
	/* --------------------- CONSTRUCTEURS ---------------------- */
	
	public Panier() {
		super();
	}
	
	
	public Panier(List<Produit> listProduits) {
		super();
		this.listProduits = listProduits;
	}


	/* ------------------ GETTERS et SETTERS -------------------- */
	

	public List<Produit> getListProduits() {
		return listProduits;
	}


	public void setListProduits(List<Produit> listProduits) {
		this.listProduits = listProduits;
	}


}
