package com.tsb.frogger.data;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.ArrayList;

/**
 * get user info class
 */
public class FileUsername extends FileGame {

    /**
     * check duplication in list
     * @param players all players
     * @param name username
     * @return true when there is duplication
     */
    private static boolean checkDuplicate(ArrayList<Player> players, String name){
        for (Player player : players) {
            if(player.getUsername().equals(name)){
                return true;
            }
        }
        return false;
    }

    /**
     * read all usernames
     * @return username list
     */
    public static ObservableList<String> readUsernames(){
        ObservableList<String> nameList = FXCollections.observableArrayList();
        ArrayList<Player> players = read();
        if(players.size() > 0){
            for (Player player : players) {
                nameList.add(player.getUsername());
            }
        } else {
            nameList = FXCollections.observableArrayList();
        }
        return nameList;
    }

    /**
     * add username
     * @param name username
     * @return true when successfully executed
     */
    public static boolean addUsername(String name){
        ArrayList<Player> players = read();
        if(checkDuplicate(players, name) || name.equals("")){
            return false;
        } else {
            players.add(new Player(name));
            write(players);
            return true;
        }
    }

    /**
     * edit username
     * @param index player index
     * @param name new username
     * @return true when succesfully executed
     */
    public static boolean editUsername(int index, String name){
        ArrayList<Player> players = read();
        if(checkDuplicate(players, name) || name.equals("")){
            return false;
        } else {
            Player player = players.get(index);
            player.setUsername(name);
            players.set(index, player);
            write(players);
            return true;
        }
    }

    /**
     * delete username and its related records
     * @param index player index
     * @return true when successfully executed
     */
    public static boolean deleteUsername(int index){
        ArrayList<Player> players = read();
        if(index > 0 && players.size() > index){
            players.remove(index);
            write(players);
            return true;
        } else {
            return false;
        }
    }



}
