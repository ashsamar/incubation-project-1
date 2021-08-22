
package com.zf.cs.rest.model;

import java.sql.Timestamp;
import java.util.Arrays;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

public class CargoDetEventRest {

	
	private Long id;
	

	private Long clientid;   
	
	@Embedded
	CargoObject cargoObject;

//	private String eachcargoeventid; // in users guide is called id


	private String cargoeventtype; // removed, added, updated, in users guide its called id
	
	private String receiveddate;
	
	private Timestamp timestamp; // in users guide its called "t"
	

//	private float confidence;
	
//	private Position pos;
//	private float x;
//	private float y;
//	private float z;
//	
////	private Size size;
//	private float width;
//	private float depth;
//    private float height;
	
//	//size_conf:
//	private float sc_width;
//	private float sc_depth;
//	private float sc_height;
	
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

	public String getCargoeventtype() {
		return cargoeventtype;
	}
	public void setCargoeventtype(String cargoeventtype) {
		this.cargoeventtype = cargoeventtype;
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
	public void setImg(byte[] image) {
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
	public CargoObject getCargoObject() {
		return cargoObject;
	}
	public void setCargoObject(CargoObject cargoObject) {
		this.cargoObject = cargoObject;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "CargoDetEventRest [id=" + id + ", clientid=" + clientid + ", cargoObject=" + cargoObject
				+ ", cargoeventtype=" + cargoeventtype + ", receiveddate=" + receiveddate + ", timestamp=" + timestamp
				+ ", image=" + Arrays.toString(image) + ", pointcloud=" + Arrays.toString(pointcloud) + "]";
	}
	
	
	

	
	
}
