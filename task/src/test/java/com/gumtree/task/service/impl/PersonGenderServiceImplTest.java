/**
 * 
 */
package com.gumtree.task.service.impl;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.gumtree.task.model.Person;
import com.gumtree.task.service.AddressBookFileReaderService;
import com.gumtree.task.service.exception.AddressBookFileReaderException;
import com.gumtree.task.service.exception.AddressBookProcessException;

// TODO: Auto-generated Javadoc
/**
 * The Class PersonGenderServiceImplTest.
 *
 * @author priyakrishna
 */
public class PersonGenderServiceImplTest {

	/** The person gender service impl. */
	private PersonGenderServiceImpl personGenderServiceImpl;

	/** The addr book file reader service. */
	private AddressBookFileReaderService addrBookFileReaderService;

	/**
	 * Sets the up.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Before
	public void setUp() throws Exception {
		personGenderServiceImpl = new PersonGenderServiceImpl();
		addrBookFileReaderService = new AddressBookFileReaderServiceImpl();
	}

	/**
	 * Testnumber of males empty list.
	 *
	 * @throws AddressBookProcessException
	 *             the address book process exception
	 */
	@Test
	public void testnumberOfMales_EmptyList() throws AddressBookProcessException {
		List<Person> people = new ArrayList<>();
		personGenderServiceImpl.numberOfMales(people);

	}

	/**
	 * Testnumber of males null list.
	 *
	 * @throws AddressBookProcessException
	 *             the address book process exception
	 */
	@Test(expected = AddressBookProcessException.class)
	public void testnumberOfMales_NullList() throws AddressBookProcessException {
		List<Person> people = null;
		personGenderServiceImpl.numberOfMales(people);

	}

	/**
	 * Testnumber of males success.
	 *
	 * @throws AddressBookProcessException
	 *             the address book process exception
	 * @throws AddressBookFileReaderException
	 *             the address book file reader exception
	 */
	@Test
	public void testnumberOfMales_Success() throws AddressBookProcessException, AddressBookFileReaderException {
		List<Person> people = addrBookFileReaderService.processAddressBookFile();
		long numberOfMales = personGenderServiceImpl.numberOfMales(people);
		assertEquals(3, numberOfMales);

	}

}
