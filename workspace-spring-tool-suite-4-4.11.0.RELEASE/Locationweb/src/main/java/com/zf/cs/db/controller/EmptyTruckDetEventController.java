package com.zf.cs.db.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zf.cs.db.model.CargoDetEvent;
import com.zf.cs.db.model.EmptyTruckDetEvent;
import com.zf.cs.repository.EmptyTruckDetEventRepository;
import com.zf.cs.service.EmptyTruckDetEventService;

@Controller
public class EmptyTruckDetEventController {

	@Autowired
	private EmptyTruckDetEventRepository repository;
	
	@Autowired
	private EmptyTruckDetEventService service;
	
	
	
	
	
	@RequestMapping("/showCreateEmptyTruckDetEvent")
	public String showCreate()
	{
		return "CreateCEmptyTruckDetEvent";
	}
	
	@RequestMapping("/saveEmptyTruckDetEvent")
	public String saveCargoDetecEvent(@ModelAttribute("emptyTruckDetEvent")EmptyTruckDetEvent object,ModelMap modelmap)
	{
		
		EmptyTruckDetEvent savedObject = service.saveCargoDetecEvent(object);
		
	//	String msg = "succesfully saved with id: " +savedObject.getId();
		
	//	modelmap.addAttribute("msg", msg);
		
		return "CreateEmptyTruckDetEvent";
	}
	
	@RequestMapping("/displayEmptyTruckDetEvent")
	public String displayCargoDetecEvent(@RequestParam("id")Long id,ModelMap modelmap, HttpServletResponse response) throws 
	ServletException,SQLException
	{
		
	
	//	List<Event>	allEvents = repository.findEvents(id);
		modelmap.addAttribute("clientId", id);
	List<EmptyTruckDetEvent>	allObjects = service.getAllCargoDetecEvents();
	modelmap.addAttribute("allObjects",allObjects);
	
//	byte[] image = service.getCargoDetecEventImageById(id);
//	response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
//	
//	try {
//		response.getOutputStream().write(image);
//		response.getOutputStream().flush();
//		response.getOutputStream().close();
//	} catch (IOException e1) {
//		// TODO Auto-generated catch block
//		e1.printStackTrace();
//	}
//	
//	try {
//		ServletOutputStream outputStream = response.getOutputStream();
//		
//		outputStream.write(image);
//	//	outputStream.flush();
//		outputStream.close();
//		
//	} catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}

//	modelmap.addAttribute("image",image);
	
	
	
		return "displayEmptyTruckDetEvent";
	}
	
	

	@RequestMapping("/displayEmptyTruckDetEvent1")
	public String displayEmptyTruckDetEvent1(@RequestParam("id")Long id,ModelMap modelmap)
	{
		
		
	//	List<Objects>	allObjects = repository.findObjects(id);
		modelmap.addAttribute("clientId", id);
		System.out.println("till here");
	List<EmptyTruckDetEvent>	allObjects = service.getAllCargoDetecEvents();
	modelmap.addAttribute("allObjects",allObjects);
	
	
	
		return "displayEmptyTruckDetEvent";
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
	
	
	
	

	@RequestMapping("/deleteEmptyTruckDetEvent")
	public String deleteObject(@RequestParam("id")Long id,ModelMap modelmap)
	{
		EmptyTruckDetEvent object = service.getCargoDetecEventById(id);
		
		service.deleteCargoDetecEvent(object);
		
		
		List<EmptyTruckDetEvent>	allObjects = service.getAllCargoDetecEvents();
		modelmap.addAttribute("allCargoDetecEvents",allObjects);
		return "displayEmptyTruckDetEvents";
	}
	
	@RequestMapping("/showUpdateEmptyTruckDetEvent")
	public String updateObjet(@RequestParam("id")Long id,ModelMap modekmap)
	{
		EmptyTruckDetEvent object =	service.getCargoDetecEventById(id);
	modekmap.addAttribute("object", object);
		return "updateEmptyTruckDetEvent";
	}
	
	@RequestMapping("/updatedEmptyTruckDetEvent")
	public String updatedObject(@ModelAttribute("object")EmptyTruckDetEvent object,ModelMap modelmap)
	{
		
		service.updateCargoDetecEvent(object);
		
		
		List<EmptyTruckDetEvent>	allObjects = service.getAllCargoDetecEvents();
		modelmap.addAttribute("allCargoDetecEvents",allObjects);
		return "displayEmptyTruckDetEvents";
	}
	
}
