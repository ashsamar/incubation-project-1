package com.zf.cs.db.model;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "movedcargodetevent")
public class MovedCargoDetEvent {

	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		

		private Long clientid;   

		private String objectid; // in users guide is called id


		private String movementeventtype; // removed, added, updated, in users guide its called id
		
		//@Temporal(TemporalType.TIMESTAMP)
		private String receiveddate;
		
		private Timestamp timestamp; // in users guide its called "t"
		

		private float confidence;
		
		//Position 
		private float x;
		private float y;
		private float z;
	//	
//		//Size?
		private float width;
		private float depth;
		private float height;
		
	
      private float nv_confidence;
		
		//Position 
		private float nv_x;
		private float nv_y;
		private float nv_z;
	//	
//		//Size?
		private float nv_width;
		private float nv_depth;
		private float nv_height;
		
		
		@Lob
		@Basic(fetch = FetchType.LAZY)
		private byte[] image;
//		private File depthdata;
		
		
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


		public String getObjectid() {
			return objectid;
		}


		public void setObjectid(String objectid) {
			this.objectid = objectid;
		}


		public String getMovementeventtype() {
			return movementeventtype;
		}


		public void setMovementeventtype(String movementeventtype) {
			this.movementeventtype = movementeventtype;
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


		public float getNv_confidence() {
			return nv_confidence;
		}


		public void setNv_confidence(float nv_confidence) {
			this.nv_confidence = nv_confidence;
		}


		public float getNv_x() {
			return nv_x;
		}


		public void setNv_x(float nv_x) {
			this.nv_x = nv_x;
		}


		public float getNv_y() {
			return nv_y;
		}


		public void setNv_y(float nv_y) {
			this.nv_y = nv_y;
		}


		public float getNv_z() {
			return nv_z;
		}


		public void setNv_z(float nv_z) {
			this.nv_z = nv_z;
		}


		public float getNv_width() {
			return nv_width;
		}


		public void setNv_width(float nv_width) {
			this.nv_width = nv_width;
		}


		public float getNv_depth() {
			return nv_depth;
		}


		public void setNv_depth(float nv_depth) {
			this.nv_depth = nv_depth;
		}


		public float getNv_height() {
			return nv_height;
		}


		public void setNv_height(float nv_height) {
			this.nv_height = nv_height;
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


		public String getReceiveddate() {
			return receiveddate;
		}


		public void setReceiveddate(String receiveddate) {
			this.receiveddate = receiveddate;
		}


		@Override
		public String toString() {
			return "MovedCargoDetEvent [id=" + id + ", clientid=" + clientid + ", objectid=" + objectid
					+ ", movementeventtype=" + movementeventtype + ", receiveddate=" + receiveddate + ", timestamp="
					+ timestamp + ", confidence=" + confidence + ", x=" + x + ", y=" + y + ", z=" + z + ", width="
					+ width + ", depth=" + depth + ", height=" + height + ", nv_confidence=" + nv_confidence + ", nv_x="
					+ nv_x + ", nv_y=" + nv_y + ", nv_z=" + nv_z + ", nv_width=" + nv_width + ", nv_depth=" + nv_depth
					+ ", nv_height=" + nv_height + ", image=" + Arrays.toString(image) + ", pointcloud="
					+ Arrays.toString(pointcloud) + "]";
		}


	

	
		
		
}
