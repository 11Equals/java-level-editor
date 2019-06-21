package com.sam.sample.level;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Save {
    public Save(File file) {
        java.io.File output = file.raw;

        boolean canWrite = false;

        if (output != null) {
            if (!output.exists()) {
                try {
                    if (output.createNewFile()) {
                        System.out.println("Successfully created new file");
                        canWrite = true;
                    } else {
                        System.out.println("Failed to create new file");
                    }
                } catch (IOException e) {
                    System.out.println("IOException: " + e.getMessage());
                }
            } else {
                canWrite = true;
            }
            if (canWrite) {
                System.out.println("Can write--starting binary output");
                try {
                    FileOutputStream fis = new FileOutputStream(output);
                    try {
                        ObjectOutputStream ois = new ObjectOutputStream(fis);
                        ois.writeObject(file.data);

                    } catch (IOException ioException) {
                        System.out.println("IO Exception: " + ioException.getLocalizedMessage() + " from file " + output.getName());
                    }

                } catch (FileNotFoundException fileNotFoundException) {
                    System.out.println("File not found: " + fileNotFoundException.getMessage());
                }
            }
        }
    }
}
