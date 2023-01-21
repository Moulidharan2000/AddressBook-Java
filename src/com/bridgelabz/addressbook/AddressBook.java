package com.bridgelabz.addressbook;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class AddressBook {
	
	ArrayList<ContactDetails> contactList = new ArrayList<ContactDetails>();
	Scanner scan = new Scanner(System.in);
	
	public void Options() {
		boolean changes = true;
		int num;
		while(changes) {
			System.out.println("\nChoose the Options : ");
			System.out.println("Option 1 : Add Contacts\n"+"Option 2 : Edit Existing Contacts\n"+
							   "Option 3 : Display Contacts\n");
			System.out.print("Enter the Option : ");
			num = scan.nextInt();
			switch(num) {
				case 1:
					AddContacts();
					break;
				case 2:
					EditContacts();
					break;
				case 3:
					DisplayContacts();
					break;
				default:
					changes = false;
					System.out.println("Exit");
			}
		}
	}
	
	public void AddContacts() {

		ContactDetails person = new ContactDetails();
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
		
		person.setFirstName(firstName);
		person.setLastName(lastName);
		person.setCity(city);
		person.setState(state);
		person.setZipCode(zipCode);
		person.setPhoneNumber(phoneNumber);
		person.setEmail(email);
		contactList.add(person);
	}
	
	public void EditContacts() {
		
		System.out.print("Enter the First Name : ");
		String firstName = scan.next();
		Iterator<ContactDetails> iterator = contactList.listIterator();
		
		while(iterator.hasNext()) {
			
			ContactDetails person = iterator.next();
			if(firstName.equals(person.getFirstName())) {
				System.out.println("Choose the Attributes to Change :");
				System.out.println("1.LastName\n"+"2.City\n"+
								   "3.State\n"+"4.ZipCode\n"+"5.PhoneNumber\n"+"6.Email\n");
				int choice = scan.nextInt();
				switch(choice){
					case 1:
						System.out.print("Enter the Last Name : ");
						String lastName = scan.next();
						person.setLastName(lastName);
						break;
					case 2:
						System.out.print("Enter the City : ");
						String city = scan.next();
						person.setCity(city);
						break;
					case 3:
						System.out.print("Enter the State : ");
						String state = scan.next();
						person.setState(state);
						break;
					case 4:
						System.out.print("Enter the ZipCode : ");
						int zipCode = scan.nextInt();
						person.setZipCode(zipCode);
						break;
					case 5:
						System.out.print("Enter the Phone Number : ");
						Long phoneNumber = scan.nextLong();
						person.setPhoneNumber(phoneNumber);
						break;
					case 6:
						System.out.print("Enter the Email : ");
						String email = scan.next();
						person.setEmail(email);
						break;
				}
			}
		}
	}
	
	public void DisplayContacts() {
		Iterator<ContactDetails> iterator = contactList.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
