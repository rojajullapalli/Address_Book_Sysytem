package com.bridgelabz.address;

import java.util.Scanner;

public class AddressBookMain {
    public static void getChoice(){
        AddressBook book = new AddressBook();
        Scanner sc = new Scanner(System.in);
        book.add();
        System.out.println("enter the number to edit or exit");
        System.out.println("1.Edit 2.exit");
        int input = sc.nextInt();

        switch (input) {
            case 1:
                book.editContact();
            default:
                break;
        }


    }
    public static void main(String[] args) {
        System.out.println("Welcome to Address Book System");
        getChoice();

    }
}
