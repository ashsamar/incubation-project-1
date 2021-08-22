package com.zf.cs.rest.model;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Lob;

public class DoorDetEventRest {

	
    private Long id;
	

	private Long clientid;
	

	private String dooreventtype; // open, closed in users guide its called id
	

	private Date receiveddate;
	
	
	private Timestamp timestamp; // in users guide its called "t"
	

	private int door; // in users guide is called door
	

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




	public String getDooreventtype() {
		return dooreventtype;
	}




	public void setDooreventtype(String dooreventtype) {
		this.dooreventtype = dooreventtype;
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




	public int getDoor() {
		return door;
	}




	public void setDoor(int door) {
		this.door = door;
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
		return "DoorDetEventRest [id=" + id + ", clientid=" + clientid + ", dooreventtype=" + dooreventtype
				+ ", receiveddate=" + receiveddate + ", timestamp=" + timestamp + ", door=" + door + ", confidence="
				+ confidence + ", image=" + Arrays.toString(image) + ", pointcloud=" + Arrays.toString(pointcloud)
				+ "]";
	}
	
	
	
	
}
