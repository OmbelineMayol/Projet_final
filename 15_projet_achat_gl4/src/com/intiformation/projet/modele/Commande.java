package com.intiformation.projet.modele;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name="commande")
@Table(name="commandes")
public class Commande {


	/* ---------------- DECLARATION DES CHAMPS ------------------ */

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_commande")
	private int idCommande;
	
	@Column(name="date")
	private Date dateDeCommande;
	
	/* ---------------------- ASSOCIATION ----------------------- */
	@ManyToOne
	@JoinColumn(name="client_id", referencedColumnName="id_client")
	private Client client;
	
	@OneToMany(mappedBy="commande")
	private List<LigneDeCommande> listeLigneDeCommande;

	/* --------------------- CONSTRUCTEURS ---------------------- */

	public Commande() {
		super();
	}

	public Commande(Date dateDeCommande) {
		super();
		this.dateDeCommande = dateDeCommande;
		
	}

	/* ------------------ GETTERS et SETTERS -------------------- */

	public int getIdCommande() {
		return idCommande;
	}

	public void setIdCommande(int idCommande) {
		this.idCommande = idCommande;
	}

	public Date getDateDeCommande() {
		return dateDeCommande;
	}

	public void setDateDeCommande(Date dateDeCommande) {
		this.dateDeCommande = dateDeCommande;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<LigneDeCommande> getListeLigneDeCommande() {
		return listeLigneDeCommande;
	}

	public void setListeLigneDeCommande(List<LigneDeCommande> listeLigneDeCommande) {
		this.listeLigneDeCommande = listeLigneDeCommande;
	}
		
	
	
	
	
	
	
	
	
	
}


