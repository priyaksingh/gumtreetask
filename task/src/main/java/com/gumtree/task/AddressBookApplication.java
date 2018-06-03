/**
 * 
 */
package com.gumtree.task;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gumtree.task.model.Person;
import com.gumtree.task.service.AddressBookFileReaderService;
import com.gumtree.task.service.PersonAgeService;
import com.gumtree.task.service.PersonGenderService;
import com.gumtree.task.service.exception.AddressBookFileReaderException;
import com.gumtree.task.service.exception.AddressBookProcessException;
import com.gumtree.task.service.impl.AddressBookFileReaderServiceImpl;
import com.gumtree.task.service.impl.PersonAgeServiceImpl;
import com.gumtree.task.service.impl.PersonGenderServiceImpl;

// TODO: Auto-generated Javadoc
/**
 * The Class AddressBookApplication.
 *
 * @author priyakrishna
 */
public class AddressBookApplication {

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(AddressBookApplication.class);

	/** The addr book file reader service. */
	private static AddressBookFileReaderService addrBookFileReaderService = new AddressBookFileReaderServiceImpl();

	/** The gender service. */
	private static PersonGenderService genderService = new PersonGenderServiceImpl();

	/** The person age service. */
	private static PersonAgeService personAgeService = new PersonAgeServiceImpl();

	/** The Constant BILL_MCKNIGHT. */
	private static final String BILL_MCKNIGHT = "Bill McKnight";

	/** The Constant PAUL_ROBINSON. */
	private static final String PAUL_ROBINSON = "Paul Robinson";

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {

		logger.info("START GUMTREE ASSIGNMENT");

		try {
			List<Person> people = addrBookFileReaderService.processAddressBookFile();

			// 1. How many males are in the address book?
			long numberOfMales = genderService.numberOfMales(people);
			System.out.println("Number of males in the address book: " + numberOfMales);

			// 2. Who is the oldest person in the address book?
			Optional<Person> oldestPerson = personAgeService.findOldestPerson(people);
			oldestPerson.ifPresent(System.out::println);

			// 3.How many days older is Bill than Paul?
			long differenceInAge = personAgeService.differenceInAge(people, BILL_MCKNIGHT, PAUL_ROBINSON);
			System.out.println(BILL_MCKNIGHT + " is older than " + PAUL_ROBINSON + " by " + differenceInAge + " days");

		} catch (AddressBookFileReaderException | AddressBookProcessException e) {
			logger.error(e.getMessage());
		}
	}
}
