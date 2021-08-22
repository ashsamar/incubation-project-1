package com.zf.cs.db.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
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

import com.zf.cs.db.model.AutomaticRecalEvent;
import com.zf.cs.db.model.CargoDetEvent;
import com.zf.cs.db.model.DoorDetEvent;
import com.zf.cs.repository.CargoDetecEventRepository;
import com.zf.cs.repository.DoorDetEventRepository;
import com.zf.cs.service.CargoDetecEventService;
import com.zf.cs.service.DoorDetEventService;
import com.zf.cs.util.ReportUtil;

@Controller
public class DoorDetEventController {

	
	
	@Autowired
	private DoorDetEventService service;
	
	@Autowired
	private DoorDetEventRepository repository;
	
	@Autowired
	private ReportUtil reportUtil;
	
	@Autowired
	private ServletContext servletContext;
	

	
	@RequestMapping("/displayDoorDetEvent")
	public String displayCargoDetecEvent(@RequestParam("id")Long id,ModelMap modelmap)
	{
		
		
	//	List<Event>	allEvents = repository.findEvents(id);
		modelmap.addAttribute("clientId", id);
	List<DoorDetEvent>	allObjects = service.getAllCargoDetecEvents();
	modelmap.addAttribute("allObjects",allObjects);
	
		return "displayDoorDetEvent";
	}
	
	

	@RequestMapping("/displayDoorDetEvent1")
	public String displayCargoDetecEvent1(ModelMap modelmap)
	{
		
		
	//	List<Objects>	allObjects = repository.findObjects(id);
		
	//	modelmap.addAttribute("clientId", id);
		System.out.println("till here");
	List<DoorDetEvent>	allObjects = service.getAllCargoDetecEvents();
	modelmap.addAttribute("allDoorDetEvent",allObjects);
	
	
	
		return "allDoorDetEventDisplay";
	}
	
	
	
	
	
	@RequestMapping("/displayDoorDetEventImage")
	public String displayCargoDetecEventImage(@RequestParam("id")Long id,ModelMap modelmap,
			HttpServletRequest request,HttpServletResponse response)
	{
		
		
	//	List<Objects>	allObjects = repository.findObjects(id);
		modelmap.addAttribute("clientId", id);
		System.out.println("till here");
	List<DoorDetEvent>	allObjects = service.getAllCargoDetecEvents();
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
	
		return "displayDoorDetEvent";
	}

	
	

	@RequestMapping("/displayDoorDetEventPointCloud")
	public ResponseEntity<ByteArrayResource> displayCargoDetecEventPointCloud(@RequestParam("id")Long id)
	{
		
		
		DoorDetEvent doc  = service.getCargoDetecEventById(id);
	
	return ResponseEntity.ok()
		//	.contentType(MediaType.parseMediaType("/doc.getCargoeventtype()"))
			.header(HttpHeaders.CONTENT_DISPOSITION,"attachment:filename=\""+doc.getDooreventtype()+"\"")
			.body(new ByteArrayResource(doc.getPointcloud()));
	
	}
	
	@RequestMapping("/displayOneDoorDetEvent")
	public String updateObjet(@RequestParam("id")String receivedDate,ModelMap modekmap)
	{
		
		DoorDetEvent object =	repository.findByReceivedDate(receivedDate);
	//	AutomaticRecalEvent object =	service.getCargoDetecEventById(receiveddate);
	modekmap.addAttribute("object",object);
		return "displayDoorDetEvent";
	}
	
}
