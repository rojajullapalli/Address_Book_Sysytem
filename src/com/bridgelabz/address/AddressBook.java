package com.bridgelabz.address;

import java.util.Scanner;

public class AddressBook {
    public  void add() {
        AddressBookMain add=new AddressBookMain();
        Contacts contact=new Contacts();
        Scanner sc=new Scanner(System.in);
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


        contact.setFirstName(firstName);
        contact.setLastName(lastName);
        contact.setAddress(address);
        contact.setCity(city);
        contact.setState(state);
        contact.setZipCode(zipCode);
        contact.setPhoneNumber(phoneNum);
        contact.setEmail(email);
        System.out.println(" FirstName = "+contact.getFirstName()+"\n LastName = "+contact.getLastName()+"\n Address = "+contact.getAddress()+"\n city = " +
                ""+contact.getCity() +"\n state = "+contact.getState()+"\n ZIP = "+contact.getZipCode()+"\n PhoneNumber = "+ contact.getPhoneNumber()+"\n Email = "
                + contact.getEmail());


    }

}
