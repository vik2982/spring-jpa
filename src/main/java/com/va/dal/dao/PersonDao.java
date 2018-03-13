package com.va.dal.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.va.dal.model.Person;

public interface PersonDao extends CrudRepository<Person,Integer>{
	
	@Query("select p from Person p where p.address.postcode =?1")
	public Person findbyPostCode(String postcode);

}
