package com.tsb.frogger.utils.data.datamanager;

import com.tsb.frogger.core.ConstantData;
import com.tsb.frogger.core.RuntimeData;
import com.tsb.frogger.utils.data.datastructure.Player;
import com.tsb.frogger.utils.data.filemanager.SaveGameManager;

import java.io.IOException;
import java.util.ArrayList;

/**
 * implementation of player data access object
 */
public class PlayersDaoImpl implements PlayersDao {
    /**
     * get a single player
     *
     * @param index player index
     * @return player
     */
    @Override
    public Player getPlayer(int index) {
        return getAllPlayers().get(index);
    }

    /**
     * get all players
     *
     * @return arraylist of players
     */
    @Override
    public ArrayList<Player> getAllPlayers() {
        return RuntimeData.gameData.allPlayers;
    }

    /**
     * get a single player's username
     *
     * @param index player index
     * @return string username
     */
    @Override
    public String getUsername(int index){
        return getPlayer(index).getUsername();
    }

    /**
     * get all username
     *
     * @return arraylist of strings username
     */
    @Override
    public ArrayList<String> getAllUsernames(){
        ArrayList<String> usernames = new ArrayList<>();
        for (Player player : getAllPlayers()){
            usernames.add(player.getUsername());
        }
        return usernames;
    }

    /**
     * get single player's high score
     *
     * @param index player index
     * @param level high score level
     * @return Integer high score
     */
    @Override
    public Integer getHighScore(int index, int level){
        if (getPlayer(index).getHighScores().size() > level - 1){
            return getPlayer(index).getHighScores().get(level - 1);
        }
        return 0;
    }

    /**
     * get all high scores
     *
     * @return arraylist of arraylist of Integer for every player in every level
     */
    @Override
    public ArrayList<ArrayList<Integer>> getALlHighScores(){
        ArrayList<ArrayList<Integer>> allHighScores = new ArrayList<>();
        for (Player player : getAllPlayers()){
            allHighScores.add(player.getHighScores());
        }
        return allHighScores;
    }

    /**
     * get a single level of all high scores
     *
     * @param level level
     * @return arraylist of Integer high scores of same level of all players
     */
    @Override
    public ArrayList<Integer> getAllHighScores(int level){
        ArrayList<Integer> allHighScores = new ArrayList<>();
        for (int i = 0; i < getAllPlayers().size(); i++) {
            allHighScores.add(getHighScore(i, level));
        }
        return  allHighScores;
    }

    /**
     * update player by replacing player object
     *
     * @param index player index
     * @param player input player
     * @return success boolean
     * @throws IOException fail to save file
     */
    @Override
    public boolean updatePlayer(int index, Player player) throws IOException {
        getAllPlayers().set(index, player);
        SaveGameManager.saveGame(RuntimeData.gameData, ConstantData.SAVE_FILE_PATH);
        return true;
    }

    /**
     * update player by replacing single player's username
     *
     * @param index player index
     * @param name new name
     * @return success boolean
     * @throws IOException fail to save file
     */
    @Override
    public boolean updatePlayer(int index, String name) throws IOException {
        if(Validator.validateUsername(name) && Validator.validateSelectedPlayer(false, index)){
            getPlayer(index).setUsername(name);
            SaveGameManager.saveGame(RuntimeData.gameData, ConstantData.SAVE_FILE_PATH);
            return true;
        }
        return false;
    }

    /**
     * update player by replacing all its high scores in every levels
     *
     * @param index player index
     * @param highScore new high score
     * @return success boolean
     * @throws IOException fail to save file
     */
    @Override
    public boolean updatePlayer(int index, ArrayList<Integer> highScore) throws IOException {
        getPlayer(index).setHighScores(highScore);
        SaveGameManager.saveGame(RuntimeData.gameData, ConstantData.SAVE_FILE_PATH);
        return false;
    }

    /**
     * update player by replacing high score of a single level
     *
     * @param index player index
     * @param level selected level high score
     * @param newScore new high score
     * @return success boolean
     * @throws IOException fail to save file
     */
    @Override
    public boolean updatePlayer(int index, int level, int newScore) throws IOException {
        ArrayList<Integer> highScores = getPlayer(index).getHighScores();
        while(highScores.size() < level){
            highScores.add(0);
        }
        if (highScores.get(level - 1) < newScore){
            highScores.set(level - 1, newScore);
            getPlayer(index).setHighScores(highScores);
            SaveGameManager.saveGame(RuntimeData.gameData, ConstantData.SAVE_FILE_PATH);
            return true;
        }
        return false;
    }

    /**
     * delete player
     *
     * @param index player index
     * @return success boolean
     * @throws IOException fail to save file
     */
    @Override
    public boolean deletePlayer(int index) throws IOException {
        if(Validator.validateSelectedPlayer(false, index)){
            getAllPlayers().remove(index);
            SaveGameManager.saveGame(RuntimeData.gameData, ConstantData.SAVE_FILE_PATH);
            return true;
        }
        return false;
    }

    /**
     * add new player
     *
     * @param name new player name
     * @return success boolean
     * @throws IOException fail to save file
     */
    @Override
    public boolean addPlayer(String name) throws IOException {
        if(Validator.validateUsername(name)){
            getAllPlayers().add(new Player(name));
            SaveGameManager.saveGame(RuntimeData.gameData, ConstantData.SAVE_FILE_PATH);
            return true;
        }
        return false;
    }
}
