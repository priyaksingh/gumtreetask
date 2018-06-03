/**
 * 
 */
package com.gumtree.task.service;

import java.util.Optional;

import com.gumtree.task.model.Person;

/**
 * @author priyakrishna
 */
public interface PersonAgeService {

	public Optional<Person> findOldestPerson();

	public long differenceInAge();

}
