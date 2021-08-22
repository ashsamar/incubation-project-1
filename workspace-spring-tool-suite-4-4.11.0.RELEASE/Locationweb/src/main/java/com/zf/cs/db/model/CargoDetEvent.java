package com.zf.cs.db.model;

import java.sql.Blob;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;



@Entity
@Table(name = "cargodetevent")
public class CargoDetEvent extends AbstractEntity{

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	

	private Long clientid;   
	
	@Column(name = "eachcargoeventid")
	private String eachcargoeventid; // in users guide is called id


	private String cargoeventtype; // removed, added, updated, in users guide its called id
	
	
	private String receiveddate;
	
	private Timestamp timestamp; // in users guide its called "t"
	

	private float confidence;
	
//	private Position pos;
//	private float x;
//	private float y;
//	private float z;
	
//	private Size size;
//	private float width;
//	private float depth;
 //   private float height;
//	
//	//size_conf:
	private float sc_width;
	private float sc_depth;
	private float sc_height;
	
	@Lob
	@Basic(fetch = FetchType.LAZY)
	@Column(name = "image" ,length =Integer.MAX_VALUE) 
	private byte[] image;
//	private File depthdata;
	
	
	@Lob
	@Basic(fetch = FetchType.LAZY)
	private byte[] pointcloud;

	
	
	
	public static String convertBinImageToString(byte[] binImage) {
	    if(binImage!=null && binImage.length>0) {
	        return java.util.Base64.getEncoder().encodeToString(binImage);
	    }
	    else
	        return "";
	}
	
	
	
	
	
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getClientid() {
		return clientid;
	}
	public void setClientid(Long clientid) {
		this.clientid = clientid;
	}
	public String getEachcargoeventid() {
		return eachcargoeventid;
	}
	public void setEachcargoeventid(String eachcargoeventid) {
		this.eachcargoeventid = eachcargoeventid;
	}
	public String getCargoeventtype() {
		return cargoeventtype;
	}
	public void setCargoeventtype(String cargoeventtype) {
		this.cargoeventtype = cargoeventtype;
	}
	
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	public float getConfidence() {
		return confidence;
	}
	public void setConfidence(float confidence) {
		this.confidence = confidence;
	}
	public float getSc_width() {
		return sc_width;
	}
	public void setSc_width(float sc_width) {
		this.sc_width = sc_width;
	}
	public float getSc_depth() {
		return sc_depth;
	}
	public void setSc_depth(float sc_depth) {
		this.sc_depth = sc_depth;
	}
	public float getSc_height() {
		return sc_height;
	}
	public void setSc_height(float sc_height) {
		this.sc_height = sc_height;
	}
	
	public byte[] getImage() {
		return image;
	}
	public void setImg(byte[] image) {
		this.image = image;
	}
	
	public byte[] getPointcloud() {
		return pointcloud;
	}
	public void setPointcloud(byte[] pointcloud) {
		this.pointcloud = pointcloud;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}



	public String getReceiveddate() {
		return receiveddate;
	}


	public void setReceiveddate(String receiveddate) {
		this.receiveddate = receiveddate;
	}

	
	
	
	
}
