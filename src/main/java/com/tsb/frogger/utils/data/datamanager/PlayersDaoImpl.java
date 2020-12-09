package com.tsb.frogger.utils.data.datamanager;

import com.tsb.frogger.core.ConstantData;
import com.tsb.frogger.core.RuntimeData;
import com.tsb.frogger.utils.data.datastructure.Player;
import com.tsb.frogger.utils.data.filemanager.SaveGameManager;

import java.io.IOException;
import java.util.ArrayList;

public class PlayersDaoImpl implements PlayersDao {

    @Override
    public Player getPlayer(int index) {
        return getAllPlayers().get(index);
    }

    @Override
    public ArrayList<Player> getAllPlayers() {
        return RuntimeData.gameData.allPlayers;
    }

    @Override
    public String getUsername(int index){
        return getPlayer(index).getUsername();
    }

    @Override
    public ArrayList<String> getAllUsernames(){
        ArrayList<String> usernames = new ArrayList<>();
        for (Player player : getAllPlayers()){
            usernames.add(player.getUsername());
        }
        return usernames;
    }

    @Override
    public Integer getHighScore(int index, int level){
        if (getPlayer(index).getHighScores().size() > level - 1){
            return getPlayer(index).getHighScores().get(level - 1);
        }
        return 0;
    }

    @Override
    public ArrayList<ArrayList<Integer>> getALlHighScores(){
        ArrayList<ArrayList<Integer>> allHighScores = new ArrayList<>();
        for (Player player : getAllPlayers()){
            allHighScores.add(player.getHighScores());
        }
        return allHighScores;
    }

    @Override
    public ArrayList<Integer> getAllHighScores(int level){
        ArrayList<Integer> allHighScores = new ArrayList<>();
        for (int i = 0; i < getAllPlayers().size(); i++) {
            allHighScores.add(getHighScore(i, level));
        }
        return  allHighScores;
    }

    @Override
    public boolean updatePlayer(int index, Player player) throws IOException {
        getAllPlayers().set(index, player);
        SaveGameManager.saveGame(RuntimeData.gameData, ConstantData.SAVE_FILE_PATH);
        return true;
    }

    @Override
    public boolean updatePlayer(int index, String name) throws IOException {
        if(Validator.validateUsername(name) && Validator.validateSelectedPlayer(false, index)){
            getPlayer(index).setUsername(name);
            SaveGameManager.saveGame(RuntimeData.gameData, ConstantData.SAVE_FILE_PATH);
            return true;
        }
        return false;
    }

    @Override
    public boolean updatePlayer(int index, ArrayList<Integer> highScore) throws IOException {
        getPlayer(index).setHighScores(highScore);
        SaveGameManager.saveGame(RuntimeData.gameData, ConstantData.SAVE_FILE_PATH);
        return false;
    }

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

    @Override
    public boolean deletePlayer(int index) throws IOException {
        if(Validator.validateSelectedPlayer(false, index)){
            getAllPlayers().remove(index);
            SaveGameManager.saveGame(RuntimeData.gameData, ConstantData.SAVE_FILE_PATH);
            return true;
        }
        return false;
    }

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
