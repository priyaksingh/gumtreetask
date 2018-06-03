/**
 * 
 */
package com.gumtree.task.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;

import com.gumtree.task.model.Person;
import com.gumtree.task.service.AddressBookFileReaderService;
import com.gumtree.task.service.exception.AddressBookFileReaderException;
import com.gumtree.task.service.exception.AddressBookProcessException;

// TODO: Auto-generated Javadoc
/**
 * The Class PersonAgeServiceImplTest.
 *
 * @author priyakrishna
 */
public class PersonAgeServiceImplTest {

	/** The person gender service impl. */
	private PersonAgeServiceImpl personAgeServiceImpl;

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
		personAgeServiceImpl = new PersonAgeServiceImpl();
		addrBookFileReaderService = new AddressBookFileReaderServiceImpl();
	}

	/**
	 * Testnumber of males empty list.
	 *
	 * @throws AddressBookProcessException
	 *             the address book process exception
	 */
	@Test
	public void test_findOldestPerson_EmptyList() throws AddressBookProcessException {
		List<Person> people = new ArrayList<>();
		personAgeServiceImpl.findOldestPerson(people);

	}

	/**
	 * Testnumber of males null list.
	 *
	 * @throws AddressBookProcessException
	 *             the address book process exception
	 */
	@Test(expected = AddressBookProcessException.class)
	public void test_findOldestPerson_NullList() throws AddressBookProcessException {
		personAgeServiceImpl.findOldestPerson(null);
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
		Optional<Person> oldestPerson = personAgeServiceImpl.findOldestPerson(people);
		assertNotNull(oldestPerson);
		assertEquals(43, oldestPerson.get().getAge());
	}

	/**
	 * Test difference in age empty list.
	 *
	 * @throws AddressBookProcessException
	 *             the address book process exception
	 */
	@Test
	public void test_differenceInAge_EmptyList() throws AddressBookProcessException {
		List<Person> people = new ArrayList<>();
		personAgeServiceImpl.differenceInAge(people, "", "");

	}

	/**
	 * Testnumber of males null list.
	 *
	 * @throws AddressBookProcessException
	 *             the address book process exception
	 */
	@Test(expected = AddressBookProcessException.class)
	public void test_differenceInAge_NullParams() throws AddressBookProcessException {
		personAgeServiceImpl.differenceInAge(null, null, null);
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
	public void test_differenceInAge_Success() throws AddressBookProcessException, AddressBookFileReaderException {
		List<Person> people = addrBookFileReaderService.processAddressBookFile();
		long oldestPerson = personAgeServiceImpl.differenceInAge(people, "Bill McKnight", "Paul Robinson");
		assertEquals(2862, oldestPerson);
	}

}
