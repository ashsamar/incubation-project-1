package com.zf.cs.db.controller;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.print.Doc;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.jsf.FacesContextUtils;

import com.zf.cs.db.model.AutomaticRecalEvent;
import com.zf.cs.db.model.CargoDetEvent;
import com.zf.cs.repository.CargoDetecEventRepository;
import com.zf.cs.service.CargoDetecEventService;
import com.zf.cs.util.ReportUtil;



@Controller
public class CargoDetecEventController {
	
	@Autowired
	private CargoDetecEventService service;
	
	@Autowired
	private CargoDetecEventRepository repository;
	

	
	


	@RequestMapping("/displayCargoDetecEvent")
	public String displayCargoDetecEvent1(ModelMap modelmap)
	{
		
		
	//	List<Objects>	allObjects = repository.findObjects(id);
	//	modelmap.addAttribute("clientId", id);
		System.out.println("till here");
	List<CargoDetEvent>	allObjects = service.getAllCargoDetecEvents();
	modelmap.addAttribute("allObjects",allObjects);
	
	
	
		return "allCargoDetEventDisplay";
	}
	
	
	
	public static byte[] decompressBytes(byte[] data) {
	    Inflater inflater = new Inflater();
	    inflater.setInput(data);
	    ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
	    byte[] buffer = new byte[1024];
	    try {
	        while (!inflater.finished()) {
	            int count = inflater.inflate(buffer);
	            outputStream.write(buffer, 0, count);
	        }
	        outputStream.close();
	    } catch (IOException ioe) {
	    } catch (DataFormatException e) {
	    }
	    return outputStream.toByteArray();
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
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
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
	
	
	
	
	@RequestMapping("/displayOneCargoDetEvent")
	public String updateObjet(@RequestParam("id")String receivedDate,ModelMap modekmap,HttpServletResponse response)
	{
		
		CargoDetEvent object =	repository.findByReceivedDate(receivedDate);
	//	CargoDetEvent object =	service.getCargoDetecEventById(id);
		
		
		String photoencodeBase64 = CargoDetEvent.convertBinImageToString(object.getImage());
	    modekmap.addAttribute("PHOTOYOUNEED", photoencodeBase64 );
	
//		try {
//			response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
//			response.getOutputStream().write(object.getImage());
//			response.getOutputStream().close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	
		
		
	modekmap.addAttribute("object", object);


	
		return "displayCargoDetecEvent";
	}
	


}
