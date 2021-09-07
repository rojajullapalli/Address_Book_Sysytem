package com.bridgelabz.address.com;

import java.util.*;

public class AddressBookMain {
    Scanner scanner = new Scanner(System.in);
    HashMap<String, LinkedList<Contacts>> contactBook = new HashMap<>();

    public void CreateContact(LinkedList<Contacts> contactList,
                                       HashMap<String, LinkedList<Contacts>> contactBook, String addressBook) {
            boolean run = true;
            while (run) {
                System.out.println("\nWhat would u like to do with contacts?\n1. Add\n2. Display\n3. Edit\n4. Remove\n5. Back to Main Menu");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        LinkedList<Contacts> multiContactInBook = addContact(contactList);
                        contactBook.put(addressBook, multiContactInBook);
                        break;
                    case 2:
                        displayContact(contactList);
                        break;
                    case 3:
                        editContact(contactList);
                        break;
                    case 4:
                        deleteContact(contactList);
                        break;
                    default:
                        run = false;
                }
            }

    }

    private static int searchName(String searchName,LinkedList<Contacts> contactList) {
            for (int index = 0; index < contactList.size(); index++) {
                if (contactList.get(index).getFirstName().equals(searchName))
                    return index;
            }
        return -1;
    }

    public LinkedList<Contacts> addContact(LinkedList<Contacts> contactList) {
            System.out.println("Enter following details \n" +
                    "First Name :");
            String firstName = scanner.next();

            int existingName = searchName(firstName, contactList);
            if (existingName == -1) {
                Contacts contactInfo = new Contacts();

                contactInfo.setFirstName(firstName);

                System.out.println("Last Name :");
                String lastName = scanner.next();
                System.out.println("Address :");
                String address = scanner.next();
                System.out.println("City :");
                String city = scanner.next();
                System.out.println("State :");
                String state = scanner.next();
                System.out.println("Zip Code :");
                String zip = scanner.next();
                System.out.println("Phone Number :");
                String phoneNo = scanner.next();
                System.out.println("Email :");
                String email = scanner.next();


                contactInfo.setFirstName(firstName);
                contactInfo.setLastName(lastName);
                contactInfo.setAddress(address);
                contactInfo.setCity(city);
                contactInfo.setState(state);
                contactInfo.setZipCode(zip);
                contactInfo.setPhoneNumber(phoneNo);
                contactInfo.setEmail(email);

                contactList.add(contactInfo);
            }
            else
                System.out.println("Name already exists");
        return contactList;
    }

    private void displayContact(LinkedList<Contacts> contactList) {
            System.out.println("All contact =  " + contactList.size());
            System.out.println(contactList);
    }

    private void editContact(LinkedList<Contacts> contactList) {
            System.out.println("Enter first name you want to edit");
            String searchName = scanner.next();
            int editName = searchName(searchName,contactList);

            if (editName == -1)
                System.out.println("Name not found");
            else {
                Contacts contactInfo = contactList.get(editName);
                System.out.println(contactInfo);

                System.out.println("What do you want to edit\n1. First Name\n2. Last Name\n3. Address\n4. City\n5. State\n6. Zip code\n7. Phone Number\n8. Email");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("Enter First Name to edit");
                        String newFirstName = scanner.next();
                        contactInfo.setFirstName(newFirstName);
                        break;
                    case 2:
                        System.out.println("Enter Last Name to edit");
                        String newLastName = scanner.next();
                        contactInfo.setLastName(newLastName);
                        break;
                    case 3:
                        System.out.println("Enter Address to edit");
                        String newAddress = scanner.next();
                        contactInfo.setAddress(newAddress);
                        break;
                    case 4:
                        System.out.println("Enter City to edit");
                        String newCity = scanner.next();
                        contactInfo.setCity(newCity);
                        break;
                    case 5:
                        System.out.println("Enter State to edit");
                        String newState = scanner.next();
                        contactInfo.setState(newState);
                        break;
                    case 6:
                        System.out.println("Enter Zip code to edit");
                        String newZip = scanner.next();
                        contactInfo.setZipCode(newZip);
                        break;
                    case 7:
                        System.out.println("Enter Phone Number to edit");
                        String newPhoneNo = scanner.next();
                        contactInfo.setPhoneNumber(newPhoneNo);
                        break;
                    case 8:
                        System.out.println("Enter Email to edit");
                        String newEmail = scanner.next();
                        contactInfo.setEmail(newEmail);
                        break;
                }
            }
            System.out.println("contact has been modified successfully");
    }

    private void deleteContact(LinkedList<Contacts> contactList) {
            System.out.println("Enter a name you want to delete");
            String searchname = scanner.next();
            int deleteName = searchName(searchname, contactList);

            if (deleteName == -1)
                System.out.println("Name not found");
            else {
                contactList.remove(deleteName);
                System.out.println("contact deleted successfully");
            }
    }
}
