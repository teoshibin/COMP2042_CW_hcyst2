package com.tsb.frogger.core;

import com.tsb.frogger.utils.files.datamanager.ScoreManager;
import com.tsb.frogger.utils.files.filemanager.SaveGameManager;
import com.tsb.frogger.utils.files.datastructure.SavedData;
import com.tsb.frogger.world.Game;

import java.io.IOException;

public class RuntimeData {
    /**
     * game data from save file
     */
    public static SavedData gameData;
    /**
     * selected username once enter the account page
     */
    public static int selectedUsernameIndex = 0;
    /**
     * game object
     */
    public static Game game;

    public static void init(){
        try {
            gameData = SaveGameManager.loadGame(ConstantData.SAVE_FILE_PATH);
            ScoreManager.rectifyScores();
            System.out.println("loaded game data:");
            System.out.println(gameData);
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }
}
