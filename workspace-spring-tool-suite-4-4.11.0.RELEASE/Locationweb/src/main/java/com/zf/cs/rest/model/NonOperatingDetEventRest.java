package com.zf.cs.rest.model;

import java.sql.Timestamp;

public class NonOperatingDetEventRest {

	
	private Long id;
	

	private Long clientid;   
	
	private String nonoperatingdeteventtype; // removed, added, updated, in users guide its called id
	
	private String receiveddate;
	
	private Timestamp timestamp; // in users guide its called "t"
	
	private int errorcode;
	
	private String errormsg;

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

	public String getNonoperatingdeteventtype() {
		return nonoperatingdeteventtype;
	}

	public void setNonoperatingdeteventtype(String nonoperatingdeteventtype) {
		this.nonoperatingdeteventtype = nonoperatingdeteventtype;
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

	public int getErrorcode() {
		return errorcode;
	}

	public void setErrorcode(int errorcode) {
		this.errorcode = errorcode;
	}

	public String getErrormsg() {
		return errormsg;
	}

	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}

	@Override
	public String toString() {
		return "NonOperatingDetEventRest [id=" + id + ", clientid=" + clientid + ", nonoperatingdeteventtype="
				+ nonoperatingdeteventtype + ", receiveddate=" + receiveddate + ", timestamp=" + timestamp
				+ ", errorcode=" + errorcode + ", errormsg=" + errormsg + "]";
	}
	
	
}
