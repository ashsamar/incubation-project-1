package com.hussain.location.service;

import java.util.List;

import com.hussain.location.entities.Client;


public interface ClientService {

	
	Client saveClient(Client client);
	Client updateClient(Client client);
	void deleteClient(Client client);
	Client getClientById(Long id);
	List<Client> getAllClients();
}
