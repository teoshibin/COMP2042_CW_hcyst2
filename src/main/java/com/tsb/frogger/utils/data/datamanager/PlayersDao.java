package com.tsb.frogger.utils.data.datamanager;

import com.tsb.frogger.utils.data.datastructure.Player;

import java.io.IOException;
import java.util.ArrayList;

/**
 * player data access object interface
 */
public interface PlayersDao {
    /**
     * get all players in an array list
     *
     * @return array list of players
     */
    ArrayList<Player> getAllPlayers();

    /**
     * get a single player
     *
     * @param index player index
     * @return player
     */
    Player getPlayer(int index);

    /**
     * get username of a player
     *
     * @param index player index
     * @return username
     */
    String getUsername(int index);

    /**
     * get all username in an array list
     *
     * @return array list of string usernames
     */
    ArrayList<String> getAllUsernames();

    /**
     * get a player's single high score
     *
     * @param index player index
     * @param level high score level
     * @return high score
     */
    Integer getHighScore(int index, int level);

    /**
     * get all high scores regardless of levels
     *
     * @return an array list of array list of high score
     */
    ArrayList<ArrayList<Integer>> getALlHighScores();

    /**
     * get all high scores based on level
     *
     * @param level level
     * @return array list of high score
     */
    ArrayList<Integer> getAllHighScores(int level);

    /**
     * update player with a complete new player
     *
     * @param index player index
     * @param player input player
     * @return true when successfully updated
     * @throws IOException fail to save content
     */
    boolean updatePlayer(int index, Player player) throws IOException;

    /**
     * update only the player name
     *
     * @param index player index
     * @param name new name
     * @return true when successfully updated
     * @throws IOException fail to save content
     */
    boolean updatePlayer(int index, String name) throws IOException;

    /**
     * update entire player high scores
     *
     * @param index player index
     * @param highScore new high score
     * @return true when successfully updated
     * @throws IOException fail to save content
     */
    boolean updatePlayer(int index, ArrayList<Integer> highScore) throws IOException;

    /**
     * update only a single player high score
     *
     * @param index player index
     * @param level selected level high score
     * @param newScore new high score
     * @return true when successfully updated
     * @throws IOException fail to save content
     */
    boolean updatePlayer(int index, int level, int newScore) throws IOException;

    /**
     * remove a player
     *
     * @param index player index
     * @return true if successfully updated
     * @throws IOException fail to save content
     */
    boolean deletePlayer(int index) throws IOException;

    /**
     * add a new player
     *
     * @param name new player name
     * @return true if successfully updated
     * @throws IOException fail to save content
     */
    boolean addPlayer(String name) throws IOException;
}
