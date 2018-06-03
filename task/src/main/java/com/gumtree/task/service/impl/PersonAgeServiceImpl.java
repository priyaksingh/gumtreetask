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

/**
 * @author priyakrishna
 */
public class PersonAgeServiceImpl implements PersonAgeService {

	private static final Logger logger = LoggerFactory.getLogger(PersonAgeServiceImpl.class);

	@Override
	public Optional<Person> findOldestPerson(final List<Person> people) {
		logger.info("Start findOldestPerson.....");
		Optional<Person> oldestPerson = people.stream()
				.reduce((person1, person2) -> person1.getAge() > person2.getAge() ? person1 : person2);
		logger.debug("Oldest person in the address book: " + oldestPerson.get());
		return oldestPerson;
	}

	@Override
	public long differenceInAge(final List<Person> people, final String person1, final String person2) {
		logger.info("Start differenceInAge.....");
		Long differenceInAgeInMillis = people.stream().filter(
				person -> person.getName().equalsIgnoreCase(person1) || person.getName().equalsIgnoreCase(person2))
				.map(person -> person.getDob().getTime()).reduce(new Long(0), (start, end) -> Math.abs(end - start));
		long differenceInAge = TimeUnit.DAYS.convert(differenceInAgeInMillis, TimeUnit.MILLISECONDS);
		logger.debug("{} is older than {} by {} days.", person1, person2, differenceInAge);
		return differenceInAge;
	}

}
