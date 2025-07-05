package com.batch.demo.config;

import org.springframework.batch.item.ItemProcessor;

import com.batch.demo.entity.Person;

public class PersonProcessor implements ItemProcessor<Person, Person> {

	@Override
	public Person process(Person person) throws Exception {

		 person.setFirstName(person.getFirstName().toUpperCase());
		 person.setLastName(person.getLastName().toUpperCase());

		return person;
	}
	
}
