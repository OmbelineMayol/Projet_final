package com.intiformation.projet.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.intiformation.projet.modele.Client;


@Repository("clientDaoBean")
public class ClientDaoImpl implements IClientDao{
	
	// session factory hibernate
	
		@Autowired
		private SessionFactory sf;
		
		/**
		 * Setter de la sessionFactory
		 */
		public void setSf(SessionFactory sf) {
			this.sf = sf;
		}
		
		@Transactional
		@Override
		public void addClient(Client pClient) {
			
			//getCurrentSession() = recup de la session  dans une meme transaction
			sf.getCurrentSession().save(pClient);
			
		}
		
		/**
		 * Maj
		 */
		@Transactional
		@Override
		public void updateClient(Client pClient) {
			sf.getCurrentSession().update(pClient);
			
		}

		/**
		 * suppr / id
		 */
		@Transactional
		@Override
		public void deleteClient(int pIdClient) {
			Client clientOut = sf.getCurrentSession().get(Client.class, pIdClient);
			sf.getCurrentSession().delete(clientOut);	
		}

		
		/**
		 * get / id
		 */
		@Transactional
		@Override
		public Client getClientById(int pIdClient) {
			return sf.getCurrentSession().get(Client.class, pIdClient);
		}
		
		/**
		 * get all<br/>
		 */
		@Transactional
		@Override
		public List<Client> getAllClients() {
			
		List<Client> listeClOut =	sf.getCurrentSession().createQuery("FROM client cl").list();
			return listeClOut;
		}
	

}
