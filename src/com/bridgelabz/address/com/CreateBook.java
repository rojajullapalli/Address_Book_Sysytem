package com.bridgelabz.address.com;

import java.util.HashMap;
import java.util.LinkedList;

public class CreateBook extends AddressBookMain{
    public void CreateBook() {
        HashMap<String, LinkedList<Contacts>> contactBook = new HashMap<>();
        while (true) {
            System.out.println("\nWhat would you like to do? \n1. Create new address book \n2. Continue with existing address book \n3. All books\n4. Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter name for Address book");
                    String newBook = scanner.next();
                    LinkedList<Contacts> contactList = new LinkedList<>();
                    CreateContact(contactList, contactBook, newBook);
                    break;

                case 2:
                    System.out.println(contactBook.keySet());
                    System.out.println("Which address book do you want to access?");
                    String existingBook = scanner.next();

                    if (contactBook.containsKey(existingBook)) {
                        contactList = contactBook.get(existingBook);
                        CreateContact(contactList, contactBook, existingBook);
                    } else
                        System.out.println("Book not found");
                    break;

                case 3:
                    int i = 1;
                    for (String book : contactBook.keySet()) {
                        System.out.println(i + ". " + book);
                        i++;
                    }
                    System.out.println("\n" + contactBook);
                    break;
                default:
                    System.exit(0);
            }
        }
    }
}
