package com.addressbook;

public class AddressBookMain {
	
	//Usecase 1 - creating contacts in address book
	public static void main(String args[]) {
		System.out.println("Welcome to Address Book System!");
		
		//Creating an AddressBook First
		AddressBook addressBook = new AddressBook();
		AddressBookFunctions addressBookFunctions = new AddressBookFunctions();
//		addressBookFunctions.createAddressBook(addressBook);
		
		ContactDetails contactRecord = new ContactDetails();
		contactRecord = addressBookFunctions.addContacttoAddressRecord();
		addressBookFunctions.addContactsToAddressBook(addressBook, contactRecord);
		
		System.out.println(contactRecord);
	}
	
	
	
	
}
