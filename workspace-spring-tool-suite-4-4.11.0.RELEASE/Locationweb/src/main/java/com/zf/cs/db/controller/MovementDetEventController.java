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

import com.zf.cs.db.model.CargoDetEvent;
import com.zf.cs.db.model.MovementDetEvent;
import com.zf.cs.repository.CargoDetecEventRepository;
import com.zf.cs.repository.MovementDetEventRepository;
import com.zf.cs.service.CargoDetecEventService;
import com.zf.cs.service.MovementDetEventService;
import com.zf.cs.util.ReportUtil;

@Controller
public class MovementDetEventController {

	
	@Autowired
	private MovementDetEventService service;
	
	@Autowired
	private MovementDetEventRepository repository;
	
	@Autowired
	private ReportUtil reportUtil;
	
	@Autowired
	private ServletContext servletContext;
	

	
	
	

	@RequestMapping("/displayOneMovementDetEvent")
	public String updateObjet(@RequestParam("id")String receivedDate,ModelMap modekmap)
	{
		MovementDetEvent object =	repository.findByReceivedDate(receivedDate);
	modekmap.addAttribute("object", object);
		return "displayMovementDetEvent";
	}
	
	
	@RequestMapping("/displayAllMovementDetEvent")
	public String allMovementDetEvent(ModelMap modekmap)
	{
		List<MovementDetEvent> object =	repository.findAll();
	modekmap.addAttribute("allObjects", object);
	
	
		return "allMovementDetEventDisplay";
	}
	
	
	
	
	
	@RequestMapping("/displayMovementDetEventImage")
	public String displayCargoDetecEventImage(@RequestParam("id")Long id,ModelMap modelmap,
			HttpServletRequest request,HttpServletResponse response)
	{
		
		
	//	List<Objects>	allObjects = repository.findObjects(id);
		modelmap.addAttribute("clientId", id);
		System.out.println("till here");
	List<MovementDetEvent>	allObjects = service.getAllCargoDetecEvents();
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
	
		return "displayMovementDetEvent";
	}

	
	

	@RequestMapping("/displayMovementDetEventPointCloud")
	public ResponseEntity<ByteArrayResource> displayCargoDetecEventPointCloud(@RequestParam("id")Long id)
	{
		
		
		MovementDetEvent doc  = service.getCargoDetecEventById(id);
	
	return ResponseEntity.ok()
		//	.contentType(MediaType.parseMediaType("/doc.getCargoeventtype()"))
			.header(HttpHeaders.CONTENT_DISPOSITION,"attachment:filename=\""+doc.getMovementeventtype()+"\"")
			.body(new ByteArrayResource(doc.getPointcloud()));
	
	}
	
	
	
	
	
	
	
	
	
	
	


	
	
}
