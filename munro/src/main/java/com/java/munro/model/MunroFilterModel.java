package com.java.munro.model;

public class MunroFilterModel {
	
	private String name;
	
	private Double maxHeight;
	
	private Double minHeight;
	
	private String gridReference;
	
	private String hillCategory;

	private Integer limit;
	
	private Double height;
	
	private boolean asc = true;
	
	private String fieldToBeSorted;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getMaxHeight() {
		return maxHeight;
	}

	public void setMaxHeight(Double maxHeight) {
		this.maxHeight = maxHeight;
	}

	public Double getMinHeight() {
		return minHeight;
	}

	public void setMinHeight(Double minHeight) {
		this.minHeight = minHeight;
	}

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

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public boolean isAsc() {
		return asc;
	}

	public void setAsc(boolean asc) {
		this.asc = asc;
	}

	public String getFieldToBeSorted() {
		return fieldToBeSorted;
	}

	public void setFieldToBeSorted(String fieldToBeSorted) {
		this.fieldToBeSorted = fieldToBeSorted;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}
	
	
}
