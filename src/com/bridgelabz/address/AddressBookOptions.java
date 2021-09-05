package com.bridgelabz.address;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBookOptions extends AddressBook{
    public ArrayList<Contacts> operation() {
        Scanner sc = new Scanner(System.in);
        boolean option = true;
        while (option) {
            System.out.println("enter the number to do following operation");
            System.out.println("1.Add   2.Edit    3.Show   4..Delete  5.back to main menu");
            int input = sc.nextInt();

            switch (input) {
                case 1:
                    add();
                    break;

                case 2:
                    editContact();
                    break;

                case 3:
                    showContact();
                    break;

                case 4:
                    delete();
                    break;
                default:
                    option = false;
            }
        }
        return contactList;
    }
}
