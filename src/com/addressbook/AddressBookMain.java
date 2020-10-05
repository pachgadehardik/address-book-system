package com.addressbook;

import java.awt.DisplayMode;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

public class AddressBookMain {
	
	//Usecase 1 and 2 - creating address book and adding contacts in them
	//Adding UseCase 3 - Edit the person details using name
	//Adding Usecase 4 -deleting person info using name
	//Adding Usecase 6- Multiple Address Books
	static final int ADD_CONTACT = 1;
	static final int EDIT_CONTACT = 2;
	static final int DELETE_CONTACT =3;
	static final int ADD_MULTIPLE_CONTACT = 4;
	static final int ADD_MULTIPLE_ADDRESS_BOOK = 5;
	static final int SEARCH_BY_CITY_OR_STATE = 6;
	static final int SEARCH_BY_NAME_CITY_STATE = 7;
	static final int COUNT_BY_CITY_STATE = 8;
	static final int SORT_BY_NAME = 9;
	public static void showMenu() {
		System.out.println("Welcome to Address Book System!\n");
		System.out.println("Enter the option: ");
		System.out.println("1-Add Contact");
		System.out.println("2-Edit Contact");
		System.out.println("3-Delete Contact");
		System.out.println("4-Add Multiple Contacts");
		System.out.println("5-Add Multiple Address Books");
		System.out.println("6-Search By City or State");
		System.out.println("7-Search By Name,City and State");
		System.out.println("8-Count Contacts By City or State");
		System.out.println("9-Sort the Contacts by Name");
		System.out.println("0-Exit the System");
	}
	
	public static void main(String args[]) {
		//Creating an AddressBook First
		
		AddressBookFunctions addressBookFunctions = new AddressBookFunctions();
		
		AddressBook addressBook = new AddressBook();
		addressBookFunctions.initializeAddressBook(addressBook);
		
//		Dictionary<String, AddressBook> dictionaryAddressBooks = new Hashtable<String, AddressBook>();
		Map<String, AddressBook> mapAddressNametoBook = new HashMap<String, AddressBook>();
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		while(flag) {
			showMenu();
			int option = sc.nextInt();
			switch(option) {
			case ADD_CONTACT:
				
				ContactDetails contactRecord = new ContactDetails();
				contactRecord = addressBookFunctions.getDetails(addressBook);
				//Before adding Check whether person exists or not 
				if(!addressBookFunctions.checkWhetherPersonExistsinAddressBook(contactRecord,addressBook)){
				System.out.println("Cool!!");
//				addressBookFunctions.addContacts(addressBook, contactRecord);
				addressBookFunctions.addContactsToAddressBook(addressBook, contactRecord);
				
				System.out.println(contactRecord);
				System.out.println("SuccessFully Added!!");
					}
				else {
					System.out.println("Name Already Present!!!");
				}
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
			case DELETE_CONTACT:
				String inputName = addressBookFunctions.locateNameContactForEditing(addressBook);
				addressBookFunctions.deleteContacts(inputName, addressBook);
				
			case ADD_MULTIPLE_CONTACT: //USECASE 6
				System.out.println("How many Contact to add in AddressBook?");
				int countContact = sc.nextInt();
				addressBookFunctions.addMultipleContacts(addressBook,countContact);
			case ADD_MULTIPLE_ADDRESS_BOOK: //USECASE 7
				System.out.println("How many address book to add?");
				int countBook = sc.nextInt();
				addressBookFunctions.addMultipleAddressBooks(countBook,addressBook, mapAddressNametoBook);
				break;
			case SEARCH_BY_CITY_OR_STATE: //USECASE 9
				System.out.println("Enter the state or city: ");
				String city = sc.next();
				String state = sc.next();
				addressBookFunctions.searchContactByCityOrState(city,state,addressBook,mapAddressNametoBook);
				break;
			case SEARCH_BY_NAME_CITY_STATE: //USECASE 8
				System.out.println("Enter the Name of the person");
				String personName = sc.next();
				System.out.println("Enter the state or city: ");
				String city1 = sc.next();
				String state1 = sc.next();
				addressBookFunctions.searchContactByName_City_State(personName,city1,state1,addressBook,mapAddressNametoBook);
				break;
			case COUNT_BY_CITY_STATE:
				System.out.println("Enter the state or city: ");
				String city2 = sc.next();
				String state2 = sc.next();
				addressBookFunctions.countContacts(city2,state2,addressBook,mapAddressNametoBook);
				break;
			case SORT_BY_NAME:
				addressBookFunctions.sortContact(addressBook);
			default:
				flag = false;
				break;
			}
		}
		
		
		
	}


	
	
	
}
