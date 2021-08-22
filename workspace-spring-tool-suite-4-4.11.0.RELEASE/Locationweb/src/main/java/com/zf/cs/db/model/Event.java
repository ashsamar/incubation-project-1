package com.zf.cs.db.model;



import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String eventsid;
	
    
	private Long clientid;

	
	private String receiveddate;
	
	private Timestamp timestamp;
	
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

	public String getEventsid() {
		return eventsid;
	}

	public void setEventsid(String eventsid) {
		this.eventsid = eventsid;
	}


	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	
	public Long getClientid() {
		return clientid;
	}

	public void setClientid(Long clientid) {
		this.clientid = clientid;
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

	public String getReceiveddate() {
		return receiveddate;
	}

	public void setReceiveddate(String receiveddate) {
		this.receiveddate = receiveddate;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", eventsid=" + eventsid + ", clientid=" + clientid + ", receiveddate="
				+ receiveddate + ", timestamp=" + timestamp + ", image=" + Arrays.toString(image) + ", pointcloud="
				+ Arrays.toString(pointcloud) + "]";
	}



	
	
	
	
}
