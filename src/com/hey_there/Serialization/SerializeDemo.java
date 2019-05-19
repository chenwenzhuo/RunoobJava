package com.hey_there.Serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializeDemo {
    public static void main(String[] args) {
        Employee e = new Employee();
        e.name = "Reyan Ali";
        e.address = "Phokka Kuan, Ambehta Peer";
        e.SSN = 11122333;
        e.number = 101;

        FileOutputStream fileOut = null;
        ObjectOutputStream out = null;
        try {
            fileOut =
                    new FileOutputStream("src/com/hey_there/Serialization/employee.ser");
            out = new ObjectOutputStream(fileOut);
            out.writeObject(e);

            System.out.println("Serialized data is saved in src/com/hey_there/Serialization/employee.ser");
        } catch (IOException ex) {
            System.out.println("Serializing failed.");
            return;
        } finally {
            if (null != out) {
                try {
                    out.close();
                } catch (IOException ex) {
                    System.out.println("Exception happened when closing out.");
                }
            }
            if (null != fileOut) {
                try {
                    fileOut.close();
                } catch (IOException ex) {
                    System.out.println("Exception happened when closing fileOut.");
                }
            }
        }

        System.out.println();
        DeserializeDemo.main(null);
    }
}
