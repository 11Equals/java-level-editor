package com.sam.sample.level;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Load {
    public Load(File file) {
        java.io.File input = file.raw;

        if (input != null && input.canRead()) {
            try {
                FileInputStream fis = new FileInputStream(input);
                try {
                    ObjectInputStream ois = new ObjectInputStream(fis);

                    try {
                        Data test = (Data) ois.readObject();
                        System.out.println("Opened file and it contains: " + test.text);
                    } catch (ClassNotFoundException classNotFoundException) {
                        System.out.println("Class not found: " + classNotFoundException.getMessage());
                    }
                } catch (IOException ioException) {
                    System.out.println("IO Exception: " + ioException.getMessage() + " from file " + input.getName());
                }

            } catch (FileNotFoundException fileNotFoundException) {
                System.out.println("File not found: " + fileNotFoundException.getMessage());
            }
        }
    }
}
