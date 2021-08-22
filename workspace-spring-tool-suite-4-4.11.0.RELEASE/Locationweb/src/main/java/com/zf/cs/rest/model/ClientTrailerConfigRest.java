package com.zf.cs.rest.model;

import java.util.Date;

public class ClientTrailerConfigRest {

	
	private Long id;

	private Long clientid;

	
	private String name;

	private Date receiveddate;
	
	private float width;
	
	private float depth;
	
	private float height;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public float getDepth() {
		return depth;
	}

	public void setDepth(float depth) {
		this.depth = depth;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public Date getReceiveddate() {
		return receiveddate;
	}

	public void setReceiveddate(Date receiveddate) {
		this.receiveddate = receiveddate;
	}

	@Override
	public String toString() {
		return "ClientTrailerConfigRest [id=" + id + ", clientid=" + clientid + ", name=" + name + ", receiveddate="
				+ receiveddate + ", width=" + width + ", depth=" + depth + ", height=" + height + "]";
	}

	
	
	
}
