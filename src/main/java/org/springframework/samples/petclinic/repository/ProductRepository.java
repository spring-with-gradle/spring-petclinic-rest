package org.springframework.samples.petclinic.repository;

import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.rest.Product;

public interface ProductRepository {

	Collection<Product> findAll() throws DataAccessException;

}
