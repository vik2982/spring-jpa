package com.va.dal;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.va.dal.exception.SomeException;
import com.va.dal.service.PersonService;

public class Application {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("daoApplicationContext.xml");
		
		PersonService personService = context.getBean(PersonService.class);
		System.out.println(personService.getPerson().getName());
		
		System.out.println(personService.getPostcode());
		
		try {
			personService.savePerson();
		}catch(SomeException ex) {}
		try {
			personService.savePersonNoRollback();
		}catch(SomeException ex) {}
		try {
			personService.savePersonRollback();
		}catch(SomeException ex) {}
		
	}

}
