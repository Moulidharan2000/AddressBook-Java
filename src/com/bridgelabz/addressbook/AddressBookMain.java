package com.bridgelabz.addressbook;

import java.util.Scanner;

public class AddressBookMain {

	public static void main(String[] args) {
		
		System.out.println("Welcome to Address Book Program\n");
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter the FirstName : ");
		String firstName = scan.next();
		
		System.out.print("Enter the Last Name : ");
		String lastName = scan.next();
		
		System.out.print("Enter the City : ");
		String city = scan.next();
		
		System.out.print("Enter the State : ");
		String state = scan.next();
		
		System.out.print("Enter the ZipCode : ");
		int zipCode = scan.nextInt();
		
		System.out.print("Enter the Phone Number : ");
		long phoneNumber = scan.nextLong();
		
		System.out.print("Enter the Email : ");
		String email = scan.next();
		scan.close();
		
		ContactDetails person = new ContactDetails();
		person.setFirstName(firstName);
		person.setLastName(lastName);
		person.setCity(city);
		person.setState(state);
		person.setZipCode(zipCode);
		person.setPhoneNumber(phoneNumber);
		person.setEmail(email);
		
		AddressBook addressBook = new AddressBook();
		addressBook.AddContacts(person);
		System.out.println(person);
	}
}
