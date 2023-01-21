package com.bridgelabz.addressbook;

public class AddressBookMain {

	public static void main(String[] args) {
		
		AddressBook addressBook = new AddressBook();
		addressBook.Options();
		addressBook.AddContacts();
		addressBook.EditContacts();
		addressBook.DisplayContacts();
	}
}
