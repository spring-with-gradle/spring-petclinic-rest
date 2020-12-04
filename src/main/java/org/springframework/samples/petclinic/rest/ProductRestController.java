package org.springframework.samples.petclinic.rest;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.samples.petclinic.model.Product;
import org.springframework.samples.petclinic.service.ClinicService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(exposedHeaders = "errors, content-type")
@RequestMapping("api/products")
public class ProductRestController {
	@Autowired
	private ClinicService clinicService;

    @PreAuthorize( "hasAnyRole(@roles.OWNER_ADMIN, @roles.VET_ADMIN)" )
	@RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Collection<Product>> getAllProducts(){
		Collection<Product> products = new ArrayList<Product>();
		products.addAll(this.clinicService.findAllProducts());
		if (products.isEmpty()){
			return new ResponseEntity<Collection<Product>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Collection<Product>>(products, HttpStatus.OK);
	}	
}
