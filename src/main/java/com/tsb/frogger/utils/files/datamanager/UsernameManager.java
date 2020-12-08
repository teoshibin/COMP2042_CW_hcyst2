package com.tsb.frogger.utils.files.datamanager;

import com.tsb.frogger.core.ConstantData;
import com.tsb.frogger.core.RuntimeData;
import com.tsb.frogger.utils.files.datastructure.Player;
import com.tsb.frogger.utils.files.filemanager.SaveGameManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.util.ArrayList;

/**
 * manage player username data between RuntimeData, saveGameManager and GUI
 */
public class UsernameManager {

    /**
     * convert player username list into observable list for listview
     *
     * @return observable lise
     */
    public static ObservableList<String> getObservableListUsername(){
        ObservableList<String> nameList = FXCollections.observableArrayList();
        if(RuntimeData.gameData.allPlayers.size() > 0){
            for (Player player : RuntimeData.gameData.allPlayers) {
                nameList.add(player.getUsername());
            }
        } else {
            nameList = FXCollections.observableArrayList();
        }
        return nameList;
    }

    /**
     * update currently selected username and index into runtime data for future direct access
     *
     * @param index player index
     */
    public static void setSelectedUsernameIndex(int index){
        if(validateSelection(true, index)){
            RuntimeData.selectedUsernameIndex = index;
        }
    }

    /**
     * get selected username
     *
     * @return username
     */
    public static String getSelectedUsername(){
        return RuntimeData.gameData.allPlayers.get(RuntimeData.selectedUsernameIndex).getUsername();
    }

    /**
     * add new username into runtime data and save it to the save file as well
     *
     * @param name username
     * @return true when successfully executed
     */
    public static boolean addUsername(String name) throws IOException {
        if(validateUsername(name)){
            RuntimeData.gameData.allPlayers.add(new Player(name));
            SaveGameManager.saveGame(RuntimeData.gameData, ConstantData.SAVE_FILE_PATH);
            return true;
        }
        return false;
    }

    /**
     * delete player
     *
     * @param index player index
     * @return true when successfully executed
     */
    public static boolean deleteUsername(int index) throws IOException {
        if(validateSelection(false, index)){
            RuntimeData.gameData.allPlayers.remove(index);
            SaveGameManager.saveGame(RuntimeData.gameData, ConstantData.SAVE_FILE_PATH);
            return true;
        }
        return false;
    }

    /**
     * update username
     *
     * @param index player index
     * @param name new username
     * @return true when successfully executed
     */
    public static boolean updateUsername(int index, String name) throws IOException {
        if(validateUsername(name) && validateSelection(false, index)){
            Player player = RuntimeData.gameData.allPlayers.get(index);
            player.setUsername(name);
            RuntimeData.gameData.allPlayers.set(index, player);
            SaveGameManager.saveGame(RuntimeData.gameData, ConstantData.SAVE_FILE_PATH);
            return true;
        }
        return false;
    }

    /**
     * validate new username
     *
     * @param name username
     * @return valid or invalid
     */
    private static boolean validateUsername(String name){
        return !(name.equals("") || name.length() > 30 || duplicated(RuntimeData.gameData.allPlayers, name));
    }

    /**
     * validate selected index is in correct range
     *
     * @param all include guest
     * @param index index
     * @return valid and invalid
     */
    private static boolean validateSelection(boolean all, int index){
        if(all){
            return (index >= 0 && index < RuntimeData.gameData.allPlayers.size());
        } else {
            return (index > 0 && index < RuntimeData.gameData.allPlayers.size());
        }
    }

    /**
     * check duplicated name in username list
     *
     * @param players all players
     * @param name username
     * @return true when there is duplication
     */
    private static boolean duplicated(ArrayList<Player> players, String name){
        for (Player player : players) {
            if(player.getUsername().equals(name)){
                return true;
            }
        }
        return false;
    }


}
