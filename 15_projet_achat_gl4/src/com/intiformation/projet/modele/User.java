package com.intiformation.projet.modele;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity(name="user")
@Table(name="users")
public class User {
	

	/* ---------------- DECLARATION DES CHAMPS ------------------ */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_user")
	private int idUser;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="actived")
	private boolean actived;


	/* --------------------- CONSTRUCTEURS ---------------------- */
	
	public User() {
		super();
	}


	public User(String username, String password, boolean actived) {
		super();
		this.username = username;
		this.password = password;
		this.actived = actived;
	}

	
	/* ------------------ GETTERS et SETTERS -------------------- */
	
	public int getIdUser() {
		return idUser;
	}


	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}


	public String getUsername() {
		return username;
	}


	public void setUserName(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public boolean isActived() {
		return actived;
	}


	public void setActived(boolean actived) {
		this.actived = actived;
	}
	

	
	
	
	
	
	

}
