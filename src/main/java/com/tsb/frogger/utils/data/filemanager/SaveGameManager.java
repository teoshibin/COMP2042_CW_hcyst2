package com.tsb.frogger.utils.data.filemanager;

import com.tsb.frogger.utils.data.datastructure.SavedData;

import java.io.IOException;
import java.io.Serializable;
import java.nio.file.NoSuchFileException;

public class SaveGameManager extends FileManager {

    public static SavedData loadGame(String filename) throws IOException, ClassNotFoundException {
        SavedData loadedData;
        try {
            loadedData = (SavedData) load(filename);
        } catch (NoSuchFileException e){
            loadedData = createSaveFile(filename);
        }
        return loadedData;
    }

    public static void saveGame(Serializable data, String filename) throws IOException {
        save(data, filename);
    }

    private static SavedData createSaveFile(String filename) throws IOException {
        SavedData newSave = new SavedData();
        save(newSave, filename);
        return newSave;
    }
}
