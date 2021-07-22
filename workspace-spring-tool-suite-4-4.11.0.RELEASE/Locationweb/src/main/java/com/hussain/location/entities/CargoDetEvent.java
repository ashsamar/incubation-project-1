package com.hussain.location.entities;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cargodetevent")
public class CargoDetEvent {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	

	private Long clientid;   
	
	@Column(name = "eachcargoeventid")
	private String eachcargoeventid; // in users guide is called id


	private String cargoeventtype; // removed, added, updated, in users guide its called id
	
	private Date receiveddate;
	
	private Timestamp timestamp; // in users guide its called "t"
	

	private float confidence;
	
	//Position 
	private float x;
	private float y;
	private float z;
	
	//Size?
	private float width;
	private float depth;
	private float height;
	
	//size_conf:
	private float sc_width;
	private float sc_depth;
	private float sc_height;
	
	
	
	
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
	public String getEachcargoeventid() {
		return eachcargoeventid;
	}
	public void setEachcargoeventid(String eachcargoeventid) {
		this.eachcargoeventid = eachcargoeventid;
	}
	public String getCargoeventtype() {
		return cargoeventtype;
	}
	public void setCargoeventtype(String cargoeventtype) {
		this.cargoeventtype = cargoeventtype;
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
	public float getSc_width() {
		return sc_width;
	}
	public void setSc_width(float sc_width) {
		this.sc_width = sc_width;
	}
	public float getSc_depth() {
		return sc_depth;
	}
	public void setSc_depth(float sc_depth) {
		this.sc_depth = sc_depth;
	}
	public float getSc_height() {
		return sc_height;
	}
	public void setSc_height(float sc_height) {
		this.sc_height = sc_height;
	}
	@Override
	public String toString() {
		return "CargoDetEvent [id=" + id + ", clientid=" + clientid + ", eachcargoeventid=" + eachcargoeventid
				+ ", cargoeventtype=" + cargoeventtype + ", receiveddate=" + receiveddate + ", timestamp=" + timestamp
				+ ", confidence=" + confidence + ", x=" + x + ", y=" + y + ", z=" + z + ", width=" + width + ", depth="
				+ depth + ", height=" + height + ", sc_width=" + sc_width + ", sc_depth=" + sc_depth + ", sc_height="
				+ sc_height + "]";
	}
	
	
	
}
