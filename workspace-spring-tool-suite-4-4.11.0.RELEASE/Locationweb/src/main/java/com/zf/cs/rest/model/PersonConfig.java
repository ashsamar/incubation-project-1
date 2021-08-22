package com.zf.cs.rest.model;

public class PersonConfig {

	
    private float confidence;
	

	private float x;
	private float y;
	private float z;
	
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

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return "PersonConfig [confidence=" + confidence + ", x=" + x + ", y=" + y + ", z=" + z + ", height=" + height
				+ "]";
	}
	
	
}
