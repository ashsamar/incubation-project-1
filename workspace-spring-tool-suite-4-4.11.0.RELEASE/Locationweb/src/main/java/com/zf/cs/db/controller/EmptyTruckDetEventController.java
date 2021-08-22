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
import com.zf.cs.db.model.EmptyTruckDetEvent;
import com.zf.cs.repository.EmptyTruckDetEventRepository;
import com.zf.cs.service.EmptyTruckDetEventService;

@Controller
public class EmptyTruckDetEventController {

	@Autowired
	private EmptyTruckDetEventRepository repository;
	
	@Autowired
	private EmptyTruckDetEventService service;
	
	
	
	
	@RequestMapping("/displayOneEmptyTruckDetEvent")
	public String updateObjet(String receivedDate,ModelMap modekmap)
	{
		
		EmptyTruckDetEvent object =	repository.findByReceivedDate(receivedDate);
	//	AutomaticRecalEvent object =	service.getCargoDetecEventById(receiveddate);
	modekmap.addAttribute("object",object);
		return "displayEmptyTruckDetEvent";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping("/displayEmptyTruckDetEvent")
	public String displayCargoDetecEvent(@RequestParam("id")Long id,ModelMap modelmap, HttpServletResponse response) throws 
	ServletException,SQLException
	{
		
	
	//	List<Event>	allEvents = repository.findEvents(id);
		modelmap.addAttribute("clientId", id);
	List<EmptyTruckDetEvent>	allObjects = service.getAllCargoDetecEvents();
	modelmap.addAttribute("allObjects",allObjects);
	
	
		return "displayEmptyTruckDetEvent";
	}
	
	

	@RequestMapping("/displayEmptyTruckDetEvent1")
	public String displayEmptyTruckDetEvent1(ModelMap modelmap)
	{
		
		
	//	List<Objects>	allObjects = repository.findObjects(id);
	//	modelmap.addAttribute("clientId", id);
		System.out.println("till here");
	List<EmptyTruckDetEvent>	allObjects = service.getAllCargoDetecEvents();
	modelmap.addAttribute("allObjects",allObjects);
	
	
	
		return "allEmptyTruckDetEventDisplay";
	}

	
	@RequestMapping("/displayEmptyTruckDetEventImage")
	public String displayEmptyTruckDetEventImage(@RequestParam("id")Long id,ModelMap modelmap,
			HttpServletRequest request,HttpServletResponse response)
	{
		
		
	//	List<Objects>	allObjects = repository.findObjects(id);
		modelmap.addAttribute("clientId", id);
		System.out.println("till here");
	List<EmptyTruckDetEvent>	allObjects = service.getAllCargoDetecEvents();
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
	
		return "displayEmptyTruckDetEvent";
	}

	
	

	@RequestMapping("/displayEmptyTruckDetEventPointCloud")
	public ResponseEntity<ByteArrayResource> displayEmptyTruckDetEventPointCloud(@RequestParam("id")Long id)
	{
		
		
		EmptyTruckDetEvent doc  = service.getCargoDetecEventById(id);
	
	return ResponseEntity.ok()
		//	.contentType(MediaType.parseMediaType("/doc.getCargoeventtype()"))
			.header(HttpHeaders.CONTENT_DISPOSITION,"attachment:filename=\""+doc.getEmptytruckdeteventtype()+"\"")
			.body(new ByteArrayResource(doc.getPointcloud()));
	
	}
	
	
	
}
