/**
 * 
 */
package com.gumtree.task.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gumtree.task.model.Person;
import com.gumtree.task.service.PersonGenderService;
import com.gumtree.task.service.exception.AddressBookProcessException;

// TODO: Auto-generated Javadoc
/**
 * The Class PersonGenderServiceImpl.
 *
 * @author priyakrishna
 */
public class PersonGenderServiceImpl implements PersonGenderService {

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(PersonGenderServiceImpl.class);

	/** The Constant GENDER_MALE. */
	public static final String GENDER_MALE = "Male";

	/*
	 * (non-Javadoc)
	 * @see
	 * com.gumtree.task.service.PersonGenderService#numberOfMales(java.util.List)
	 */
	@Override
	public long numberOfMales(List<Person> people) throws AddressBookProcessException {
		logger.info("Start numberOfMales.....");
		long numberOfMales = 0;
		if (people != null) {
			numberOfMales = people.stream().filter(person -> person.getGender().equalsIgnoreCase(GENDER_MALE)).count();
			logger.info("Number of males in the address book: " + numberOfMales);
		} else {
			throw new AddressBookProcessException("Input list of people is empty");
		}
		return numberOfMales;
	}

}
