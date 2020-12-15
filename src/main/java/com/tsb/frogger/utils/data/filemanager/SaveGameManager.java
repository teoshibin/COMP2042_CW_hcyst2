package com.tsb.frogger.utils.data.filemanager;

import com.tsb.frogger.utils.data.datastructure.Player;
import com.tsb.frogger.utils.data.datastructure.SavedData;
import com.tsb.frogger.utils.game.LevelSelector;

import java.io.IOException;
import java.io.Serializable;
import java.nio.file.NoSuchFileException;

public class SaveGameManager extends SerialManager {

    public static SavedData loadGame(String filename) throws IOException, ClassNotFoundException {
        SavedData loadedData;
        try {
            loadedData = (SavedData) loadSerialized(filename);
            rectifyScores(loadedData, filename);
        } catch (NoSuchFileException e){
            loadedData = createSaveFile(filename);
        }
        return loadedData;
    }

    public static void saveGame(Serializable data, String filename) throws IOException {
        saveSerialized(data, filename);
    }

    private static SavedData createSaveFile(String filename) throws IOException {
        SavedData newSave = new SavedData();
        saveSerialized(newSave, filename);
        return newSave;
    }

    /**
     * handle previous save file corruption due to new changes in levels
     *
     * @throws IOException io exception
     */
    private static void rectifyScores(SavedData savedData, String filename) throws IOException {
        for (Player player : savedData.allPlayers){
            while(player.getHighScores().size() > LevelSelector.MAX_LEVEL){
                player.getHighScores().remove(player.getHighScores().size() - 1);
            }
        }
        saveGame(savedData, filename);
    }
}
