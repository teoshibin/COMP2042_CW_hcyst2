package com.tsb.frogger.data;

import java.util.ArrayList;

public class FileScore extends FileGame {

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
