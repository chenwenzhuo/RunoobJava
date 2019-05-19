package com.hey_there.Serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializeDemo {
    public static void main(String[] args) {
        Employee e = null;

        File file = new File("src/com/hey_there/Serialization/employee.ser");
        FileInputStream fileIn = null;
        ObjectInputStream in = null;
        try {
            fileIn = new FileInputStream(file);
            in = new ObjectInputStream(fileIn);
            e = (Employee) in.readObject();
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Employee class not found");
            c.printStackTrace();
            return;
        } finally {
            if (null != in) {
                try {
                    in.close();
                } catch (IOException ex) {
                    System.out.println("Exception happened when closing in.");
                }
            }
            if (null != fileIn) {
                try {
                    fileIn.close();
                } catch (IOException ex) {
                    System.out.println("Exception happened when closing fileIn.");
                }
            }
        }
        if (file.exists()) {
            file.delete();
        }

        System.out.println("Deserialized Employee...");
        System.out.println("Name: " + e.name);
        System.out.println("Address: " + e.address);
        System.out.println("SSN: " + e.SSN);
        System.out.println("Number: " + e.number);
    }
}
