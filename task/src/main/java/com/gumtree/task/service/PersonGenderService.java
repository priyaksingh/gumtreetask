/**
 * 
 */
package com.gumtree.task.service;

import java.util.List;

import com.gumtree.task.model.Person;
import com.gumtree.task.service.exception.AddressBookProcessException;

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
	 * @param people            the people
	 * @return the long
	 * @throws AddressBookProcessException the address book process exception
	 */
	public long numberOfMales(final List<Person> people) throws AddressBookProcessException;

}
