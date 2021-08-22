package com.zf.cs.db.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zf.cs.db.model.MovedCargoDetEvent;
import com.zf.cs.db.model.MovementDetEvent;
import com.zf.cs.repository.MovedCargoDetEventRepository;
import com.zf.cs.service.MovementDetEventService;

@Controller
public class MovedCargoDetEventController {

	@Autowired
	private MovementDetEventService service;
	
	@Autowired
	private MovedCargoDetEventRepository repository;
	
	
	
	
	@RequestMapping("/displayOneMovedCargoDetEvent")
	public String updateObjet(@RequestParam("id")String receivedDate,ModelMap modekmap)
	{
		MovedCargoDetEvent object =	repository.findByReceivedDate(receivedDate);
		
		if(object.getNv_confidence() == 0 && object.getNv_depth() == 0 && object.getNv_height() == 0 && 
				object.getNv_width() == 0 && object.getNv_x() == 0 && object.getNv_y() == 0 && object.getNv_z()== 0)
		{
			 modekmap.addAttribute("object", object);
			 return "movedCargoNoNewVolumeDetEventDisplay";
		}
		
	    modekmap.addAttribute("object", object);
		return "movedCargoDetEventDisplay";
	}
	
	
	
	@RequestMapping("/displayAllMovedCargoDetEvent")
	public String allMovedCargoDetEvent(ModelMap modekmap)
	{
		List<MovedCargoDetEvent> object =	repository.findAll();
		
		
	    modekmap.addAttribute("allObjects", object);
	    
		return "allMovedCargoDetEventDisplay";
	}
	
	
	
	
	
	
	@RequestMapping("/displayMovedCargoDetEventImage")
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

	
	

	@RequestMapping("/displayMovedCargoDetEventPointCloud")
	public ResponseEntity<ByteArrayResource> displayCargoDetecEventPointCloud(@RequestParam("id")Long id)
	{
		
		
		MovementDetEvent doc  = service.getCargoDetecEventById(id);
	
	return ResponseEntity.ok()
		//	.contentType(MediaType.parseMediaType("/doc.getCargoeventtype()"))
			.header(HttpHeaders.CONTENT_DISPOSITION,"attachment:filename=\""+doc.getMovementeventtype()+"\"")
			.body(new ByteArrayResource(doc.getPointcloud()));
	
	}
	
	
	
	
}
