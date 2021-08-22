package com.zf.cs.rest.model;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.FetchType;
import javax.persistence.Lob;

public class EmptyTruckDetEventRest {

	
	
	
	
    private Long id;
	

	private Long clientid;   
	
    private String emptytruckdeteventtype; // empty or non empty, in users guide its called id
	
	private Date receiveddate;
	
	private Timestamp timestamp; // in users guide its called "t"
	

	private float confidence;
	

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



	public String getEmptytruckdeteventtype() {
		return emptytruckdeteventtype;
	}



	public void setEmptytruckdeteventtype(String emptytruckdeteventtype) {
		this.emptytruckdeteventtype = emptytruckdeteventtype;
	}



	public Date getReceiveddate() {
		return receiveddate;
	}



	public void setReceiveddate(Date receiveddate) {
		this.receiveddate = receiveddate;
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



	@Override
	public String toString() {
		return "EmptyTruckDetEventRest [id=" + id + ", clientid=" + clientid + ", emptytruckdeteventtype="
				+ emptytruckdeteventtype + ", receiveddate=" + receiveddate + ", timestamp=" + timestamp
				+ ", confidence=" + confidence + ", image=" + Arrays.toString(image) + ", pointcloud="
				+ Arrays.toString(pointcloud) + "]";
	}


	
	
}
