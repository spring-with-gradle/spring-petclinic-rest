package org.springframework.samples.petclinic.repository.jpa;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Profile;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.repository.ProductRepository;
import org.springframework.samples.petclinic.rest.Product;
import org.springframework.stereotype.Repository;

@Repository
@Profile("jpa")
public class JpaProductRepositoryImpl 
implements ProductRepository {

    @PersistenceContext
    private EntityManager em;	
	
	@SuppressWarnings("unchecked")    
	@Override
	public Collection<Product> findAll() throws DataAccessException {
 		return this.em.createQuery("SELECT p FROM Product p").getResultList();
	}

}
