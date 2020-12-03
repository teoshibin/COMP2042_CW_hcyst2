package com.tsb.frogger.utils.files;

import java.io.*;
import java.util.ArrayList;

/**
 * File class to manage all save game related methods
 */
class FileGame {

    /**
     * data path
     */
    private static String DATA_PATH = "src/main/resources/com/tsb/frogger/save/saveGame.ser";

    /**
     * create file if not exist
     */
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

    /**
     * write data
     * @param users players
     */
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

    /**
     * read data
     * @return players
     */
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
