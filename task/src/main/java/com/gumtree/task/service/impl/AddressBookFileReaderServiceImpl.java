/**
 * 
 */
package com.gumtree.task.service.impl;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gumtree.task.model.Person;
import com.gumtree.task.service.AddressBookFileReaderService;
import com.gumtree.task.service.exception.AddressBookFileReaderException;

/**
 * @author priyakrishna
 */
public class AddressBookFileReaderServiceImpl implements AddressBookFileReaderService {

	private static final Logger logger = LoggerFactory.getLogger(AddressBookFileReaderServiceImpl.class);

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");

	private static final String ADDR_BOOK_FILE_NAME = "AddressBook.txt";

	@Override
	public List<Person> processAddressBookFile() throws AddressBookFileReaderException {
		logger.info("Start processAddressBookFile.....");
		List<Person> personList = new ArrayList<>();
		try {
			Function<String, Person> mapToPerson = (line) -> convertToPersonObj(line);
			final URI uri = getClass().getClassLoader().getResource(ADDR_BOOK_FILE_NAME).toURI();
			if (uri != null) {
				final Path path = Paths.get(uri);
				Stream<String> lines = Files.lines(path);
				personList = lines.map(mapToPerson).peek(System.out::println).collect(Collectors.toList());
				lines.close();
				logger.info("Address book processed successfully");
			}
		} catch (URISyntaxException | IOException e) {
			logger.info("Error in processing Address book");
			throw new AddressBookFileReaderException(e.getMessage());
		}
		return personList;
	}

	private Person convertToPersonObj(final String personStr) {
		logger.info("Start convertToPersonObj.....");
		final String[] personStrArr = personStr.split(COMMA);
		Person person = new Person();
		try {
			if (personStrArr != null && personStrArr.length == 3) {
				person.setName(personStrArr[0].trim());
				person.setGender(personStrArr[1].trim());
				person.setDob(dateFormat.parse(personStrArr[2].trim()));
				person.setAge(calculateAge(person.getDob()));
			} else {
				logger.error("Error creating Person object from the AddressBookFile");
			}
		} catch (ParseException e) {
			logger.error(e.getMessage());
		}
		return person;
	}

	private int calculateAge(final Date dob) {
		logger.info("Start calculateAge for DOB : {} ", dob);
		LocalDate fullBirthday = dob.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate today = LocalDate.now();
		int age = Period.between(fullBirthday, today).getYears();
		logger.debug("Current age is :{} for a person with DOB : {} ", age, dob);
		return age;
	}

}
