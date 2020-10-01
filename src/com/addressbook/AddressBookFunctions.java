package com.addressbook;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//import addressbook.ContactDetails;

public class AddressBookFunctions {


	public void createAddressBook(AddressBook addressBook) {
		addressBook.setContactRecord(new HashMap<>());
	}

	public ContactDetails addContacttoAddressRecord() {
		Scanner sc = new Scanner(System.in);
		ContactDetails contact = new ContactDetails();

		// Take user-input
		System.out.println("Enter the firstName:");
		contact.setfName(sc.next());
		System.out.println("Enter the lastName:");
		contact.setlName(sc.next());
		System.out.println("Enter the Address:");
		contact.setAddress(sc.next());
		System.out.println("Enter the city:");
		contact.setCity(sc.next());
		System.out.println("Enter the state:");
		contact.setState(sc.next());
		System.out.println("Enter the zipcode:");
		contact.setZip(sc.next().trim());
		System.out.println("Phone Number");
		contact.setMobNo(sc.next());
		System.out.println("Enter EmailID: ");
		contact.setEmailId(sc.next());

//		contact.setId(contact_id++);
		// Add to addressBook
		return contact;
	}
	public void addContactsToAddressBook(AddressBook addressBook, ContactDetails contactDetails) {
		Map<String,ContactDetails> contactRecord = new HashMap<String,ContactDetails>();
		contactRecord = addressBook.getContactRecord();
//		System.out.println(contactRecord);
	}
	
	
}
