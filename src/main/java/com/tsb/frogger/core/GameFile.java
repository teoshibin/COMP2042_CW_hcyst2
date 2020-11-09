package com.tsb.frogger.core;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * File class to manage all save game related methods
 */
public class GameFile {

    private static final String usernameDataPath = "src/main/resources/com/tsb/frogger/save/player.txt";


    /**
     * update username data from gui to file
     * @param data usernames
     */
    public static void updateUsername(String data){

        createFile();

        try {
            FileWriter fw = new FileWriter(usernameDataPath);
            fw.write(data);
            fw.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /**
     * read usernames
     * @return usernames
     */
    public static String readUsername() {
        String data = "";
        try{
            File file = new File(usernameDataPath);
            Scanner scanner = new Scanner(file);
            data = scanner.nextLine();
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return data;
    }

    public static void createFile() {
        try{
            File file = new File(usernameDataPath);

            if (file.createNewFile()) {
                FileWriter fw = new FileWriter(usernameDataPath);
                fw.write("[]");
                fw.close();
                System.out.println("File created: " + file.getName());
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
