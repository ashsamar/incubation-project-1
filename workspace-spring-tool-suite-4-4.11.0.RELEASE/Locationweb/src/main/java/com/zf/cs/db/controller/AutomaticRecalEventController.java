package com.zf.cs.db.controller;


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

import com.zf.cs.db.model.AutomaticRecalEvent;
import com.zf.cs.db.model.CargoDetEvent;
import com.zf.cs.repository.AutomaticRecalEventRepository;
import com.zf.cs.service.AutomaticRecalEventService;

@Controller
public class AutomaticRecalEventController {

	@Autowired
	private AutomaticRecalEventRepository repository;
	

	

	
	

	
	
	@RequestMapping("/displayOneAutomaticRecalDetEvent")
	public String updateObjet(@RequestParam("id")String receivedDate,ModelMap modekmap)
	{
		
		AutomaticRecalEvent object =	repository.findByReceivedDate(receivedDate);
	
	    modekmap.addAttribute("object",object);
		return "displayAutomaticRecalEvent";
	}
	
	
	@RequestMapping("/displayAllAutomaticRecalDetEvent")
	public String allAutomaticRecalEvent(ModelMap modekmap)
	{
		
		List<AutomaticRecalEvent> object =	repository.findAll();

	modekmap.addAttribute("allObjects",object);
	
		return "allAutomaticRecalEventDisplay";
	}
	
	
	
	
	
}
