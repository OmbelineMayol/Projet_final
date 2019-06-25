package com.intiformation.projet.dao;

import java.util.List;

import com.intiformation.projet.modele.Client;

public interface IClientDao {

	
	public void addClient(Client pClient);

	public void updateClient(Client pClient);

	public void deleteClient(int pIdClient);

	public Client getClientById(int pIdClient);

	public List<Client> getAllClients();
	
}
