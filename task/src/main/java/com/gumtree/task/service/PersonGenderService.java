/**
 * 
 */
package com.gumtree.task.service;

import java.util.List;

import com.gumtree.task.model.Person;

// TODO: Auto-generated Javadoc
/**
 * The Interface PersonGenderService.
 *
 * @author priyakrishna
 */
public interface PersonGenderService {

	/**
	 * Number of males.
	 *
	 * @param people the people
	 * @return the long
	 */
	public long numberOfMales(final List<Person> people);

}
