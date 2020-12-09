package com.tsb.frogger.core;

import com.tsb.frogger.utils.data.datastructure.Player;
import com.tsb.frogger.utils.data.filemanager.SaveGameManager;
import com.tsb.frogger.utils.data.datastructure.SavedData;
import com.tsb.frogger.world.Game;
import com.tsb.frogger.world.LevelSelector;

import java.io.IOException;

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

    public static void init(){
        try {
            gameData = SaveGameManager.loadGame(ConstantData.SAVE_FILE_PATH);
            rectifyScores();
            System.out.println("loaded game data:");
            System.out.println(gameData);
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void rectifyScores() throws IOException {
        for (Player player : gameData.allPlayers){
            while(player.getHighScores().size() > LevelSelector.MAX_LEVEL){
                player.getHighScores().remove(player.getHighScores().size() - 1);
            }
        }
        SaveGameManager.saveGame(gameData, ConstantData.SAVE_FILE_PATH);
    }
}
