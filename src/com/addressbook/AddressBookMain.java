package com.addressbook;

import java.util.Scanner;

public class AddressBookMain {
	
	//Usecase 1 and 2 - creating address book and adding contacts in them
	static final int ADD_CONTACT = 1;
	
	
	public static void main(String args[]) {
		System.out.println("Welcome to Address Book System!\n");
		System.out.println("Enter the option: ");
		System.out.println("1-Add Contact");
		System.out.println("0-Exit the System");
		
		
		//Creating an AddressBook First
		AddressBook addressBook = new AddressBook();
		AddressBookFunctions addressBookFunctions = new AddressBookFunctions();
		
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		while(flag) {
			int option = sc.nextInt();
			switch(option) {
			case 1:
				ContactDetails contactRecord = new ContactDetails();
				contactRecord = addressBookFunctions.addContacttoAddressRecord();
				addressBookFunctions.addContactsToAddressBook(addressBook, contactRecord);
				System.out.println(contactRecord);
				System.out.println("SuccessFully Added!!");
				break;
			default:
				flag = false;
				break;
			}
		}
		
	}
	
	
	
	
}
