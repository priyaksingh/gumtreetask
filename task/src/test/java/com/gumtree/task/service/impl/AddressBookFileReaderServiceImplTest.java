/**
 * 
 */
package com.gumtree.task.service.impl;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.gumtree.task.model.Person;
import com.gumtree.task.service.AddressBookFileReaderService;
import com.gumtree.task.service.exception.AddressBookFileReaderException;

// TODO: Auto-generated Javadoc
/**
 * The Class AddressBookFileReaderServiceImplTest.
 *
 * @author priyakrishna
 */
public class AddressBookFileReaderServiceImplTest {

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
		addrBookFileReaderService = new AddressBookFileReaderServiceImpl();
	}

	/**
	 * Test processing of addr file success.
	 *
	 * @throws AddressBookFileReaderException
	 *             the address book file reader exception
	 */
	@Test
	public void testProcessingOfAddrFile_Success() throws AddressBookFileReaderException {
		List<Person> people = addrBookFileReaderService.processAddressBookFile();
		assertEquals(5, people.size());
	}

}
