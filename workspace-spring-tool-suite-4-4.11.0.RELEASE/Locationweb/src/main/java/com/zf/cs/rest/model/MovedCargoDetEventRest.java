package com.zf.cs.rest.model;

import java.sql.Timestamp;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Embedded;

public class MovedCargoDetEventRest {

	
	
	
	 private Long id;
		

		private Long clientid;   
		

		private String objectid; // in users guide is called id


		private String movementeventtype; // removed, added, updated, in users guide its called id
		
		private String receiveddate;
		
		private Timestamp timestamp; // in users guide its called "t"
		

		@Embedded
		private MovedCargoVolume volume;
	
//		private float confidence;
//		
//		//Position 
//		private float x;
//		private float y;
//		private float z;
//		
//		//Size?
//		private float width;
//		private float depth;
//		private float height;
//		
		
		@Embedded
		private MovedCargoNewVolume newVolume;
		
//		   private float nv_confidence;
//			
//			//Position 
//			private float nv_x;
//			private float nv_y;
//			private float nv_z;
//		//	
////			//Size?
//			private float nv_width;
//			private float nv_depth;
//			private float nv_height;
//		
//		

		private byte[] image;
//		private File depthdata;
		

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


	

		public void setImage(byte[] image) {
			this.image = image;
		}


		public byte[] getPointcloud() {
			return pointcloud;
		}


		public void setPointcloud(byte[] pointcloud) {
			this.pointcloud = pointcloud;
		}


		public String getObjectid() {
			return objectid;
		}


		public void setObjectid(String objectid) {
			this.objectid = objectid;
		}


		public MovedCargoVolume getVolume() {
			return volume;
		}


		public void setVolume(MovedCargoVolume volume) {
			this.volume = volume;
		}


		public MovedCargoNewVolume getNewVolume() {
			return newVolume;
		}


		public void setNewVolume(MovedCargoNewVolume newVolume) {
			this.newVolume = newVolume;
		}


		public byte[] getImage() {
			return image;
		}


		@Override
		public String toString() {
			return "MovedCargoDetEventRest [id=" + id + ", clientid=" + clientid + ", objectid=" + objectid
					+ ", movementeventtype=" + movementeventtype + ", receiveddate=" + receiveddate + ", timestamp="
					+ timestamp + ", volume=" + volume + ", newVolume=" + newVolume + ", image="
					+ Arrays.toString(image) + ", pointcloud=" + Arrays.toString(pointcloud) + "]";
		}


		

		
		
		
}
