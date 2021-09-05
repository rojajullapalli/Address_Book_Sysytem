package com.bridgelabz.address;

import java.util.*;

public class AddressBookMain{
   public void addAddressBook(){
        HashMap<String, ArrayList<Contacts>> bookList = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            AddressBookOptions options = new AddressBookOptions();
            System.out.println("\n--------------------------Welcome to Address Book System--------------------------");
            System.out.println("1. New Address Book");
            System.out.println("2. Select Address Book");
            System.out.println("3. Exit");
            System.out.print("Enter Your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Enter name for Address book");
                    String addBookName = sc.next();

                    bookList.put(addBookName, options.operation());
                    break;


                case 2:
                    int i = 1;
                    for (String book : bookList.keySet()) {
                        System.out.println(i + ". " + book);
                        i++;
                    }

                    System.out.println("\n" + bookList);

                    break;

                default:
                    System.exit(0);

            }
        }
    }

}

