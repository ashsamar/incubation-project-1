package com.zf.cs.db.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name ="clienttrailerconfig")
public class ClientTrailerConfig {



		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;

		private Long clientid;

		
		private String name;

		private String receiveddate;
		
		private float width;
		
		private float depth;
		
		private float height;
		
		
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Long getClientid() {
			return clientid;
		}
		public void setClientid(Long clientid) {
			this.clientid = clientid;
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
		public String getReceiveddate() {
			return receiveddate;
		}
		public void setReceiveddate(String receiveddate) {
			this.receiveddate = receiveddate;
		}
		@Override
		public String toString() {
			return "ClientTrailerConfig [id=" + id + ", clientid=" + clientid + ", name=" + name + ", receiveddate="
					+ receiveddate + ", width=" + width + ", depth=" + depth + ", height=" + height + "]";
		}
		
		
}
