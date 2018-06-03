/**
 * 
 */
package com.gumtree.task.service;

import java.util.List;
import java.util.Optional;

import com.gumtree.task.model.Person;

// TODO: Auto-generated Javadoc
/**
 * The Interface PersonAgeService.
 *
 * @author priyakrishna
 */
public interface PersonAgeService {

	/**
	 * Find oldest person.
	 *
	 * @param people the people
	 * @return the optional
	 */
	public Optional<Person> findOldestPerson(final List<Person> people);

	/**
	 * Difference in age.
	 *
	 * @param people the people
	 * @param person1 the person 1
	 * @param person2 the person 2
	 * @return the long
	 */
	public long differenceInAge(final List<Person> people, final String person1, final String person2);

}
