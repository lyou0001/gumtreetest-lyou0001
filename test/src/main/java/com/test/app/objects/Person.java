package com.test.app.objects;

import java.util.Date;

/**
 * Class representing the entries in the AddressBook
 * @author Lisa
 *
 */
public class Person {

	private String name;
	private String gender;
	private Date dob;
	
	public Person() { }
	
	public Person(final String name, final String gender, final Date dob) {
		this.name = name;
		this.gender = gender;
		this.dob = dob;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
}
