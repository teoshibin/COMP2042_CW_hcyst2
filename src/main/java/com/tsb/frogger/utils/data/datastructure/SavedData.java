package com.tsb.frogger.utils.data.datastructure;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * serializable data structure
 */
public class SavedData implements Serializable {
    /**
     * store all players
     */
    public ArrayList<Player> allPlayers;
    /**
     * store settings
     */
    public Settings settings;

    /**
     * default constructor for creation of new save file data structure
     */
    public SavedData(){
        allPlayers = new ArrayList<>(1);
        allPlayers.add(new Player());
        settings = new Settings();
    }

    /**
     * visualize data structure
     * @return string
     */
    @Override
    public String toString() {
        return "SavedData{" +
                "allPlayers=" + allPlayers +
                '}';
    }
}
