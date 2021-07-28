package com.hussain.location.entities;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Arrays;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name= "persondetevent")
public class PersonDetEvent {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	

	private Long clientid;   
	

	private String persondeteventtype; // removed, added, updated, in users guide its called id
	
	private Date receiveddate;
	
	private Timestamp timestamp; // in users guide its called "t"
	
	private float confidence;
	
//	private Position pos;
	private float x;
	private float y;
	private float z;
	
	private float height;
	
	@Lob
	@Basic(fetch = FetchType.LAZY)
	private byte[] image;
//	private File depthdata;
	
	
	@Lob
	@Basic(fetch = FetchType.LAZY)
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


	public float getX() {
		return x;
	}


	public void setX(float x) {
		this.x = x;
	}


	public float getY() {
		return y;
	}


	public void setY(float y) {
		this.y = y;
	}


	public float getZ() {
		return z;
	}


	public void setZ(float z) {
		this.z = z;
	}


	public float getHeight() {
		return height;
	}


	public void setHeight(float height) {
		this.height = height;
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
		return "PersonDetEvent [id=" + id + ", clientid=" + clientid + ", persondeteventtype=" + persondeteventtype
				+ ", receiveddate=" + receiveddate + ", timestamp=" + timestamp + ", confidence=" + confidence + ", x="
				+ x + ", y=" + y + ", z=" + z + ", height=" + height + ", image=" + Arrays.toString(image)
				+ ", pointcloud=" + Arrays.toString(pointcloud) + "]";
	}
	
	
	
	
}
