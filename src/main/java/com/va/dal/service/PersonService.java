package com.va.dal.service;

import org.springframework.transaction.annotation.Transactional;
import com.va.dal.dao.PersonDao;
import com.va.dal.exception.SomeException;
import com.va.dal.model.Address;
import com.va.dal.model.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonService {
	
	@Autowired	
	PersonDao personDao;

	@Transactional(readOnly=true)
	public String getPostcode() {
		return personDao.findbyPostCode("EC8U 3CC").getAddress().getPostcode();
	}
	
	@Transactional(readOnly=true)
	public Person getPerson() {
		return personDao.findOne(1);
	}
	
	//By default only unchecked exceptions are rolled back
	@Transactional()
	public void savePerson() throws SomeException {
		Person person = new Person(new Address("AB4R 3DD"),"James");
		personDao.save(person);
		throw new SomeException();
	}
	
	//Rollback all exceptions except SomeException
	@Transactional(rollbackFor=Throwable.class,noRollbackFor=SomeException.class)
	public void savePersonNoRollback() throws SomeException {
		Person person = new Person(new Address("WV6Y 5TT"),"David");
		personDao.save(person);
		throw new SomeException();
	}

	//Rollback all exceptions
	@Transactional(rollbackFor=Throwable.class)
	public void savePersonRollback() throws SomeException {
		Person person = new Person(new Address("BS2E 7XX"),"John");
		personDao.save(person);
		throw new SomeException();
	}
}
