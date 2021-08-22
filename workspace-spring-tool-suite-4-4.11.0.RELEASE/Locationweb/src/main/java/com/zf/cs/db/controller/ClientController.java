package com.zf.cs.db.controller;

import java.util.List;

import javax.servlet.ServletContext;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zf.cs.db.model.Client;
import com.zf.cs.db.model.ClientTrailerConfig;
import com.zf.cs.repository.ClientRepository;
import com.zf.cs.repository.ClientTrailerConfigRepository;
import com.zf.cs.service.ClientService;
import com.zf.cs.util.ReportUtil;


@Controller
public class ClientController {
	
	@Autowired
	private ClientService service;
	
	@Autowired
	private ClientRepository repository;
	
	@Autowired
	private ClientTrailerConfigRepository repos;
	

	

	@RequestMapping("/showCreateClient")
	public String showCreate()
	{
		return "createClient";
	}
	
	
	@RequestMapping("/displayClients")
	public String displayClient(ModelMap modelmap)
	{
		

		
	List<Client>	allClients = service.getAllClients();
	

//		
	    modelmap.addAttribute("allClients",allClients);
//	    modelmap.addAttribute("clientTrailerConfig",tmpTrailerConfig);
		return "displayClients";
	}



	@RequestMapping("/showUpdateClient")
	public String updateLocation(@RequestParam("id")Long id,ModelMap modekmap)
	{
		Client client =	service.getClientById(id);
	    modekmap.addAttribute("client", client);
		return "updateClient";
	}
	
	
	
	@RequestMapping("/updatedClient")
	public String updatedLocation(@ModelAttribute("client") Client client,ModelMap modelmap)
	{
		
		service.updateClient(client);
		
		
		List<Client>	allClients = service.getAllClients();
			    modelmap.addAttribute("allClients",allClients);
		return "displayClients";
	}
	

	
}
