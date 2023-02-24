package com.bridgelabz.addressbook;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public interface AddressBookIF {
	
	 public void operation();

	    public void createContactPerson(Scanner scannerObject);

	    public void addContact(String firstName, ContactDetails person);

	    public void displayContents();

	    public void editPerson();

	    public void deletePerson();

	    public void addPersonToCity(ContactDetails contact);

	    public void addPersonToState(ContactDetails contact);

	    public void printSortedList(List<ContactDetails> sortedContactList);

	    public void sortAddressBook(int sortingChoice);

	    public void writeToAddressBookFile(AddressBook.IOService ioService);

	    public List<String> readDataFromFile(AddressBook.IOService fileIo);

	    public void writeDataToCSV() throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException;

	    public <CsvValidationException extends Throwable> void readDataFromCSV() throws IOException, CsvValidationException, com.opencsv.exceptions.CsvValidationException;
}
