package org.springframework.samples.petclinic.rest;

public class Product {

	private String description;
	
	Product(String description) {
		super();
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
