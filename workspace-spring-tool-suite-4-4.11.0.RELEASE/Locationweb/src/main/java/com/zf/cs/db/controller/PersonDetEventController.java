package com.zf.cs.db.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zf.cs.db.model.CargoDetEvent;
import com.zf.cs.db.model.DoorDetEvent;
import com.zf.cs.db.model.PersonDetEvent;
import com.zf.cs.repository.PersonDetEventRepository;
import com.zf.cs.service.PersonDetEventService;

@Controller
public class PersonDetEventController {

	@Autowired
	private PersonDetEventRepository repository;
	
	@Autowired
	private PersonDetEventService service;
	
	
	
	
	
	
	@RequestMapping("/displayOnePersonDetEvent")
	public String updateObjet(String receivedDate,ModelMap modekmap)
	{
		PersonDetEvent object =	repository.findByReceivedDate(receivedDate);
		//	AutomaticRecalEvent object =	service.getCargoDetecEventById(receiveddate);
		modekmap.addAttribute("object",object);
		return "displayPersonDetEvent";
	}
	
	
	

	@RequestMapping("/displayAllPersonDetEvent")
	public String displayAllPersonDetEvent(ModelMap modekmap)
	{
	
	List<PersonDetEvent> object = repository.findAll();
		modekmap.addAttribute("allObjects",object);
		return "allPersonDetEventDisplay";
	}
	
	
	

	
	@RequestMapping("/displayPersonDetEventImage")
	public String displayCargoDetecEventImage(@RequestParam("id")Long id,ModelMap modelmap,
			HttpServletRequest request,HttpServletResponse response)
	{
		
		
	//	List<Objects>	allObjects = repository.findObjects(id);
		modelmap.addAttribute("clientId", id);
		System.out.println("till here");
	List<PersonDetEvent>	allObjects = service.getAllCargoDetecEvents();
	modelmap.addAttribute("allObjects",allObjects);
	
	byte[] image = service.getCargoDetecEventImageById(id);
	response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
	
	try {
		response.getOutputStream().write(image);
		response.getOutputStream().flush();
		response.getOutputStream().close();
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
		return "displayPersonDetEvent";
	}

	
	

	@RequestMapping("/displayPersonDetEventPointCloud")
	public ResponseEntity<ByteArrayResource> displayCargoDetecEventPointCloud(@RequestParam("id")Long id)
	{
		
		
		PersonDetEvent doc  = service.getCargoDetecEventById(id);
	
	return ResponseEntity.ok()
		//	.contentType(MediaType.parseMediaType("/doc.getCargoeventtype()"))
			.header(HttpHeaders.CONTENT_DISPOSITION,"attachment:filename=\""+doc.getPersondeteventtype()+"\"")
			.body(new ByteArrayResource(doc.getPointcloud()));
	
	}
	
	
	
	

	
	
	
	
}
