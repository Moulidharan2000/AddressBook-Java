package com.bridgelabz.addressbook;

public class ContactDetails {
	
	String firstName, lastName, email;
	long phoneNumber ;
	Address address;
	
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public Address getaddress() {
		return address;
	}
	public long phoneNumber() {
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
	public void setAddress(Address address) {
		this.address = address;
	}
	public void setphoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String toString() {
		return "Added Person Details  \nFirstName : "+firstName+" "+lastName+"\nAddress : "+address+"\nPhone Number : "+phoneNumber+"\nEmail : "+email;
	}
}