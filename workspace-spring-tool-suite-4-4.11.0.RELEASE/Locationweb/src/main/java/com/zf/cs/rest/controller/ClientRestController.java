package com.zf.cs.rest.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

import com.zf.cs.db.model.CargoDetEvent;
import com.zf.cs.db.model.Client;
import com.zf.cs.db.model.ClientTrailerConfig;
import com.zf.cs.db.model.Event;
import com.zf.cs.repository.ClientRepository;
import com.zf.cs.repository.ClientTrailerConfigRepository;
import com.zf.cs.rest.model.CargoObject;
import com.zf.cs.rest.model.ClientTrailerConfigRest;
import com.zf.cs.service.ClientService;

@RestController
@RequestMapping("/clients")
public class ClientRestController {

	@Autowired
	private ClientRepository repos;
	
	@Autowired
	private ClientTrailerConfigRepository repository;
	
	@Autowired
	private ClientService service;
	
	
	
	
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
	public ClientTrailerConfig addClientCTrailerConfig(@RequestBody ClientTrailerConfigRest event)
	{
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd : HH:mm:ss");
		Date date = new Date();

		// 
		ClientTrailerConfig cargodetevent = new ClientTrailerConfig();
		cargodetevent.setReceiveddate(dateFormat.format(date));
		cargodetevent.setClientid(event.getClientid()) ;
		cargodetevent.setName(event.getName()) ;
		cargodetevent.setWidth(event.getWidth()) ;
		cargodetevent.setDepth(event.getDepth()) ;
		cargodetevent.setHeight(event.getHeight()) ;
		
		if((repos.findById(event.getClientid())) != null)
		{
			Client client1 = new Client();

				String trailerConfig = "Depth =:"+event.getDepth()+","+"Height = :"+event.getHeight()+","+"width= :"+event.getWidth();
			    client1.setId(event.getClientid());
			    client1.setName(event.getName());
			    client1.setTrailerconfig(trailerConfig);
				repos.save(client1);
			
		
		}
		else
		{
			Client client = new Client();
			String trailerConfig = "Depth =:"+event.getDepth()+","+"Height = :"+event.getHeight()+","+"width= :"+event.getWidth();
		    client.setName(event.getName());
		    client.setTrailerconfig(trailerConfig);
			repos.save(client);
		
		}
		
		
		
		return repository.save(cargodetevent);
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
