package com.addressbook;

import java.awt.DisplayMode;
import java.util.Scanner;

public class AddressBookMain {
	
	//Usecase 1 and 2 - creating address book and adding contacts in them
	//Adding UseCase 3 - Edit the person details using name
	static final int ADD_CONTACT = 1;
	static final int EDIT_CONTACT = 2;
	
	public static void main(String args[]) {
		System.out.println("Welcome to Address Book System!\n");
		System.out.println("Enter the option: ");
		System.out.println("1-Add Contact");
		System.out.println("2-Edit Contact");
		System.out.println("0-Exit the System");
		
		
		//Creating an AddressBook First
		AddressBook addressBook = new AddressBook();
		AddressBookFunctions addressBookFunctions = new AddressBookFunctions();
		
		addressBookFunctions.initializeAddressBook(addressBook);
		
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		while(flag) {
			int option = sc.nextInt();
			switch(option) {
			case ADD_CONTACT:
				ContactDetails contactRecord = new ContactDetails();
				contactRecord = addressBookFunctions.getDetails(addressBook);
//				addressBookFunctions.addContactsToAddressBook(addressBook, contactRecord);
				addressBookFunctions.addContacts(addressBook, contactRecord);
				System.out.println(contactRecord);
				System.out.println("SuccessFully Added!!");
				break;
			case EDIT_CONTACT:
//				System.out.println();
				String searchString = addressBookFunctions.locateNameContactForEditing(addressBook);
				if (searchString != null) {
					// get details for the new contact to be added
					ContactDetails contact = addressBookFunctions.getDetails(addressBook);
					// edit the contact in address-book
					addressBookFunctions.editContacts(searchString, addressBook, contact);
					System.out.println("SuccessFully Edited!!!");
				}
				System.out.println("Contact Does not Exist so cannot edit!!");
				break;
			default:
				flag = false;
				break;
			}
		}
		
		addressBookFunctions.printAddressBook(addressBook);
		
	}


	
	
	
}
