package com.java.munro.model;

import java.util.ArrayList;
import java.util.List;

import com.java.munro.orm.Munro;

public class MunroFilterResponse {
	
	private List<String> errorMessages= new ArrayList<>();
	
	private List<Munro> munros;

	public List<String> getErrorMessages() {
		return errorMessages;
	}

	public void setErrorMessages(List<String> errorMessages) {
		this.errorMessages = errorMessages;
	}

	public List<Munro> getMunros() {
		return munros;
	}

	public void setMunros(List<Munro> munros) {
		this.munros = munros;
	}
	
	

}
