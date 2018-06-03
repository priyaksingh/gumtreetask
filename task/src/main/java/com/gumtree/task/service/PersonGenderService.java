/**
 * 
 */
package com.gumtree.task.service;

import java.util.List;

import com.gumtree.task.model.Person;

/**
 * @author priyakrishna
 */
public interface PersonGenderService {

	public long numberOfMales(List<Person> people);

}
