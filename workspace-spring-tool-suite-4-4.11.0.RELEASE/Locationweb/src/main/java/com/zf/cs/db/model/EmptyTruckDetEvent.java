package com.zf.cs.db.model;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Arrays;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "emptytruckdetevent")
public class EmptyTruckDetEvent {

	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	

	private Long clientid;   
	
   private String emptytruckdeteventtype; // empty or non empty, in users guide its called id
	
	private Date receiveddate;
	
	private Timestamp timestamp; // in users guide its called "t"
	

	private float confidence;
	
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


	public String getEmptytruckdeteventtype() {
		return emptytruckdeteventtype;
	}


	public void setEmptytruckdeteventtype(String emptytruckdeteventtype) {
		this.emptytruckdeteventtype = emptytruckdeteventtype;
	}


	@Override
	public String toString() {
		return "EmptyTruckDetEvent [id=" + id + ", clientid=" + clientid + ", emptytruckdeteventtype="
				+ emptytruckdeteventtype + ", receiveddate=" + receiveddate + ", timestamp=" + timestamp
				+ ", confidence=" + confidence + ", image=" + Arrays.toString(image) + ", pointcloud="
				+ Arrays.toString(pointcloud) + "]";
	}


	
	
	
	
}
