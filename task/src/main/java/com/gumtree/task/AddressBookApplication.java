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
import com.gumtree.task.service.impl.AddressBookFileReaderServiceImpl;
import com.gumtree.task.service.impl.PersonAgeServiceImpl;
import com.gumtree.task.service.impl.PersonGenderServiceImpl;

/**
 * @author priyakrishna
 */
public class AddressBookApplication {

	private static final Logger logger = LoggerFactory.getLogger(AddressBookApplication.class);

	private static AddressBookFileReaderService addrBookFileReaderService = new AddressBookFileReaderServiceImpl();

	private static PersonGenderService genderService = new PersonGenderServiceImpl();

	private static PersonAgeService personAgeService = new PersonAgeServiceImpl();

	private static final String BILL_MCKNIGHT = "Bill McKnight";

	private static final String PAUL_ROBINSON = "Paul Robinson";

	/**
	 * @param args
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

		} catch (AddressBookFileReaderException e) {
			logger.error(e.getMessage());
		}

	}

}
