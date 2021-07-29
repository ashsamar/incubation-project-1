package com.zf.cs.db.controller;

import java.util.List;

import javax.servlet.ServletContext;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zf.cs.db.model.Location;
import com.zf.cs.repository.LocationRepository;
import com.zf.cs.service.LocationService;
import com.zf.cs.util.ReportUtil;

@Controller
public class LocationController {
	
	@Autowired
	private LocationService service;
	
	@Autowired
	private LocationRepository repository;
	
	@Autowired
	private ReportUtil reportUtil;
	
	@Autowired
	private ServletContext servletContext;
	

	@RequestMapping("/showCreate")
	public String showCreate()
	{
		return "CreateLocation";
	}
	
	@RequestMapping("/saveLocation")
	public String saveLocation(@ModelAttribute("location")Location location,ModelMap modelmap)
	{
		
		Location savedLocation = service.saveLocation(location);
		
		String msg = "succesfully saved with id" +savedLocation.getId();
		
		modelmap.addAttribute("msg", msg);
		
		return "CreateLocation";
	}
	
	@RequestMapping("/displayLocations")
	public String displayLocations(ModelMap modelmap)
	{
	List<Location>	allLocations = service.getAllLocations();
	modelmap.addAttribute("allLocations",allLocations);
	
		return "displayLocations";
	}


	@RequestMapping("/deleteLocation")
	public String deleteLocation(@RequestParam("id")int id,ModelMap modelmap)
	{
		Location location = service.getLocationById(id);
		
		service.deleteLocation(location);
		
		
		List<Location>	allLocations = service.getAllLocations();
		modelmap.addAttribute("allLocations",allLocations);
		return "displayLocations";
	}
	
	@RequestMapping("/showUpdate")
	public String updateLocation(@RequestParam("id")int id,ModelMap modekmap)
	{
	Location location =	service.getLocationById(id);
	modekmap.addAttribute("location", location);
		return "updateLocation";
	}
	
	@RequestMapping("/updatedLocation")
	public String updatedLocation(@ModelAttribute("location") Location location,ModelMap modelmap)
	{
		
		service.updateLocation(location);
		
		
		List<Location>	allLocations = service.getAllLocations();
		modelmap.addAttribute("allLocations",allLocations);
		return "displayLocations";
	}
	
	@RequestMapping("/generateReport")
	public String generateReport()
	{
		
		String path = servletContext.getRealPath("/");
		List<Object[]> data = repository.findTypeAndTypeCount();
		reportUtil.generatePieChart(path, data);
		
		return "report";
	}
	
}
