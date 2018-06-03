/**
 * 
 */
package com.gumtree.task.service;

import java.util.List;

import com.gumtree.task.model.Person;
import com.gumtree.task.service.exception.AddressBookFileReaderException;

// TODO: Auto-generated Javadoc
/**
 * The Interface AddressBookFileReaderService.
 *
 * @author priyakrishna
 */
public interface AddressBookFileReaderService {

	/**
	 * Process address book file.
	 *
	 * @return the list
	 * @throws AddressBookFileReaderException the address book file reader exception
	 */
	public List<Person> processAddressBookFile() throws AddressBookFileReaderException;

	/** All constants for AddressBookFileReaderService. */
	public static final String COMMA = ",";
}
