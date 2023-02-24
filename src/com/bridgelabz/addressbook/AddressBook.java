package com.bridgelabz.addressbook;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AddressBook implements AddressBookIF {
	
	 Scanner scannerObject = new Scanner(System.in);
	    public Map<String, ContactDetails> contactList = new HashMap<String,ContactDetails>();
	    public static HashMap<String, ArrayList<ContactDetails>> personByCity  = new HashMap<String, ArrayList<ContactDetails>>();
	    public static HashMap<String, ArrayList<ContactDetails>> personByState = new HashMap<String, ArrayList<ContactDetails>>();
	    public String addressBookName;
	    public boolean isPresent = false;

	    public String getAddressBookName() {
	        return addressBookName;
	    }
	    public void setAddressBookName(String addressBookName) {
	        this.addressBookName = addressBookName;
	    }
	    public ArrayList<ContactDetails> getContact() {
	        return new ArrayList<ContactDetails>(contactList.values());
	    }
	    public void operation() {
	        boolean moreChanges = true;
	        do {
	            System.out.println("\nChoose the operation you want to perform");
	            System.out.println(
	                    "1.Add To Address Book\n2.Edit Existing Entry\n3.Delete Contact\n4.Display Address book\n5.Display Sorted Address Book By Custom Criteria\n6.Write To File\n7.Read From File\n8.Exit Address book System");

	            switch (scannerObject.nextInt()) {
	                case 1:
	                    addContact();
	                    break;
	                case 2:
	                    editPerson();
	                    break;
	                case 3:
	                    deletePerson();
	                    break;
	                case 4:
	                    displayContents();
	                    break;
	                case 5:
	                    System.out.println("What Criteria Do You Want Address Book To Be Sorted In ?");
	                    System.out.println("1.FirstName\n2.City\n3.State\n4.Zip Code");
	                    int sortingChoice = scannerObject.nextInt();
	                    sortAddressBook(sortingChoice);
	                    break;
	                case 6:
	                    writeToAddressBookFile();
	                    System.out.println("Written To file");
	                    break;
	                case 7: readDataFromFile();
	                    break;
	                case 8:
	                    moreChanges = false;
	                    System.out.println("Exiting Address Book: "+this.getAddressBookName()+" !");
	            }
	        } while (moreChanges);
	    }
	    public void addContact() {
	    	ContactDetails person = new ContactDetails();
	        Address address = new Address();

	        System.out.println("Enter First Name: ");
	        String firstName = scannerObject.next();

	        contactList.entrySet().stream().forEach(entry -> {
	            if(entry.getKey().equals(firstName.toLowerCase())) {
	                System.out.println("Contact Already Exists");
	                isPresent = true;
	                return;
	            }
	        });
	        if(isPresent == false) {
	            System.out.println("Enter Last Name: ");
	            String lastName = scannerObject.next();

	            System.out.println("Enter Phone Number: ");
	            long phoneNumber = scannerObject.nextLong();

	            System.out.println("Enter Email: ");
	            String email = scannerObject.next();

	            System.out.println("Enter City: ");
	            String city = scannerObject.next();

	            System.out.println("Enter State: ");
	            String state = scannerObject.next();

	            System.out.println("Enter Zip Code: ");
	            long zipCode = scannerObject.nextLong();

	            person.setFirstName(firstName);
	            person.setLastName(lastName);
	            person.setphoneNumber(phoneNumber);
	            person.setEmail(email);
	            address.setCity(city);
	            address.setState(state);
	            address.setZipCode(zipCode);
	            person.setAddress(address);
	            addPersonToCity(person);
	            addPersonToState(person);
	            contactList.put(firstName.toLowerCase(), person);
	        }
	    }
	    public void addPersonToCity(ContactDetails contact) {
	        if (personByCity.containsKey(contact.getaddress().getCity())) {
	            personByCity.get(contact.getaddress().getCity()).add(contact);
	        }
	        else {
	            ArrayList<ContactDetails> cityList = new ArrayList<ContactDetails>();
	            cityList.add(contact);
	            personByCity.put(contact.getaddress().getCity(), cityList);
	        }
	    }
	    public void addPersonToState(ContactDetails contact) {
	        if (personByState.containsKey(contact.getaddress().getState())) {
	            personByState.get(contact.getaddress().getState()).add(contact);
	        }
	        else {
	            ArrayList<ContactDetails> stateList = new ArrayList<ContactDetails>();
	            stateList.add(contact);
	            personByState.put(contact.getaddress().getState(), stateList);
	        }
	    }
	    public void editPerson() {
	    	ContactDetails person = new ContactDetails();
	        System.out.println("Enter the first name:");
	        String firstName = scannerObject.next();

	        if(contactList.containsKey(firstName)) {
	            person = contactList.get(firstName);
	            Address address = person.getaddress();
	            System.out.println("\nChoose the attribute you want to change:");
	            System.out.println("1.Last Name\n2.Phone Number\n3.Email\n4.City\n5.State\n6.ZipCode");
	            int choice = scannerObject.nextInt();

	            switch (choice) {
	                case 1:
	                    System.out.println("Enter the correct Last Name :");
	                    String lastName = scannerObject.next();
	                    person.setLastName(lastName);
	                    break;
	                case 2:
	                    System.out.println("Enter the correct Phone Number :");
	                    long phoneNumber = scannerObject.nextLong();
	                    person.setphoneNumber(phoneNumber);
	                    break;
	                case 3:
	                    System.out.println("Enter the correct Email Address :");
	                    String email = scannerObject.next();
	                    person.setEmail(email);
	                    break;
	                case 4:
	                    System.out.println("Enter the correct City :");
	                    String city = scannerObject.next();
	                    address.setCity(city);
	                    break;
	                case 5:
	                    System.out.println("Enter the correct State :");
	                    String state = scannerObject.next();
	                    address.setState(state);
	                    break;
	                case 6:
	                    System.out.println("Enter the correct ZipCode :");
	                    long zip = scannerObject.nextLong();
	                    address.setZipCode(zip);
	                    break;
	            }
	        }
	        else {
	            System.out.println("Book Does Not Exist");
	        }
	    }
	    public void deletePerson() {
	        System.out.println("Enter the first name of the person to be deleted");
	        String firstName = scannerObject.next();
	        if(contactList.containsKey(firstName)) {
	            contactList.remove(firstName);
	            System.out.println("Successfully Deleted");
	        }
	        else {
	            System.out.println("Contact Not Found!");
	        }
	    }
	    public void displayContents() {
	        System.out.println("----- Contents of the Address Book "+this.getAddressBookName()+" -----");
	        for (String eachContact : contactList.keySet()) {
	        	ContactDetails person = contactList.get(eachContact);
	            System.out.println(person);
	        }
	        System.out.println("-----------------------------------------");
	    }
	    public void printSortedList(List<ContactDetails> sortedContactList) {
	        System.out.println("------ Sorted Address Book "+this.getAddressBookName()+" ------");
	        Iterator iterator = sortedContactList.iterator();
	        while (iterator.hasNext()) {
	            System.out.println(iterator.next());
	            System.out.println();
	        }
	        System.out.println("-----------------------------------------");
	    }
	    public void sortAddressBook(int sortingChoice) {
	        List<ContactDetails> sortedContactList;
	        switch(sortingChoice) {
	            case 1: sortedContactList = contactList.values().stream()
	                    .sorted((firstperson, secondperson) -> firstperson.getFirstName().compareTo(secondperson.getFirstName()))
	                    .collect(Collectors.toList());
	                printSortedList(sortedContactList);
	                break;
	            case 2: sortedContactList = contactList.values().stream()
	                    .sorted((firstperson, secondperson) -> firstperson.getaddress().getCity().compareTo(secondperson.getaddress().getCity()))
	                    .collect(Collectors.toList());
	                printSortedList(sortedContactList);
	                break;
	            case 3: sortedContactList = contactList.values().stream()
	                    .sorted((firstperson, secondperson) -> firstperson.getaddress().getState().compareTo(secondperson.getaddress().getState()))
	                    .collect(Collectors.toList());
	                printSortedList(sortedContactList);
	                break;
	            case 4: sortedContactList = contactList.values().stream()
	                    .sorted((firstperson, secondperson) -> Long.valueOf(firstperson.getaddress().getZipCode()).compareTo(Long.valueOf(secondperson.getaddress().getZipCode())))
	                    .collect(Collectors.toList());
	                printSortedList(sortedContactList);
	                break;
	        }
	    }
	    public void writeToAddressBookFile() {
	        String bookName = this.getAddressBookName();
	        String fileName = bookName+"BookName.txt";

	        StringBuffer addressBookBuffer = new StringBuffer();
	        contactList.values().stream().forEach(contact -> {
	            String personDataString = contact.toString().concat("\n");
	            addressBookBuffer.append(personDataString);
	        });
	        try {
	            Files.write(Paths.get(fileName), addressBookBuffer.toString().getBytes());
	        }
	        catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    public List<String> readDataFromFile() {
	        List<String> addressBookList = new ArrayList<String>();
	        String bookName = this.getAddressBookName();
	        String fileName = bookName+"BookName.txt";
	        System.out.println("Reading from : "+fileName+"\n");
	        try {
	            Files.lines(new File(fileName).toPath())
	                    .map(line -> line.trim())
	                    .forEach(employeeDetails -> {
	                        System.out.println(employeeDetails);
	                        addressBookList.add(employeeDetails);
	                    });
	        }
	        catch(IOException e){
	            e.printStackTrace();
	        }
	        return addressBookList;
	    }
	}