package com.zf.cs.rest.model;

public class MovedCargoVolume {

	

	
	private float confidence;
	
	//Position 
	private float x;
	private float y;
	private float z;
	
	//Size?
	private float width;
	private float depth;
	private float height;
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
	@Override
	public String toString() {
		return "MovedCargoVolume [confidence=" + confidence + ", x=" + x + ", y=" + y + ", z=" + z + ", width=" + width
				+ ", depth=" + depth + ", height=" + height + "]";
	}
	
	
	
	
	
}
