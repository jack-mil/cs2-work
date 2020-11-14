
package storedata;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

// Jackson Miller
// COSC2103 Computer Science 2
// 2020-11-13
// Assignment 17.5: Store data to a file
// This program takes a string and some integers and 
// stores them with the date in a file on disk
public class StoreData {

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        // Get user name
        System.out.print("Enter name: ");
        String name = input.nextLine();

        System.out.print("Enter 5 integers on this line: ");

        // Add 5 integers to an array
        ArrayList<Integer> data = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            data.add(input.nextInt());
        }

        // Write data to file
        try (ObjectOutputStream stream = new ObjectOutputStream(
                new BufferedOutputStream(new FileOutputStream("Exercise17_05.dat")))) {
            stream.writeUTF(name);
            stream.writeObject(data);
            stream.writeObject(new java.util.Date());
            stream.writeDouble(10.5);
        }

        input.close();
    }
}
