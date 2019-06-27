package com.intiformation.projet.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.intiformation.projet.modele.Categorie;

@Repository("categorieDaoBean")
public class CategorieDaoImpl implements ICategorieDao {

	// session factory d'hibernate
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * setters de la session factory pour injection spring <br/>
	 * @param sessionFactory
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	@Override
	public void addCategorie(Categorie pcategorie) {
		//r�cup de la session courante
		sessionFactory.getCurrentSession().save(pcategorie);
	}
	
	@Transactional
	@Override
	public void updateCategorie(Categorie pCategorie) {
		sessionFactory.getCurrentSession().update(pCategorie);
	}
	
	@Transactional
	@Override
	public void deleteCategorie(int pIdCategorie) {
		Categorie categorieOut = sessionFactory.getCurrentSession().get(Categorie.class, pIdCategorie);
		sessionFactory.getCurrentSession().delete(categorieOut);

	}
	
	@Transactional
	@Override
	public Categorie getCategorieById(int pIdCategorie) {
		
		return sessionFactory.getCurrentSession().get(Categorie.class, pIdCategorie);
	}
	
	@Transactional
	@Override
	public List<Categorie> getAllCategories() {
		
		return sessionFactory.getCurrentSession().createQuery("FROM categorie c").list();
	}

	@Transactional
	@Override
	public List<String> getNomCategorie() {
		return sessionFactory.getCurrentSession().createQuery("Select c.nomCategorie From categorie c").list();
	}

	

	
}
