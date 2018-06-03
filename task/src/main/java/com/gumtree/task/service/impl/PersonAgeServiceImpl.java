/**
 * 
 */
package com.gumtree.task.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gumtree.task.model.Person;
import com.gumtree.task.service.PersonAgeService;
import com.gumtree.task.service.exception.AddressBookProcessException;

// TODO: Auto-generated Javadoc
/**
 * The Class PersonAgeServiceImpl.
 *
 * @author priyakrishna
 */
public class PersonAgeServiceImpl implements PersonAgeService {

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(PersonAgeServiceImpl.class);

	/*
	 * (non-Javadoc)
	 * @see
	 * com.gumtree.task.service.PersonAgeService#findOldestPerson(java.util.List)
	 */
	@Override
	public Optional<Person> findOldestPerson(final List<Person> people) throws AddressBookProcessException {
		logger.info("Start findOldestPerson.....");
		Optional<Person> oldestPerson = Optional.empty();
		if (people != null) {
			oldestPerson = people.stream()
					.reduce((person1, person2) -> person1.getAge() > person2.getAge() ? person1 : person2);
			if (oldestPerson.isPresent())
				logger.debug("Oldest person in the address book: " + oldestPerson.get());
		} else {
			throw new AddressBookProcessException("Input list of people is empty");
		}
		return oldestPerson;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.gumtree.task.service.PersonAgeService#differenceInAge(java.util.List,
	 * java.lang.String, java.lang.String)
	 */
	@Override
	public long differenceInAge(final List<Person> people, final String person1, final String person2)
			throws AddressBookProcessException {
		logger.info("Start differenceInAge.....");
		long differenceInAge = 0;
		if (people != null && person1 != null && person2 != null) {
			Long differenceInAgeInMillis = people.stream()
					.filter(person -> person.getName().equalsIgnoreCase(person1)
							|| person.getName().equalsIgnoreCase(person2))
					.map(person -> person.getDob().getTime())
					.reduce(new Long(0), (start, end) -> Math.abs(end - start));
			differenceInAge = TimeUnit.DAYS.convert(differenceInAgeInMillis, TimeUnit.MILLISECONDS);
			logger.debug("{} is older than {} by {} days.", person1, person2, differenceInAge);
		} else {
			throw new AddressBookProcessException("Input list of people is empty");
		}
		return differenceInAge;
	}

}
