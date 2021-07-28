package com.hussain.location.entities;

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
@Table(name = "automaticrecalevent")
public class AutomaticRecalEvent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	

	private Long clientid;   
	

	private String automaticrecaleventtype; // removed, added, updated, in users guide its called id
	
	private Date receiveddate;
	
	private Timestamp timestamp; // in users guide its called "t"
	
	private float anglediff;
	
	private String  status;
	
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


	public String getAutomaticrecaleventtype() {
		return automaticrecaleventtype;
	}


	public void setAutomaticrecaleventtype(String automaticrecaleventtype) {
		this.automaticrecaleventtype = automaticrecaleventtype;
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


	@Override
	public String toString() {
		return "AutomaticRecalEvent [id=" + id + ", clientid=" + clientid + ", automaticrecaleventtype="
				+ automaticrecaleventtype + ", receiveddate=" + receiveddate + ", timestamp=" + timestamp
				+ ", anglediff=" + anglediff + ", status=" + status + ", image=" + Arrays.toString(image)
				+ ", pointcloud=" + Arrays.toString(pointcloud) + "]";
	}
	
	
	
}
