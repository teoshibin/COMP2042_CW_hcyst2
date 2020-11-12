package com.tsb.frogger.data;

import java.util.ArrayList;

/**
 * manage storing info of scores
 */
public class FileScore extends FileGame {

    /**
     * write scores
     * @param player_index player index
     * @param level level, index of highestscorelist
     * @param score score
     */
    public static void writeScore(int player_index, int level, int score){
        ArrayList<Player> players = read();
        ArrayList<Integer> scoreList = players.get(player_index).getHighest_scores();
        if(scoreList.size() >= level){
            scoreList.set(level - 1, score);
        } else {
            scoreList.add(score);
        }
        players.get(player_index).setHighest_scores(scoreList);
        write(players);
    }

    /**
     * read score
     * @param player_index player index
     * @param level level, index of highestscorelist
     * @return score when exist else 0
     */
    public static Integer readScore(int player_index, int level){
        ArrayList<Player> players = read();
        ArrayList<Integer> scoreList = players.get(player_index).getHighest_scores();
        if(scoreList.size() >= level){
            return scoreList.get(level - 1);
        } else {
            return 0;
        }
    }
}
