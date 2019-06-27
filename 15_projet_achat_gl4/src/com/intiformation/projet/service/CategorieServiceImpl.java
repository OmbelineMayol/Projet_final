package com.intiformation.projet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intiformation.projet.dao.ICategorieDao;
import com.intiformation.projet.modele.Categorie;

@Service("categorieServiceBean")
public class CategorieServiceImpl implements ICategorieService{

	
	//déclaration du dao
	@Autowired
	private ICategorieDao categorieDao;
	
	/**
	 * setter du dao pour injection spring
	 * 
	 */
	public void setCategorieDao(ICategorieDao categorieDao) {
		this.categorieDao = categorieDao;
	}

	/* --------------- REDEFINITION DES METHODES ---------------- */
	
	@Override
	public void addCategorie(Categorie pCategorie) {
		categorieDao.addCategorie(pCategorie);	
	}
	
	@Override
	public void deleteCategorie(int pIdCategorie) {
		categorieDao.deleteCategorie(pIdCategorie);
	}

	@Override
	public void updateCategorie(Categorie pCategorie) {
		categorieDao.updateCategorie(pCategorie);
	}

	@Override
	public Categorie getCategorieById(int pIdCategorie) {
		return categorieDao.getCategorieById(pIdCategorie);
	}

	@Override
	public List<Categorie> getAllCategories() {
		return categorieDao.getAllCategories();
	}

	@Override
	public List<String> getNomCategorie() {
		return categorieDao.getNomCategorie();
	}

}
