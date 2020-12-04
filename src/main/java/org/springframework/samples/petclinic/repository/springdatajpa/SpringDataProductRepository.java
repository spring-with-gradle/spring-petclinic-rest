package org.springframework.samples.petclinic.repository.springdatajpa;

import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.Repository;
import org.springframework.samples.petclinic.model.Product;
import org.springframework.samples.petclinic.repository.ProductRepository;

@Profile("spring-data-jpa")
public interface SpringDataProductRepository 
extends ProductRepository, Repository<Product, Integer> {

}
