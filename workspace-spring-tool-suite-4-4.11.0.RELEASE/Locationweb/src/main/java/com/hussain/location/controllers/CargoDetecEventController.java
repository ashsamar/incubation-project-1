package com.hussain.location.controllers;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.print.Doc;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.jsf.FacesContextUtils;

import com.hussain.location.entities.CargoDetEvent;


import com.hussain.location.repos.CargoDetecEventRepository;

import com.hussain.location.service.CargoDetecEventService;
import com.hussain.location.util.ReportUtil;

@Controller
public class CargoDetecEventController {
	
	@Autowired
	private CargoDetecEventService service;
	
	@Autowired
	private CargoDetecEventRepository repository;
	
	@Autowired
	private ReportUtil reportUtil;
	
	@Autowired
	private ServletContext servletContext;
	
	
	
	

	@RequestMapping("/showCreateCargoDetecEvent")
	public String showCreate()
	{
		return "CreateCargoDetecEvent";
	}
	
	@RequestMapping("/saveCargoDetecEvent")
	public String saveCargoDetecEvent(@ModelAttribute("cargoDetecEvent")CargoDetEvent object,ModelMap modelmap)
	{
		
		CargoDetEvent savedObject = service.saveCargoDetecEvent(object);
		
	//	String msg = "succesfully saved with id: " +savedObject.getId();
		
	//	modelmap.addAttribute("msg", msg);
		
		return "CreateCargoDetecEvent";
	}
	
	@RequestMapping("/displayCargoDetecEvent")
	public String displayCargoDetecEvent(@RequestParam("id")Long id,ModelMap modelmap, HttpServletResponse response) throws 
	ServletException,SQLException
	{
		
	
	//	List<Event>	allEvents = repository.findEvents(id);
		modelmap.addAttribute("clientId", id);
	List<CargoDetEvent>	allObjects = service.getAllCargoDetecEvents();
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
	
	
	
		return "displayCargoDetecEvent";
	}
	
	

	@RequestMapping("/displayCargoDetecEvent1")
	public String displayCargoDetecEvent1(@RequestParam("id")Long id,ModelMap modelmap)
	{
		
		
	//	List<Objects>	allObjects = repository.findObjects(id);
		modelmap.addAttribute("clientId", id);
		System.out.println("till here");
	List<CargoDetEvent>	allObjects = service.getAllCargoDetecEvents();
	modelmap.addAttribute("allObjects",allObjects);
	
	
	
		return "displayCargoDetecEvent";
	}

	
	@RequestMapping("/displayCargoDetecEventImage")
	public String displayCargoDetecEventImage(@RequestParam("id")Long id,ModelMap modelmap,
			HttpServletRequest request,HttpServletResponse response)
	{
		
		
	//	List<Objects>	allObjects = repository.findObjects(id);
		modelmap.addAttribute("clientId", id);
		System.out.println("till here");
	List<CargoDetEvent>	allObjects = service.getAllCargoDetecEvents();
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
	
		return "displayCargoDetecEvent";
	}

	
	

	@RequestMapping("/displayCargoDetecEventPointCloud")
	public ResponseEntity<ByteArrayResource> displayCargoDetecEventPointCloud(@RequestParam("id")Long id)
	{
		
		
	CargoDetEvent doc  = service.getCargoDetecEventById(id);
	
	return ResponseEntity.ok()
		//	.contentType(MediaType.parseMediaType("/doc.getCargoeventtype()"))
			.header(HttpHeaders.CONTENT_DISPOSITION,"attachment:filename=\""+doc.getCargoeventtype()+"\"")
			.body(new ByteArrayResource(doc.getPointcloud()));
	
	}
	
	
	
	

	@RequestMapping("/deleteCargoDetecEvent")
	public String deleteObject(@RequestParam("id")Long id,ModelMap modelmap)
	{
		CargoDetEvent object = service.getCargoDetecEventById(id);
		
		service.deleteCargoDetecEvent(object);
		
		
		List<CargoDetEvent>	allObjects = service.getAllCargoDetecEvents();
		modelmap.addAttribute("allCargoDetecEvents",allObjects);
		return "displayCargoDetecEvents";
	}
	
	@RequestMapping("/showUpdateCargoDetecEvent")
	public String updateObjet(@RequestParam("id")Long id,ModelMap modekmap)
	{
		CargoDetEvent object =	service.getCargoDetecEventById(id);
	modekmap.addAttribute("object", object);
		return "updateCargoDetecEvent";
	}
	
	@RequestMapping("/updatedCargoDetecEvent")
	public String updatedObject(@ModelAttribute("object")CargoDetEvent object,ModelMap modelmap)
	{
		
		service.updateCargoDetecEvent(object);
		
		
		List<CargoDetEvent>	allObjects = service.getAllCargoDetecEvents();
		modelmap.addAttribute("allCargoDetecEvents",allObjects);
		return "displayCargoDetecEvents";
	}
	

}
