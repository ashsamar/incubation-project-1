package com.hussain.location.entities;


import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToOne;

@Entity
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String eventsid;
	
    
	private Long clientid;

	private Date date;
	
	private Timestamp timestamp;

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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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

	@Override
	public String toString() {
		return "Event [id=" + id + ", eventsid=" + eventsid + ", clientid=" + clientid + ", date=" + date
				+ ", timestamp=" + timestamp + "]";
	}
	
	
}
