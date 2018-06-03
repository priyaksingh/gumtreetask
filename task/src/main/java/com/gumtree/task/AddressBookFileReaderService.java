/**
 * 
 */
package com.gumtree.task;

import java.util.List;

import com.gumtree.task.model.Person;
import com.gumtree.task.service.exception.AddressBookFileReaderException;

/**
 * @author priyakrishna
 */
public interface AddressBookFileReaderService {

	public List<Person> processAddressBookFile() throws AddressBookFileReaderException;

	/**
	 * All constants for AddressBookFileReaderService
	 */
	public static final String COMMA = ",";
}
