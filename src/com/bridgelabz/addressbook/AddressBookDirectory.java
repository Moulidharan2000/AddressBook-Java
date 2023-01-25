package com.bridgelabz.addressbook;

import java.util.Scanner;

public class AddressBookDirectory {
	private static final int NUM_OF_ADDRESS_BOOKS = 5;
    Scanner scan = new Scanner(System.in);
    AddressBook[] addressBookDirectory = new AddressBook[NUM_OF_ADDRESS_BOOKS];
    int numOfAddressBooks = 0;

    public void operationDirectory() {

        boolean moreChanges = true;
        do{

            System.out.println("\nChoose the operation on the Directory you want to perform");
            System.out.println("1.Add an Address Book\n2.Edit Existing Address Book\n3.Display Address book Directory\n4.Exit Address book System");

            switch (scan.nextInt()) {
                case 1:
                    addAddressBook();
                    AddressBook operation = new AddressBook();
                    operation.AddContacts();
                    break;
                case 2:
                    editAddressBook();
                    AddressBook operation1 = new AddressBook();
                    operation1.DeletePerson();
                    break;
                case 3:
                    displayDirectoryContents();
                    AddressBook operation2 = new AddressBook();
                    operation2.DisplayContacts();
                    break;
                case 4:
                    moreChanges = false;
                    System.out.println("BYE !");
            }

        }while(moreChanges);
    }

    public void addAddressBook() {

        System.out.println("You can add only "+(NUM_OF_ADDRESS_BOOKS-numOfAddressBooks)+" books");

        String addressBookName = "";

        if(numOfAddressBooks == 0) {
            System.out.println("Enter the name of the Address Book you want to add");
            addressBookName = scan.next();
            AddressBook newAddressBook = new AddressBook();
            addressBookDirectory[numOfAddressBooks] = newAddressBook;
            numOfAddressBooks++;

        }

        else {

            boolean bookExists = false;
            for(int index=0; index < numOfAddressBooks ; index++) {

                System.out.println("Enter the name of the Address Book you want to add");
                addressBookName = scan.next();
                AddressBook addressBook = addressBookDirectory[index];

                if(addressBookName.equals(addressBook)) {
                    bookExists = true;
                }

            }
            if(bookExists) {
                System.out.println("Address Book with same name already exists");
                return;
            }
            else {
                AddressBook newAddressBook = new AddressBook();
               addressBookDirectory[numOfAddressBooks] = newAddressBook;
                numOfAddressBooks++;
            }
        }
    }

    public void editAddressBook() {
        System.out.println("Enter the Name of the Address Book which you want to edit:");
        String addressBookName = new String();

        for(int index = 0; index <numOfAddressBooks; index++) {

            AddressBook addressBook = addressBookDirectory[index];

            if(addressBookName.equals(addressBook)) {
                addressBook.Options();
            }
        }
    }

    public void displayDirectoryContents() {

        System.out.println("----- Contents of the Address Book Directory-----");
        for(int index=0; index < numOfAddressBooks ; index++) {
            System.out.println(addressBookDirectory[index]);

        }
    }
}