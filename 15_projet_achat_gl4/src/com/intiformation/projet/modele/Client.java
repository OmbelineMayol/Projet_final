package com.intiformation.projet.modele;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "client")
@Table(name = "clients")
public class Client {

	/* ---------------- DECLARATION DES CHAMPS ------------------ */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_client")
	private int idClient;

	@Column(name = "nom")
	private String nomClient;

	@Column(name = "adresse")
	private String adresse;

	@Column(name = "email")
	private String email;

	@Column(name = "telephone")
	private String telephone;
	

	/* ---------------------- ASSOCIATION ----------------------- */
	@OneToMany(mappedBy="client")
	private List<Commande> listeCommande;
	/* --------------------- CONSTRUCTEURS ---------------------- */

	public Client() {
		super();
	}

	public Client(String nomClient, String adresse, String email, String telephone) {
		super();
		this.nomClient = nomClient;
		this.adresse = adresse;
		this.email = email;
		this.telephone = telephone;
	}

	/* ------------------ GETTERS et SETTERS -------------------- */

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public String getNomClient() {
		return nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public List<Commande> getListeCommande() {
		return listeCommande;
	}

	public void setListeCommande(List<Commande> listeCommande) {
		this.listeCommande = listeCommande;
	}

	
	

}
