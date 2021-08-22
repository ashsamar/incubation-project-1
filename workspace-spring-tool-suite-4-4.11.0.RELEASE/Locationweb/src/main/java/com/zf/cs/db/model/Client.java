package com.zf.cs.db.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "client")
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	
	private String name;

	
    private String trailerconfig;
	
	
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
	public String getTrailerconfig() {
		return trailerconfig;
	}
	public void setTrailerconfig(String trailerconfig) {
		this.trailerconfig = trailerconfig;
	}
	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + ", trailerconfig=" + trailerconfig + "]";
	}
	
	
	
	
}
