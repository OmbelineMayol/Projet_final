package com.intiformation.projet.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.intiformation.projet.modele.Client;
import com.intiformation.projet.service.IClientService;

@Controller("clientController")
public class ClientController {
	
	/**
	 * Définition de ClientService
	 */
	@Autowired
	private IClientService clientService;

	/**
	 * setter de clientService
	 */

	public void seteService(IClientService clientService) {
		this.clientService = clientService;
	}
	
	/* --------------- DECLARATION DES METHODES ---------------- */
	
	/**
	 * recup la liste des clients dans la BDD<br/>
	 * @param modele
	 * @return 
	 */
	@RequestMapping(name="/client/getAllClient", method=RequestMethod.GET)
	public String listeClientsBdd (ModelMap modele) {
		
		//Définir les données à renvoyer vers la vue (liste des clients de la bdd)
		
		List<Client> listeClientsBdd = clientService.findAllClientsService();
		
		modele.addAttribute("allClients",listeClientsBdd);
		
		// Retourner la clé permettant l'accés à la page
		
		
		
		return "clients";
	}
	
	/**
	 * Suppression d'un client dans la bdd <br/>
	 * 
	 * @return 
	 */
	@RequestMapping(value= {"/client/delete/{clientId}"},						
							method = RequestMethod.GET)
	public String supprimerClientBdd(@PathVariable("clientId") int pIdClient,ModelMap model) {
		
		//1.suppression du client de la bdd
		
		clientService.supprimerClientService(pIdClient);
		
		//2.Recup de la nouvelle liste des clients dans la bdd
		
		List<Client> newListClientsBdd = clientService.findAllClientsService();
		
		model.addAttribute("allClients",newListClientsBdd);
		
		// redirection avec le prefix 'redirect'
		return "redirect:/client/getAllClient";
	}
	
	/**
	 *	Ajout d'un client <br/>
	 * 	réalisé en 2 temps: 
	 * 				1/ 	Afficher le formulaire
	 * 				2/	Soumettre le formulaire
	 */
	
	/**
	 *  1/	Affiche le formulaire d'ajout d'un client dans la bdd <br/>
	 */
	
	@RequestMapping(value="/client/form/ajouter",method=RequestMethod.GET)
	public ModelAndView setUpFormulaire () {
		
		//1. Données à retourner vers la vue
		
		//1.1. Def du model = objet de commande
		Client client = new Client();
		
		Map<String,Object> data = new HashMap<>();
		data.put("clientCommand",client);
		
		//2. Nom logique de la vue
		
		String viewName = "ajouterClient";
		
		return new ModelAndView(viewName,data);
	}
	
	/**
	 * 2/ Ajout d'un client dans la bdd à la soumission du formulaire
	 * @return
	 */
	@RequestMapping(value="/client/ajouter",method=RequestMethod.POST)
	public String addClientBdd(@ModelAttribute("clientCommand") Client pClient,ModelMap model) {
		
		// 1. ajout du client à la bdd
		clientService.ajouterClientService(pClient);
		
		//2. Affichage de la nouvelle liste des clients de la bdd (recup + envoi)
		
		model.addAttribute("allClients",clientService.findAllClientsService());
		
		
		return "redirect:/client/getAllClient";
	}
	
	/**
	 * affiche le formulaire pour la modif en réponse à une requete 
	 * en GET suit au click sur le lien Modifier de clients.jsp <br/>
	 * @return
	 */
	@RequestMapping(value="/client/form/modifier*", method=RequestMethod.GET)
	public ModelAndView setUpFormulaireUpdate(@RequestParam("clientId") int pIdClient) {
		
		// recup de l'employé a MAJ dans la bdd 
		Client clientMAJ = clientService.findClientServiceById(pIdClient);
		
		// def d'un objet de commande + def d'un nom de vue + renvoi 
		/**
		 * >> modifierClient = nom logique de la vue
		 */
		return new ModelAndView("modifierClient","clientUpCommand",clientMAJ);
		
	}
	
	
	/**
	 * permet de modifier un client dans la bdd <br/>
	 * a la soumission du formulaire de modifierClient.jsp
	 * @return
	 */
	@RequestMapping(value="/client/modifier", method=RequestMethod.POST)
	public String updateClientBdd(@ModelAttribute("clientUpCommand") Client pClient, ModelMap modele) {
		
		// 1. modif du client dans la bdd 
		clientService.modifierClientService(pClient);
		
		// 2. recup de la nouvelle liste des clients dans la bdd + renvoi de la liste vers la vue 
		modele.addAttribute("allClients", clientService.findAllClientsService());
		
		// 3. redirection vers l'url '/getAllClient' => clients.jsp
		return "redirect:/client/getAllClient"; 
		
	}
	
	
	
}
