package com.intiformation.projet.dao;

import java.util.List;

import com.intiformation.projet.modele.Categorie;

public interface ICategorieDao {

	public void addCategorie(Categorie pcategorie);

	public void deleteCategorie(int pIdCategorie);
	
	public void updateCategorie(Categorie pcategorie);
	
	public Categorie getCategorieById(int pIdCategorie);
	
	public List<String> getNomCategorie();
	
	public List<Categorie> getAllCategories();
	
	public Categorie getCategorieByName(String nomCategorie);
	
	
	
}
