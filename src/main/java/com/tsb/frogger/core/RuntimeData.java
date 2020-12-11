package com.tsb.frogger.core;

import com.tsb.frogger.utils.data.datastructure.SavedData;
import com.tsb.frogger.utils.data.filemanager.SaveGameManager;
import com.tsb.frogger.world.Game;

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
    public static Game game;
    /**
     * loaded assets path
     */
    public static Properties assets;

    public static void init(String SaveFileName, String assetsFileName){

        try {
            assets = SaveGameManager.loadAssets(assetsFileName);
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
