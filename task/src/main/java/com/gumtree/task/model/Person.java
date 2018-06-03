package com.gumtree.task.model;

import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class Person.
 */
public class Person {

	/** The name. */
	private String name;

	/** The gender. */
	private String gender;

	/** The dob. */
	private Date dob;

	/** The age. */
	private int age;

	/**
	 * Instantiates a new person.
	 */
	public Person() {

	}

	/**
	 * Instantiates a new person.
	 *
	 * @param name the name
	 * @param gender the gender
	 * @param dob the dob
	 */
	public Person(final String name, final String gender, final Date dob) {
		this.name = name;
		this.gender = gender;
		this.dob = dob;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(final String name) {
		this.name = name;
	}

	/**
	 * Gets the gender.
	 *
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * Sets the gender.
	 *
	 * @param gender the new gender
	 */
	public void setGender(final String gender) {
		this.gender = gender;
	}

	/**
	 * Gets the dob.
	 *
	 * @return the dob
	 */
	public Date getDob() {
		return dob;
	}

	/**
	 * Sets the dob.
	 *
	 * @param dob the new dob
	 */
	public void setDob(final Date dob) {
		this.dob = dob;
	}

	/**
	 * Gets the age.
	 *
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Sets the age.
	 *
	 * @param age the new age
	 */
	public void setAge(final int age) {
		this.age = age;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Person [name=" + name + ", gender=" + gender + ", dob=" + dob + ", age=" + age + "]";
	}

}
