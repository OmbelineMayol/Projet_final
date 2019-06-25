package com.intiformation.projet.modele;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name="role") // declaration de la classe comme entité
@Table(name="roles")
public class Role {
	
	/* ---------------- DECLARATION DES CHAMPS ------------------ */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_role")
	private int idRole;
	
	@Column(name="roleName")
	private String roleName;
	
	/* ---------------------- ASSOCIATION ----------------------- */
	@ManyToOne
	@JoinColumn(name="user_id", referencedColumnName="id_user")
	private User user;
	
	
	/* --------------------- CONSTRUCTEURS ---------------------- */
	
	public Role() {
		super();
	}

	public Role(String roleName) {
		super();
		this.roleName = roleName;
	}
	
	/* ------------------ GETTERS et SETTERS -------------------- */
	

	public int getIdRole() {
		return idRole;
	}

	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
	

}
