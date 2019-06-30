package com.intiformation.projet.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.intiformation.projet.modele.Categorie;
import com.intiformation.projet.modele.Produit;

@Repository("categorieDaoBean")
public class CategorieDaoImpl implements ICategorieDao {

	// session factory d'hibernate
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * setters de la session factory pour injection spring <br/>
	 * 
	 * @param sessionFactory
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	@Override
	public void addCategorie(Categorie pcategorie) {
		// récup de la session courante
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

	@Transactional
	@Override
	public Categorie getCategorieByName(String nomCategorie) {

		// Recuperation de la session
		Session session = sessionFactory.getCurrentSession();

		// Creation de la requete HQL
		String reqHQL = "SELECT c FROM categorie c WHERE c.nomCategorie=?1";

		// Creation de la requete
		Query query = session.createQuery(reqHQL);

		// Passage des paramètres

		query.setParameter(1, nomCategorie);

		// Envoi de la req et récuperation du résultat

		Categorie categorie = (Categorie) query.getSingleResult();

		return categorie;
	}

}
