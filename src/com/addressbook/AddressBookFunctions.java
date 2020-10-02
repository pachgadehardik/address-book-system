package com.addressbook;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

//import addressbook.ContactDetails;

//import addressbook.ContactDetails;

public class AddressBookFunctions implements AddBookInterface {

	Scanner sc = new Scanner(System.in);
	public void createAddressBook(AddressBook addressBook) {
		addressBook.setContactRecord(new HashMap<>());
	}

	public ContactDetails getDetails(AddressBook addressBook) {
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
		contactRecord.keySet().contains(contactDetails.getfName());
		contactRecord.put(contactDetails.getfName(),contactDetails);
//		System.out.println(contactRecord);
	}
	
	
	
	
	public String locateNameContactForEditing(AddressBook addressBook){ 
		Map<String, ContactDetails> contact = addressBook.getContactRecord();
		System.out.println("Enter the first Name");
		String inputName =sc.nextLine().trim();
		
		if(contact.containsKey(inputName)) {
			System.out.println("Contact Exists");
			return inputName;
		}
		System.out.println("No such contact Exists");
			return null;
	}
	
	public void displayContact(AddressBook addressBook) {
		System.out.println(addressBook.getContactRecord().toString());
	}
	
	public void displayDictionary(Dictionary<String , AddressBook> dictionaryAddressBook) {
		System.out.println(dictionaryAddressBook.toString());
	}
	
	@Override
	public void editContacts(String searchString, AddressBook addressBook, ContactDetails contact) {

		Map<String, ContactDetails> contacts = addressBook.getContactRecord();

		String comparingString = contact.getfName();
		// check if the new data added matches with existing key if yes then edit the
		// value part else add the object and delete the previous key object
		
		if (searchString.equals(comparingString)) {
			contacts.put(comparingString, contact);
		} else {
			contacts.remove(searchString);
			contacts.put(comparingString, contact);
		}

		addressBook.setContactRecord(contacts);
		System.out.println(contacts);
	}
	
	public void printAddressBook(AddressBook addressBook) {
		System.out.println(addressBook.getContactRecord().toString());
	}
	
	
	public void initializeAddressBook(AddressBook addressBook) {
		addressBook.setContactRecord(new HashMap<>());
	}

	@Override
	public void addContacts(AddressBook addressBook, ContactDetails contact) {
//		 TODO Auto-generated method stub
		 	Map<String,ContactDetails> contactDetail = addressBook.getContactRecord();
		 	contactDetail.put(contact.getfName(),contact);
		 	addressBook.setContactRecord(contactDetail);
		
	}

	@Override
	public void deleteContacts(String inputName, AddressBook addressBook) {
		// TODO Auto-generated method stub
		Map<String,ContactDetails> contact = addressBook.getContactRecord();
		if(contact.containsKey(inputName)) {
			System.out.println("Contact Exists");
			printAddressBook(addressBook);
			contact.remove(inputName);
			printAddressBook(addressBook);
			System.out.println("deleted Successfully");
		}
		else
		System.out.println("Contact Does not Exist!!");
		
	}

	@Override
	public void addMultipleContacts(AddressBook addressBook, int countContact) {
		// TODO Auto-generated method stub
		if(countContact >0) {
			for(int i=1;i<=countContact;i++) {
				System.out.println("Enter for "+i+" person");
				ContactDetails contactDetails = getDetails(addressBook);
				addContactsToAddressBook(addressBook, contactDetails);
			}
			System.out.println("Successfully Added All "+countContact+" Contacts!" );
		}
		displayContact(addressBook);
		
	}
	
	public void addMultipleAddressBooks(int countBooks,AddressBook addressBook, Dictionary<String, AddressBook> dictionaryAddressBooks) {
		
		dictionaryAddressBooks.put("Hardik", addressBook);
		
		for(int i =1;i<=countBooks;i++) {
			System.out.println("Enter name of the addressBook: ");
			String addBookName = sc.next();
			AddressBook newAddressBook = new AddressBook();
			newAddressBook.setContactRecord(new HashMap<String, ContactDetails>());
			dictionaryAddressBooks.put(addBookName, newAddressBook);
//			initializeAddressBook(newAddressBook); 
			displayContact(newAddressBook);
		}
		
		System.out.println(dictionaryAddressBooks.get("Hardik"));
		displayContact(addressBook);
		System.out.println("Added multiple addressBooks!!");
		
	}

	@Override
	public void addMultipleAddressBooks(int countBooks) {
		// TODO Auto-generated method stub
		
	}

}