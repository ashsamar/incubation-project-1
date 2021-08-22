package com.zf.cs.db.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zf.cs.db.model.AutomaticRecalEvent;
import com.zf.cs.db.model.NonOperatingDetEvent;
import com.zf.cs.repository.NonOperatingDetEventRepsitory;

@Controller
public class NonOperatingDetEventController {

	
	@Autowired
	private NonOperatingDetEventRepsitory repository;
	
	
	
	@RequestMapping("/displayOneNonOperatingDetEvent")
	public String updateObjet(String receivedDate,ModelMap modekmap)
	{
		
		NonOperatingDetEvent object =	repository.findByReceivedDate(receivedDate);
	//	AutomaticRecalEvent object =	service.getCargoDetecEventById(receiveddate);
	modekmap.addAttribute("object",object);
		return "nonOpratingDetEventDisplay";
	}
	
	
	
	

	@RequestMapping("/displayAllNonOperatingDetEvent")
	public String allNonOperatingEvent(ModelMap modekmap)
	{
		
		List<NonOperatingDetEvent> object =	repository.findAll();

	modekmap.addAttribute("allObjects",object);
	
		return "allNonOperatingDetEventDisplay";
	}
}
