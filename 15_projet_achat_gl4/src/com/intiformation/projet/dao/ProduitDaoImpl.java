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

@Repository("produitDaoBean")
public class ProduitDaoImpl implements IProduitDao {

	/* ---------- ASSOCIATION AVEC LA SESSION FACTORY------------ */
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/* --------------- REDEFINITION DES METHODES ---------------- */

	/**
	 * Ajouter un produit dans la BD
	 */
	@Override
	@Transactional
	public void addProduit(Produit produit) {
		sessionFactory.getCurrentSession().save(produit);

	}

	/**
	 * Modifier un produit dans la BD
	 */
	@Override
	@Transactional
	public void updateProduit(Produit pProduit) {
		sessionFactory.getCurrentSession().update(pProduit);

	}

	/**
	 * Supprimer un produit de la BD
	 */
	@Override
	@Transactional
	public void deleteProduit(int pIdProduit) {
		Produit pOut = sessionFactory.getCurrentSession().find(Produit.class, pIdProduit);
		sessionFactory.getCurrentSession().delete(pOut);

	}

	/**
	 * Récuperer un produit dans la BD par son ID
	 */
	@Override
	@Transactional(readOnly = true)
	public Produit getProduitById(int pIdProduit) {

		return sessionFactory.getCurrentSession().find(Produit.class, pIdProduit);
	}

	/**
	 * Récupérer la liste des produits par leur Caterogie
	 */
	@Override
	@Transactional(readOnly=true)
	public List<Produit> getProduitByCategorie(Categorie categorie) {
		// Recuperation de la session
		Session session = sessionFactory.getCurrentSession();

		// Creation de la requete HQL
		String reqHQL = "SELECT p FROM produit p, categorie c WHERE c.idCategorie=p.categorie.idCategorie AND c.nomCategorie =?1";

		// Creation de la requete
		Query query = session.createQuery(reqHQL);

		// Passage des paramètres

		query.setParameter(1, categorie.getNomCategorie());

		// Envoi de la req et récuperation du résultat

		List<Produit> listeOut = query.list();

		return null;
	}

	/**
	 * Récupérer tous les produits de la bd
	 */
	@Override
	@Transactional(readOnly=true)
	public List<Produit> getAllProduit() {
List<Produit> listeOut = sessionFactory.getCurrentSession().createQuery("FROM produit p").list();
		return listeOut;
	}

}
