package com.bridgelabz.addressbook;

public class AddressBookMain {

	public static void main(String[] args) {
		
		System.out.println("Welcome to Address Book Program");
		AddressBook addressBook = new AddressBook();
		addressBook.Options();
		addressBook.AddContacts();
		addressBook.EditContacts();
		addressBook.DeletePerson();
		addressBook.DisplayContacts();
		AddressBookDirectory Directory = new AddressBookDirectory();
	    Directory.operationDirectory();
	}
}
