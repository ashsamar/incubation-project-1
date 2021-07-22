package com.hussain.location.entities;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "doordetevent")
public class DoorDetEvent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long clientid;
	
	private String dooreventtype; // open, closed in users guide its called id
	
	private Date receiveddate;
	
	 private Timestamp timestamp; // in users guide its called "t"
	
	private int door; // in users guide is called door
	
	private float confidence;

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

	@Override
	public String toString() {
		return "DoorDetEvent [id=" + id + ", clientid=" + clientid + ", dooreventtype=" + dooreventtype
				+ ", receiveddate=" + receiveddate + ", timestamp=" + timestamp + ", door=" + door + ", confidence="
				+ confidence + "]";
	}
	
	
	
}
