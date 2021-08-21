package com.bridgelabz.address;

import java.util.*;

public class AddressBookOptions {
    public static void getChoice(AddressBook addressBook) {
        Scanner sc = new Scanner(System.in);
        AddressBook book = new AddressBook();
        while (true) {
            System.out.println("enter the number to do following operation");
            System.out.println("1.Add   2.Edit    3.Show   4..Delete  5.back to main menu 6.exit");
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
                case 5:
                    return;
                default:
                    System.exit(0);
                    break;
            }
        }
    }
}

