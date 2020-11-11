package com.tsb.frogger.data;

import java.io.*;
import java.util.ArrayList;

/**
 * File class to manage all save game related methods
 */
class FileGame {

    private static final String DATA_PATH = "src/main/resources/com/tsb/frogger/save/saveGame.ser";

    static void createFile(){
        File file;
        try{
            file = new File(DATA_PATH);
            if (file.createNewFile()) {
                ArrayList<Player> players = new ArrayList<>();
                players.add(new Player());
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
}
