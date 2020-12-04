package org.springframework.samples.petclinic.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product extends BaseEntity {

	private String description;
	
    @ManyToOne
    @JoinColumn(name = "brand_id")	
	private Brand brand;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
