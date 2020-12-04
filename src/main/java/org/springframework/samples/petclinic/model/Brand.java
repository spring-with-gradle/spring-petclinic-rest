package org.springframework.samples.petclinic.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "brands")
public class Brand extends NamedEntity {

}
