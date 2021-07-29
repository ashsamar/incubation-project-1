package com.zf.cs.service;

import java.util.List;

import com.zf.cs.db.model.Client;


public interface ClientService {

	
	Client saveClient(Client client);
	Client updateClient(Client client);
	void deleteClient(Client client);
	Client getClientById(Long id);
	List<Client> getAllClients();
}
