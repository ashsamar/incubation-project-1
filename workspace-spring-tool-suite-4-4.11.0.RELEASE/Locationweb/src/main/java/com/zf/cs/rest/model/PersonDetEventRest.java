package com.zf.cs.rest.model;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Embedded;
import javax.persistence.FetchType;
import javax.persistence.Lob;

public class PersonDetEventRest {

	
	
	
    private Long id;
	

	private Long clientid;   
	

	private String persondeteventtype; // removed, added, updated, in users guide its called id
	
	private String receiveddate;
	
	private Timestamp timestamp; // in users guide its called "t"
	
	@Embedded
	public PersonConfig personConfig;
	
//	private float confidence;
//	
//
//	private float x;
//	private float y;
//	private float z;
//	
//	private float height;
//	

	private byte[] image;


	private byte[] pointcloud;


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


	public String getPersondeteventtype() {
		return persondeteventtype;
	}


	public void setPersondeteventtype(String persondeteventtype) {
		this.persondeteventtype = persondeteventtype;
	}


	public String getReceiveddate() {
		return receiveddate;
	}


	public void setReceiveddate(String receiveddate) {
		this.receiveddate = receiveddate;
	}


	public Timestamp getTimestamp() {
		return timestamp;
	}


	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}


	

	public byte[] getImage() {
		return image;
	}


	public void setImage(byte[] image) {
		this.image = image;
	}


	public byte[] getPointcloud() {
		return pointcloud;
	}


	public void setPointcloud(byte[] pointcloud) {
		this.pointcloud = pointcloud;
	}


	public PersonConfig getPersonConfig() {
		return personConfig;
	}


	public void setPersonConfig(PersonConfig personConfig) {
		this.personConfig = personConfig;
	}


	@Override
	public String toString() {
		return "PersonDetEventRest [id=" + id + ", clientid=" + clientid + ", persondeteventtype=" + persondeteventtype
				+ ", receiveddate=" + receiveddate + ", timestamp=" + timestamp + ", personConfig=" + personConfig
				+ ", image=" + Arrays.toString(image) + ", pointcloud=" + Arrays.toString(pointcloud) + "]";
	}


	

	
	
}
