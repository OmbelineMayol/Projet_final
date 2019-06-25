package com.intiformation.projet.modele;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "categorie")
@Table(name = "categories")
public class Categorie {

	/* ---------------- DECLARATION DES CHAMPS ------------------ */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_categorie")
	private int idCategorie;

	@Column(name = "nom")
	private String nomCategorie;

	@Column(name = "description")
	private String description;

	/* ---------------------- ASSOCIATION ----------------------- */

	@OneToMany(mappedBy = "categorie")
	private List<Produit> listeProduit;

	/* --------------------- CONSTRUCTEURS ---------------------- */

	public Categorie() {
		super();
	}

	public Categorie(String nomCategorie, String description) {
		super();
		this.nomCategorie = nomCategorie;
		this.description = description;

	}

	/* ------------------ GETTERS et SETTERS -------------------- */

	public int getIdCategorie() {
		return idCategorie;
	}

	public void setIdCategorie(int idCategorie) {
		this.idCategorie = idCategorie;
	}

	public String getNomCategorie() {
		return nomCategorie;
	}

	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Produit> getListeProduit() {
		return listeProduit;
	}

	public void setListeProduit(List<Produit> listeProduit) {
		this.listeProduit = listeProduit;
	}

}
