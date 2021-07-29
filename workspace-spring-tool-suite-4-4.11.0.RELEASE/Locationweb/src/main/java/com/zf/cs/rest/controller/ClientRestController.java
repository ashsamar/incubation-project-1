package com.zf.cs.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zf.cs.db.model.Client;
import com.zf.cs.repository.ClientRepository;

@RestController
@RequestMapping("/clients")
public class ClientRestController {

	@Autowired
	private ClientRepository repos;
	
	
	@GetMapping("/{id}")
	public Optional<Client> getClient(@PathVariable("id") Long  id)
	{
	     return repos.findById(id);
		 
	}
	
	
	
	@GetMapping
	public List<Client> allClients()
	{
		
		return repos.findAll();
		
	}
	
	@PostMapping
	public Client addClient(@RequestBody Client client)
	{
		return repos.save(client);
	}
	
	
	@PutMapping
	public Client updateClient(@RequestBody Client client)
	{
		return repos.save(client);
	}
	
	@DeleteMapping("/{id}")
	public void deleteClient(@PathVariable("id") Long  id)
	{
		 repos.deleteById(id);
	}
}
