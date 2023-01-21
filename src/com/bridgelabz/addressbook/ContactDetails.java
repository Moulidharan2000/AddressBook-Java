package com.bridgelabz.addressbook;

public class ContactDetails {
	
	String firstName, lastName, address, state, city, email;
	int zipCode;
	long phoneNumber;
	
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getCity() {
		return city;
	}
	public String getState() {
		return firstName;
	}
	public int getZipCode() {
		return zipCode;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setState(String state) {
		this.state = state;
	}
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String toString() {
		return "\nFirstName : "+firstName+" "+lastName+
				"\nAddress : "+city+", "+state+", "+zipCode+
				"\nPhone Number : "+phoneNumber+"\nEmail : "+email;
	}
}
