package com.intiformation.projet.modele;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;



@Entity(name = "produit")
@Table(name = "produits")
public class Produit {

	/* ---------------- DECLARATION DES CHAMPS ------------------ */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_produit")
	private int idProduit;

	@Column(name = "designation")
	private String designation;

	@Column(name = "description")
	private String description;

	@Column(name = "prix")
	private double prix;

	@Transient
	private String quantite;

	@Column(name = "photo")
	private String photo;

	@Transient
	private int selectionne;

	/* ---------------------- ASSOCIATION ----------------------- */
	@OneToMany(mappedBy = "produit")
	private List<LigneDeCommande> listeLigneDeCommande;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "categorie_id", referencedColumnName = "id_categorie")
	private Categorie categorie;

	/* --------------------- CONSTRUCTEURS ---------------------- */

	public Produit() {
		super();
	}

	public Produit(String designation, String description, double prix, String quantite, String photo,
			int selectionne) {
		super();
		this.designation = designation;
		this.description = description;
		this.prix = prix;
		this.quantite = quantite;
		this.photo = photo;
		this.selectionne = selectionne;
	}

	/* ------------------ GETTERS et SETTERS -------------------- */

	public int getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public String getQuantite() {
		return quantite;
	}

	public void setQuantite(String quantite) {
		this.quantite = quantite;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public List<LigneDeCommande> getListeLigneDeCommande() {
		return listeLigneDeCommande;
	}

	public void setListeLigneDeCommande(List<LigneDeCommande> listeLigneDeCommande) {
		this.listeLigneDeCommande = listeLigneDeCommande;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public int isSelectionne() {
		return selectionne;
	}

	public void setSelectionne(int selectionne) {
		this.selectionne = selectionne;
	}

}
