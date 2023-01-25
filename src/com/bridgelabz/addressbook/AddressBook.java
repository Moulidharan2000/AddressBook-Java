package com.bridgelabz.addressbook;

import java.util.Scanner;

public class AddressBook {
	
	private final int NUM_OF_PEOPLE = 5;
	public String addressBookName;
	Scanner scan = new Scanner(System.in);
	ContactDetails[]contactList = new ContactDetails[NUM_OF_PEOPLE];
	public static int numberOfEntries = 0;
	
	public void Options() {
		
		boolean changes = true;
		int num;
		while(changes) {
			System.out.println("\nChoose the Options ----------");
			System.out.println("Option 1 : Add Contacts\n"+"Option 2 : Edit Existing Contacts\n"+
							   "Option 3 : Delete Contacts\n"+"Option 4 : Display Contacts\n"+"Option 5 : Exit\n");
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
					DeletePerson();
					break;
				case 4:
					DisplayContacts();
					break;
				default:
					System.out.println("----------Exiting----------");
			}
		}
	}
	
	public void AddContacts() {

		 System.out.println("Enter number of people you want to add to Addres book");
	        int numberOfPeople = scan.nextInt();
	        int endIterator = numberOfPeople+numberOfEntries;

	        if(endIterator > NUM_OF_PEOPLE) {
	            System.out.println("Address Book is FULL !");
	            System.out.println("You can add: "+(NUM_OF_PEOPLE-numberOfEntries));
	            return;
	        }
	        else {

	            for(int index=numberOfEntries; index < endIterator ; index++) {

	                ContactDetails person = new ContactDetails();
	                System.out.println("Enter the details of Person "+(index+1));

	                System.out.println("Enter First Name: ");
	                String firstName = scan.next();

	                System.out.println("Enter Last Name: ");
	                String lastName = scan.next();

	                System.out.println("Enter City: ");
	                String city = scan.next();

	                System.out.println("Enter State: ");
	                String state = scan.next();

	                System.out.println("Enter Zip Code: ");
	                long zipCode = scan.nextLong();
	                
	                System.out.println("Enter Phone Number: ");
	                long phoneNumber = scan.nextLong();

	                System.out.println("Enter Email: ");
	                String email = scan.next();

	                person.setFirstName(firstName);
	                person.setLastName(lastName);
	                person.setPhoneNumber(phoneNumber);
	                person.setEmail(email);
	                person.setCity(city);
	                person.setState(state);
	                person.setZipCode(zipCode);
	                contactList[index] = person;
	                numberOfEntries++;

	            }
	        }
	}
	
	public void EditContacts() {
		
		 System.out.println("Enter the first name:");
	        String firstName = scan.next();

	        for(int index = 0; index <numberOfEntries; index++) {

	            ContactDetails person = contactList[index];

	            if(firstName.equals(person.getFirstName())) {

	                System.out.println("\nChoose the attribute you want to change:");
	                System.out.println("1.First Name\n2.Last Name\n3.Phone Number\n4.Email\n5.City\n6.State\n7.ZipCode");
	                int choice = scan.nextInt();

	                switch(choice) {
	                    case 1:
	                        System.out.println("Enter the correct Last Name :");
	                        String lastName = scan.next();
	                        person.setLastName(lastName);
	                        break;
	                        
	                    case 2:
	                        System.out.println("Enter the correct City :");
	                        String city = scan.next();
	                        person.setCity(city);
	                        break;
	                        
	                    case 3:
	                        System.out.println("Enter the correct State :");
	                        String state = scan.next();
	                        person.setState(state);
	                        break;
	                        
	                    case 4:
	                        System.out.println("Enter the correct ZipCode :");
	                        long zip = scan.nextLong();
	                        person.setZipCode(zip);
	                        break;
	                        
	                    case 5:
	                        System.out.println("Enter the correct Phone Number :");
	                        long phoneNumber = scan.nextLong();
	                        person.setPhoneNumber(phoneNumber);
	                        break;
	                        
	                    case 6:
	                        System.out.println("Enter the correct Email Address :");
	                        String email = scan.next();
	                        person.setEmail(email);
	                        break;       
	                }
	            }
	        }
	    }
	
	public void DeletePerson() {
		
		 System.out.println("Enter the first name of the person to be deleted");
	        String firstName = scan.next();

	        for(int index = 0; index <numberOfEntries; index++) {

	            ContactDetails person = contactList[index];

	            if(firstName.equals(person.getFirstName())) {

	                for(int nextIndex = index; nextIndex<contactList.length-1; nextIndex++) {
	                    contactList[nextIndex] = contactList[nextIndex+1];

	                }
	                numberOfEntries--;
	                return;
	            }
	        }
	    }
	
	public void DisplayContacts() {
		
        System.out.println("----- Contents of the Address Book -----");
        for(int index=0; index < numberOfEntries ; index++) {
            System.out.println(contactList[index]);
        }
	}
}
