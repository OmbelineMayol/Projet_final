package com.intiformation.projet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.intiformation.projet.dao.IClientDao;
import com.intiformation.projet.modele.Client;


@Service("clientServiceBean")
public class ClientServicesImpl implements IClientService{
	
		/* ------------ ASSOCIATION AVEC LA COUCHE DAO -------------- */
		@Autowired
		private IClientDao clientDao;

		//setter
		
		public void setClientDao(IClientDao clientDao) {
			this.clientDao = clientDao;
		}

		/* --------------- REDEFINITION DES METHODES ---------------- */
		
		public void ajouterClientService(Client pClient) {
			clientDao.addClient(pClient);
		}

		
		
		public void modifierClientService(Client pClient) {
			clientDao.updateClient(pClient);

		}

		
		public void supprimerClientService(int pIdClient) {
			clientDao.deleteClient(pIdClient);

		}

		
		public Client findClientServiceById(int pIdClient) {
			return clientDao.getClientById(pIdClient);
			
		}

		
		public List<Client> findAllClientsService() {
			return clientDao.getAllClients();
		}

}
