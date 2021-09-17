package com.bridgelabz.address.com;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.LinkedList;

public class ReadWriteOperations {
    String filePath = "src/com/bridgelabz/address/com/addessBook.txt";

    public void writeInAddressBook(HashMap<String, LinkedList<Contacts>> contactBook) {
        StringBuffer empBuffer = new StringBuffer();
        contactBook.forEach( (addbook, contactInfo) -> {
            String empDataString = addbook.concat(contactInfo.toString().concat("\n"));
            empBuffer.append(empDataString);
        });

        try {
            Files.write(Paths.get(filePath) , empBuffer.toString().getBytes());
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void readFromAddressBook() {
        try {
            Files.lines(new File(filePath).toPath())
                    .forEach(System.out::println);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
