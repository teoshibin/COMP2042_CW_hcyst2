package com.tsb.frogger.utils.data.filemanager;

import com.tsb.frogger.utils.data.datastructure.Player;
import com.tsb.frogger.utils.data.datastructure.SavedData;
import com.tsb.frogger.utils.game.LevelSelector;

import java.io.IOException;
import java.io.Serializable;
import java.nio.file.NoSuchFileException;

/**
 * save game manager class for player info storing and loading
 */
public class SaveGameManager extends SerialManager {
    /**
     * load game from file
     *
     * @param filename file name
     * @return deserialized saved data object
     * @throws IOException fail to load file
     * @throws ClassNotFoundException fail to deserialize
     */
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

    /**
     * save game into file
     *
     * @param data serializable data object
     * @param filename file name
     * @throws IOException fail to save file
     */
    public static void saveGame(Serializable data, String filename) throws IOException {
        saveSerialized(data, filename);
    }

    /**
     * create a new save file
     *
     * @param filename file name
     * @return newly created save data object
     * @throws IOException fail to save file
     */
    private static SavedData createSaveFile(String filename) throws IOException {
        SavedData newSave = new SavedData();
        saveSerialized(newSave, filename);
        return newSave;
    }

    /**
     * handle previous save file corruption due to new changes in levels
     *
     * @param savedData serialized data
     * @param filename file name
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
