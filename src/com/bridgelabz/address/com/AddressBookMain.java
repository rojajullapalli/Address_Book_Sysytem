package com.bridgelabz.address.com;

import java.util.*;
import java.util.stream.Collectors;

public class AddressBookMain {
    Scanner scanner = new Scanner(System.in);
    HashMap<String, LinkedList<Contacts>> contactBook = new HashMap<>();

    public void createContact(LinkedList<Contacts> contactList, HashMap<String, LinkedList<Contacts>> contactBook, String addressBook) {
        boolean run = true;
        while (run) {
            System.out.println("\nWhat would u like to do with contacts? \n1. Add\n2. Display\n3. Edit\n4. Remove\n5.Back To Main Menu");
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

    public int searchName(String searchName, LinkedList<Contacts> contactList) {
        for (int index = 0; index < contactList.size(); index++) {
            if (contactList.get(index).getFirstName().equals(searchName))
                return index;
        }
        return -1;
    }

    private LinkedList<Contacts> addContact(LinkedList<Contacts> contactList) {
        System.out.println("Enter following details\nFirst Name :");
        String firstName = scanner.next();
        int existingName = searchName(firstName, contactList);
        if (existingName == -1) {
            Contacts contact = new Contacts();
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

            contact.setFirstName(firstName);
            contact.setLastName(lastName);
            contact.setCity(city);
            contact.setAddress(address);
            contact.setState(state);
            contact.setZipCode(zip);
            contact.setPhoneNumber(phoneNo);
            contact.setEmail(email);
            contactList.add(contact);
        } else
            System.out.println("Name already exists");
        return contactList;
    }

    private void displayContact(LinkedList<Contacts> contactList) {
        System.out.println("All contact =  " + contactList.size());
        System.out.println(contactList);
    }

    private void editContact(LinkedList<Contacts> contactList) {
        System.out.println("Enter a name you want to edit...");
        String searchName = scanner.next();
        int editName = searchName(searchName, contactList);
        if (editName == -1)
            System.out.println("Name not found");
        else {
            Contacts contact = contactList.get(editName);
            System.out.println(contact);
            System.out.println("What do you want to edit\n1. Last Name\n2. Address\n3. City\n4. State\n5. Zip code\n6. Phone Number\n7. Email");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter new Last Name");
                    String newLastName = scanner.next();
                    contact.setLastName(newLastName);
                    break;
                case 2:
                    System.out.println("Enter new Address");
                    String newAddress = scanner.next();
                    contact.setAddress(newAddress);
                    break;
                case 3:
                    System.out.println("Enter new City");
                    String newCity = scanner.next();
                    contact.setCity(newCity);
                    break;
                case 4:
                    System.out.println("Enter new State");
                    String newState = scanner.next();
                    contact.setState(newState);
                    break;
                case 5:
                    System.out.println("Enter new Zip code");
                    String newZip = scanner.next();
                    contact.setZipCode(newZip);
                    break;
                case 6:
                    System.out.println("Enter new Phone Number");
                    String newPhoneNo = scanner.next();
                    contact.setPhoneNumber(newPhoneNo);
                    break;
                case 7:
                    System.out.println("Enter new Email");
                    String newEmail = scanner.next();
                    contact.setEmail(newEmail);
                    break;
            }
            System.out.println("Contact edited Successfully");
        }
    }

    private void deleteContact(LinkedList<Contacts> contactList) {
        System.out.println("Enter a name you want to delete...");
        String searchName = scanner.next();
        int deleteName = searchName(searchName, contactList);
        if (deleteName == -1)
            System.out.println("Name not found");
        else {
            contactList.remove(deleteName);
            System.out.println("contact deleted successfully");
        }
    }

    public void searchLocation(String state){
        contactBook.keySet().forEach(entry -> {
            List<Contacts> searchLocation = contactBook.get(entry).stream()
                    .filter(s->s.getState().equals(state))
                    .collect(Collectors.toList());
            System.out.println("the number of persons in "+entry+" is "+searchLocation.size());
            System.out.println(searchLocation);
        });
    }

    public void sortPerson() {
        System.out.println("Press 1 to sort person by First Name");
        System.out.println("Press 2 to sort person by City");
        System.out.println("Press 3 to sort person by State");
        int choice = scanner.nextInt();
        switch(choice) {
            case 1:
                System.out.println("sorted by FirstName");
                contactBook.keySet().forEach(entry -> {
                    List<Contacts> firstNameSort = contactBook.get(entry).stream()
                            .sorted(Comparator.comparing(Contacts::getFirstName))
                            .collect(Collectors.toList());
                    System.out.println(firstNameSort);
                });
                break;
            case 2:
                System.out.println("Sorted based on City");
                contactBook.keySet().forEach(entry -> {
                    List<Contacts> citySort = contactBook.get(entry).stream()
                            .sorted(Comparator.comparing(Contacts::getCity))
                            .collect(Collectors.toList());
                    System.out.println(citySort);
                });
                break;
            case 3:
                System.out.println("sorted based on state");
                contactBook.keySet().forEach(entry -> {
                    List<Contacts> stateSort = contactBook.get(entry).stream()
                            .sorted(Comparator.comparing(Contacts::getState))
                            .collect(Collectors.toList());
                    System.out.println(stateSort);
                });
                break;
            default:
                break;
        }
    }

}
