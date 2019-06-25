package com.intiformation.projet.modele;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "ligneDeCommande")
@Table(name = "lignedeCommandes")
public class LigneDeCommande {

	/* ---------------- DECLARATION DES CHAMPS ------------------ */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_ligneDeCommande")
	private int idLigneDeComande;
	
	@Column(name="quantite")
	private int quantite;
	
	@Column(name="prix")
	private double prix;

	/* ---------------------- ASSOCIATION ----------------------- */
	@ManyToOne
	@JoinColumn(name="commande_id", referencedColumnName="id_commande")
	private Commande commande;
	
	@ManyToOne
	@JoinColumn(name="produit_id", referencedColumnName="id_produit")
	private Produit produit;

	/* --------------------- CONSTRUCTEURS ---------------------- */

	public LigneDeCommande() {
		super();
	}

	public LigneDeCommande(int quantite, double prix) {
		super();
		this.quantite = quantite;
		this.prix = prix;

	}

	/* ------------------ GETTERS et SETTERS -------------------- */

	public int getIdLigneDeComande() {
		return idLigneDeComande;
	}

	public void setIdLigneDeComande(int idLigneDeComande) {
		this.idLigneDeComande = idLigneDeComande;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

}
