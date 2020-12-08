package com.tsb.frogger.utils.files.datastructure;

import java.io.Serializable;
import java.util.ArrayList;

public class SavedData implements Serializable {

    public ArrayList<Player> allPlayers;
    public Settings settings;

    public SavedData(){
        allPlayers = new ArrayList<>(1);
        allPlayers.add(new Player());
        settings = new Settings();
    }

    @Override
    public String toString() {
        return "SavedData{" +
                "allPlayers=" + allPlayers +
                '}';
    }
}
