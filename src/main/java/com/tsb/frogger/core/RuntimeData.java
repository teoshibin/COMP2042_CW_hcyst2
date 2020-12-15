package com.tsb.frogger.core;

import com.tsb.frogger.controller.GameController;
import com.tsb.frogger.utils.data.datastructure.SavedData;
import com.tsb.frogger.utils.data.filemanager.AssetsPropertiesManager;
import com.tsb.frogger.utils.data.filemanager.SaveGameManager;

import java.io.IOException;
import java.util.Properties;

public class RuntimeData {
    /**
     * game data from save file
     */
    public static SavedData gameData;
    /**
     * selected username once enter the account page
     */
    public static int selectedPlayerIndex = 0;
    /**
     * game object
     */
    public static GameController gameController;
    /**
     * loaded assets path
     */
    public static Properties assets;

    public static void init(String SaveFileName, String assetsFileName){

        try {
            assets = AssetsPropertiesManager.loadProperties(assetsFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            gameData = SaveGameManager.loadGame(SaveFileName);
            System.out.println("\nloaded game data:");
            System.out.println(gameData + "\n");
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

}
