package com.java.munro.orm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "MUNRO")
public class Munro {

	@Id
	@GeneratedValue
	private long id;
	
	private String name;
	
	private double height;
	
	private String gridReference;
	
	private String hillCategory;
	
	@Column(name = "NO")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	@Column(name = "NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Column(name = "HEIGHT")
	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	@Column(name = "GRID_REFERENCE")
	public String getGridReference() {
		return gridReference;
	}

	public void setGridReference(String gridReference) {
		this.gridReference = gridReference;
	}

	public String getHillCategory() {
		return hillCategory;
	}

	public void setHillCategory(String hillCategory) {
		this.hillCategory = hillCategory;
	}
	
	
}
