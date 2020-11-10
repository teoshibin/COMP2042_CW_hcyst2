package com.tsb.frogger.data;

import java.io.*;
import java.util.ArrayList;

/**
 * File class to manage all save game related methods
 */
public class GameFile {

    private static final String DATA_PATH = "src/main/resources/com/tsb/frogger/save/saveGame.ser";

    static void createFile(){
        File file;
        try{
            file = new File(DATA_PATH);
            if (file.createNewFile()) {
                ArrayList<Player> players = new ArrayList<>();
                players.add(new Player("Guest"));
                write(players);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void write(ArrayList<Player> users){
        try{
            FileOutputStream fos = new FileOutputStream(DATA_PATH);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(users);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    static ArrayList<Player> read(){
        ArrayList<Player> users = null;

        createFile();

        try{
            FileInputStream fis = new FileInputStream(DATA_PATH);
            ObjectInputStream ois = new ObjectInputStream(fis);
            users = (ArrayList<Player>) ois.readObject();
            ois.close();
            fis.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return users;
    }

//    public static void updateUsername(Object[] data){
//
//        createFile();
//
//        try {
//            FileWriter fw = new FileWriter(usernameDataPath);
//            fw.write(data);
//            fw.close();
//        } catch (IOException e) {
//            System.out.println("An error occurred.");
//            e.printStackTrace();
//        }
//    }

//    public static String readUsername() {
//        String data = "";
//        try{
//            File file = new File(DATA_PATH);
//            Scanner scanner = new Scanner(file);
//            data = scanner.nextLine();
//            scanner.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        return data;
//    }

//    public static void createFile() {
//        try{
//            File file = new File(DATA_PATH);
//
//            if (file.createNewFile()) {
//                FileWriter fw = new FileWriter(DATA_PATH);
//                fw.write("[]");
//                fw.close();
//                System.out.println("File created: " + file.getName());
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
