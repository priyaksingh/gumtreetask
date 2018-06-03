/**
 * 
 */
package com.gumtree.task.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gumtree.task.model.Person;
import com.gumtree.task.service.PersonGenderService;

/**
 * @author priyakrishna
 */
public class PersonGenderServiceImpl implements PersonGenderService {

	private static final Logger logger = LoggerFactory.getLogger(PersonGenderServiceImpl.class);

	public static final String GENDER_MALE = "Male";

	@Override
	public long numberOfMales(List<Person> people) {
		logger.info("Start numberOfMales.....");
		long numberOfMales = people.stream().filter(person -> person.getGender().equalsIgnoreCase(GENDER_MALE)).count();
		logger.info("Number of males in the address book: " + numberOfMales);
		return numberOfMales;
	}

}
