package com.bridgelabz.address;


import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {
    ArrayList<Contacts> contactList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public  ArrayList add() {

        //Takes input from user

        System.out.println("Enter First Name: ");
        String firstName = sc.nextLine();
        System.out.println("Enter last Name: ");
        String lastName = sc.nextLine();
        System.out.println("Enter your address: ");
        String address = sc.nextLine();
        System.out.println("Enter your city: ");
        String city = sc.nextLine();
        System.out.println("Enter your state: ");
        String state = sc.nextLine();
        System.out.println("Enter zip code of your area: ");
        String zipCode = sc.nextLine();
        System.out.println("Enter phone number: ");
        String phoneNum = sc.nextLine();
        System.out.println("Enter your EMail ID: ");
        String email = sc.nextLine();

        //calling the set method
        Contacts contact = new Contacts();
        contact.setFirstName(firstName);
        contact.setLastName(lastName);
        contact.setAddress(address);
        contact.setCity(city);
        contact.setState(state);
        contact.setZipCode(zipCode);
        contact.setPhoneNumber(phoneNum);
        contact.setEmail(email);
        contactList.add(contact);
        System.out.println(contact);
        return contactList;


    }

    public void editContact() {
        System.out.println("Enter First Name of Person to edit");
        String editName = sc.nextLine();
        boolean found=false;
        for (Contacts contact : contactList) {
            if (editName.equalsIgnoreCase(contact.getFirstName())) {
                found = true;
                System.out.println("Choose field you want to add:");
                System.out.println("1.Last Name    2.Phone Number     3.Address   4.State   5.City");
                System.out.println("6.Zip     7.Email");
                switch (sc.nextInt()) {
                    case 1: {
                        System.out.println("Re-Correct your lastname");
                        contact.setLastName(sc.next());
                        break;
                    }
                    case 2: {
                        System.out.println("Re-Correct your Phone Number");
                        contact.setPhoneNumber(sc.next());
                        break;
                    }
                    case 3: {
                        System.out.println("Re-Correct your Address");
                        contact.setAddress(sc.next());
                        break;
                    }
                    case 4: {
                        System.out.println("Re-Correct your State");
                        contact.setState(sc.next());
                        break;
                    }
                    case 5: {
                        System.out.println("Re-Correct your City");
                        contact.setCity(sc.next());
                        break;
                    }
                    case 6: {
                        System.out.println("Re-Correct your Zip");
                        contact.setZipCode(sc.next());
                        break;
                    }
                    case 7: {
                        System.out.println("Re-Correct your Email");
                        contact.setEmail(sc.next());
                        break;
                    }
                }
            }
        }
        if(found==true)
            showContact();
        else
            System.out.println("invalid contact");
    }
    public void showContact(){
        System.out.println("All contact =  " + contactList.size());
        System.out.println(contactList);

    }

    public void delete() {
        System.out.println("Enter First Name of Person to delete");
        String deleteName = sc.next();
        boolean found = false;
        for (int i = 0; i < contactList.size(); i++) {

            if (contactList.get(i).getFirstName().equals(deleteName)) {
                found = true;
                contactList.remove(i);
            }
        }
        if (found)
            System.out.println("Contact Deleted Successfully");
        else
            System.out.println("contact Not found");

    }

}