package com.bridgelabz.addressbook;

import java.util.ArrayList;
import java.util.Iterator;

public class AddressBook {
	
	
	ArrayList<ContactDetails> contactList = new ArrayList<ContactDetails>();
		
	public void AddContacts(ContactDetails person) {
		contactList.add(person);
	}
}
