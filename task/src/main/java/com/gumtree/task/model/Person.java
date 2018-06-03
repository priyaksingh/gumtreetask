package com.gumtree.task.model;

import java.util.Date;

public class Person {

	private String name;

	private String gender;

	private Date dob;

	private int age;

	public Person() {

	}

	public Person(final String name, final String gender, final Date dob) {
		this.name = name;
		this.gender = gender;
		this.dob = dob;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(final String gender) {
		this.gender = gender;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(final Date dob) {
		this.dob = dob;
	}

	public int getAge() {
		return age;
	}

	public void setAge(final int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", gender=" + gender + ", dob=" + dob + ", age=" + age + "]";
	}

}
