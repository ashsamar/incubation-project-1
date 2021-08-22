package com.zf.cs.rest.model;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.FetchType;
import javax.persistence.Lob;

public class MovementDetEventRest {

	
	
	
    private Long id;
	

	private Long clientid;   
	
//	@Column(name = "eachmovementeventid")
//	private String eachmovementeventid; // in users guide is called id


	private String movementeventtype; // removed, added, updated, in users guide its called id
	
	private String receiveddate;
	
	private Timestamp timestamp; // in users guide its called "t"
	

	@Embedded
	private MovementVolume movementVolume;
//	private float confidence;
//	
//	//Position 
//	private float x;
//	private float y;
//	private float z;
//	
//	//Size?
//	private float width;
//	private float depth;
//	private float height;
//	
//	
	

	private byte[] image;
//	private File depthdata;
	

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


	

	public String getMovementeventtype() {
		return movementeventtype;
	}


	public void setMovementeventtype(String movementeventtype) {
		this.movementeventtype = movementeventtype;
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


	public MovementVolume getMovementVolume() {
		return movementVolume;
	}


	public void setMovementVolume(MovementVolume movementVolume) {
		this.movementVolume = movementVolume;
	}


	@Override
	public String toString() {
		return "MovementDetEventRest [id=" + id + ", clientid=" + clientid + ", movementeventtype=" + movementeventtype
				+ ", receiveddate=" + receiveddate + ", timestamp=" + timestamp + ", movementVolume=" + movementVolume
				+ ", image=" + Arrays.toString(image) + ", pointcloud=" + Arrays.toString(pointcloud) + "]";
	}





	
	
	
	
}
