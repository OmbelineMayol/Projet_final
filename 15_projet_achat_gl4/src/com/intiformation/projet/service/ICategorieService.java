package com.intiformation.projet.service;

import java.util.List;

import com.intiformation.projet.modele.Categorie;

public interface ICategorieService {

	public void addCategorie(Categorie pCategorie);

	public void deleteCategorie(int pIdCategorie);

	public void updateCategorie(Categorie pCategorie);

	public Categorie getCategorieById(int pIdCategorie);
	
	public List<String> getNomCategorie();

	public List<Categorie> getAllCategories();
	
	public Categorie getCategorieByName(String nomCategorie);
}
