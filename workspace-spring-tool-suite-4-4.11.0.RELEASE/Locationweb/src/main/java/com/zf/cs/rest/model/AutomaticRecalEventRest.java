package com.zf.cs.rest.model;

import java.sql.Timestamp;
import java.util.Date;

public class AutomaticRecalEventRest {

	
	
    private Long id;
	

	private Long clientid;   
	

	private String automaticrecaleventtype; // removed, added, updated, in users guide its called id
	
    private String receiveddate;
	
	private Timestamp timestamp; // in users guide its called "t"
	
	private float anglediff;
	
	private String  status;
	
	
	

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

	public String getAutomaticrecaleventtype() {
		return automaticrecaleventtype;
	}

	public void setAutomaticrecaleventtype(String automaticrecaleventtype) {
		this.automaticrecaleventtype = automaticrecaleventtype;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public float getAnglediff() {
		return anglediff;
	}

	public void setAnglediff(float anglediff) {
		this.anglediff = anglediff;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getReceiveddate() {
		return receiveddate;
	}

	public void setReceiveddate(String receiveddate) {
		this.receiveddate = receiveddate;
	}

	@Override
	public String toString() {
		return "AutomaticRecalEventRest [id=" + id + ", clientid=" + clientid + ", automaticrecaleventtype="
				+ automaticrecaleventtype + ", receiveddate=" + receiveddate + ", timestamp=" + timestamp
				+ ", anglediff=" + anglediff + ", status=" + status + "]";
	}


	

	
	
	
	
	
}
