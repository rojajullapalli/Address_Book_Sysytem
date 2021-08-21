package com.bridgelabz.address;

import java.util.Scanner;

public class AddressBookMain {

    public static void getChoice(){

        Scanner sc = new Scanner(System.in);
        AddressBook book = new AddressBook();
        while(true){
            System.out.println("enter the number to do following operation");
            System.out.println("1.Add   2.Edit    3.Show   4..Delete  5.exit");
            int input = sc.nextInt();

            switch (input) {
                case 1:
                    book.add();
                    break;

                case 2:
                    book.editContact();
                    break;

                case 3:
                    book.showContact();
                    break;

                case 4:
                    book.delete();
                    break;

                default:
                    System.exit(0);
                    break;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Address Book System");
        getChoice();

    }
}
