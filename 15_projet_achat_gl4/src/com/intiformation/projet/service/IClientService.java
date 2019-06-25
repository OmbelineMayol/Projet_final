package com.intiformation.projet.service;

import java.util.List;

import com.intiformation.projet.modele.Client;


public interface IClientService {
	
	public void ajouterClientService(Client pClient);

	public void modifierClientService(Client pClient);

	public void supprimerClientService(int pIdClient);

	public Client findClientServiceById(int pIdClient);

	public List<Client> findAllClientsService();
	

}
