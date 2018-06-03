/**
 * 
 */
package com.gumtree.task.service;

import java.util.List;
import java.util.Optional;

import com.gumtree.task.model.Person;

/**
 * @author priyakrishna
 */
public interface PersonAgeService {

	public Optional<Person> findOldestPerson(final List<Person> people);

	public long differenceInAge(final List<Person> people, final String person1, final String person2);

}
