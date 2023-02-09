package com.bridgelabz.addressbook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressBookDirectory implements AddressBookDirectoryIF {
   
	public AddressBook addressBook;
    Scanner scannerObject = new Scanner(System.in);
    Map<String,AddressBook> addressBookDirectory = new HashMap<String,AddressBook>();
    
    public void operationDirectory() {
    
    	boolean moreChanges = true;
    	do {
    		System.out.println("\nChoose the operation on the Directory you want to perform");
    		System.out.println(
    				"1.Add an Address Book\n2.Edit Existing Address Book\n3.Search Person By City\n4.Search Person By State\n5.View By City\n6.View By State\n7.Display Address book Directory\n8.Exit Address book System");
    		
    		switch (scannerObject.nextInt()) {
    		case 1:
    			addAddressBook();
    			AddressBook addressBook1=new AddressBook();
    			addressBook1.operation();
    			break;
    		case 2:
    			editAddressBook();
    			AddressBook addressBook2=new AddressBook();
    			break;
    		case 3:
    			searchByCity();
    			break;
    		case 4:
    			searchByState();
    			break;
    		case 5:
    			displayPeopleByRegion(AddressBook.personByCity);
    			break;
    		case 6:
    			displayPeopleByRegion(AddressBook.personByState);
    			break;
    		case 7:
    			displayDirectoryContents();
    			break;
    		case 8:
    			moreChanges = false;
    			System.out.println("Exiting Address Book Directory !");
    		}
    	} while(moreChanges);
    }	
    public void addAddressBook() {
    	System.out.println("Enter the name of the Address Book you want to add");
    	String bookNameToAdd = scannerObject.next();
    	if (addressBookDirectory.containsKey(bookNameToAdd)) {
    		System.out.println("Book Name Already Exists");
    		return;
    	}
    	AddressBook addressBook = new AddressBook();
    	addressBook.setAddressBookName(bookNameToAdd);
    	addressBookDirectory.put(bookNameToAdd, addressBook);
    }
    public void editAddressBook() {
    	System.out.println("Enter the Name of the Address Book which you want to edit:");
    	String addressBookToEdit = scannerObject.next();	
    	if (addressBookDirectory.containsKey(addressBookToEdit)) {
    		addressBook = addressBookDirectory.get(addressBookToEdit);
    		AddressBook addressBook2 =new AddressBook();
    		addressBook2.editPerson();
    		addressBook.operation();
    	} else {
    		System.out.println("Book Does Not Exist");
    	}
    }
    public void searchByCity() {
    	System.out.println("Enter the name of the City where the Person resides : ");
    	String cityName = scannerObject.next();
    	System.out.println("Enter the name of the Person : ");
    	String personName = scannerObject.next();	
    	for (AddressBook addressBook : addressBookDirectory.values()) {
    		for (ContactDetails person : addressBook.getContact()) {
    			if (person.getFirstName().equals(personName) && person.getaddress().getCity().equals(cityName)) {
    				System.out.println(personName + " Found in Address Book : " + addressBook.getAddressBookName() + " !");
    				System.out.println(person);
    				return;
    			}
    		}
    	}
    	System.out.println("Contact Does Not Exist !!");
    }
    public void searchByState() {
    	
    	System.out.println("Enter the name of the State where the Person resides : ");
    	String StateName = scannerObject.next();
    	System.out.println("Enter the name of the Person : ");
    	String personName = scannerObject.next();	
    	for (AddressBook addressBook : addressBookDirectory.values()) {
    		for (ContactDetails person : addressBook.getContact()) {
    			if (person.getFirstName().equals(personName) && person.getaddress().getState().equals(StateName)) {
    				System.out.println(personName + " Found in Book : " + addressBook.getAddressBookName() + " !");
    				System.out.println(person);
    				return;
    			}
    		}
    	}
    	System.out.println("Contact Does Not Exist !!");
    }
    public void displayPeopleByRegion(HashMap<String, ArrayList<ContactDetails>> listToDisplay) {
    	
    	ArrayList<ContactDetails> list;
    	for (String name : listToDisplay.keySet()) {
    		System.out.println("People residing in: " + name);
    		list = listToDisplay.get(name);
    		for (ContactDetails contact : list) {
    			System.out.println(contact);
    		}
    	}
    }
    public void displayDirectoryContents() {
    	
    	System.out.println("----- Contents of the Address Book Directory-----");
    	for (String eachBookName : addressBookDirectory.keySet()) {
    		System.out.println(eachBookName);
    	}
    }
}	