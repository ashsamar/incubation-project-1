package com.zf.cs.rest.model;

import java.sql.Timestamp;

public class CargoObject {

	

	private String eachcargoeventid; // in users guide is called id


	//private String cargoeventtype; // removed, added, updated, in users guide its called id
	
	
//	private Timestamp timestamp; // in users guide its called "t"
	

	private float confidence;
	
//	private Position pos;
	private float x;
	private float y;
	private float z;
	
//	private Size size;
	private float width;
	private float depth;
    private float height;
	
//	//size_conf:
	private float sc_width;
	private float sc_depth;
	private float sc_height;
	public String getEachcargoeventid() {
		return eachcargoeventid;
	}
	public void setEachcargoeventid(String eachcargoeventid) {
		this.eachcargoeventid = eachcargoeventid;
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
		return "CargoObject [eachcargoeventid=" + eachcargoeventid + ", confidence=" + confidence + ", x=" + x + ", y="
				+ y + ", z=" + z + ", width=" + width + ", depth=" + depth + ", height=" + height + ", sc_width="
				+ sc_width + ", sc_depth=" + sc_depth + ", sc_height=" + sc_height + "]";
	}
	
	

}
