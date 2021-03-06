package com.bridgelabz.address.com;

import java.util.LinkedList;

public class CreateBook extends AddressBookMain{

    public void createBook() {
        ReadWriteOperations readWriteObj = new ReadWriteOperations();
        while (true) {
            System.out.println("\nWhat would you like to do? \n1. Crate new address book\n2. Continue with existing address book\n3. All books\n4. Search Location\n5. Sort\n6. Exit");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter name for Address book");
                    String addBook = scanner.next();
                    LinkedList<Contacts> contactList = new LinkedList<>();
                    if (contactBook.containsKey(addBook))
                        System.out.println("Book already exists");
                    else
                        createContact(contactList, contactBook, addBook);
                        readWriteObj.writeInAddressBook(contactBook);
                    break;
                case 2:
                    System.out.println(contactBook.keySet());
                    System.out.println("Enter the address book you want to access");
                    String existingBook = scanner.next();
                    if (contactBook.containsKey(existingBook)) {
                        contactList = contactBook.get(existingBook);
                        createContact(contactList, contactBook, existingBook);
                        readWriteObj.writeInAddressBook(contactBook);
                    } else
                        System.out.println("Book not found");
                    break;
                case 3:
                    readWriteObj.readFromAddressBook();
                    break;
                case 4:
                    System.out.println("Enter State to get name");
                    String Location = scanner.next();
                    searchLocation(Location);
                    break;
                case 5:
                    sortPerson();
                    break;
                default:
                    System.exit(0);
            }
        }

    }
}
