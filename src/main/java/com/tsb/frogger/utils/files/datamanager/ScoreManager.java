package com.tsb.frogger.utils.files.datamanager;

import com.tsb.frogger.core.ConstantData;
import com.tsb.frogger.core.RuntimeData;
import com.tsb.frogger.utils.files.datastructure.Player;
import com.tsb.frogger.utils.files.filemanager.SaveGameManager;
import com.tsb.frogger.world.LevelSelector;

import java.io.IOException;
import java.util.ArrayList;

public class ScoreManager {

    //TODO new score manager for new score board

    public static boolean updateScore() throws IOException {

        int level = RuntimeData.game.getLevel();
        int newScore = RuntimeData.game.getScore();

        ArrayList<Integer> highScores = RuntimeData.gameData.allPlayers.get(RuntimeData.selectedUsernameIndex).getHighScores();
        while(highScores.size() < level){
            highScores.add(0);
        }
        if (highScores.get(level - 1) < newScore){
            highScores.set(level - 1, newScore);
            RuntimeData.gameData.allPlayers.get(RuntimeData.selectedUsernameIndex).setHighScores(highScores);
            SaveGameManager.saveGame(RuntimeData.gameData, ConstantData.SAVE_FILE_PATH);
            return true;
        }
        return false;
    }

    public static int getCurrentLevelHighScore(){
        return RuntimeData.gameData.allPlayers.get(RuntimeData.selectedUsernameIndex).getHighScores().get(RuntimeData.game.getLevel() - 1);
    }

    public static void rectifyScores() throws IOException {
        for (Player player : RuntimeData.gameData.allPlayers){
            while(player.getHighScores().size() > LevelSelector.MAX_LEVEL){
                player.getHighScores().remove(player.getHighScores().size() - 1);
            }
        }
        SaveGameManager.saveGame(RuntimeData.gameData, ConstantData.SAVE_FILE_PATH);
    }


}
