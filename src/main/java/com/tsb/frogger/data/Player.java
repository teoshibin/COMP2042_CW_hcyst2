package com.tsb.frogger.data;

import com.tsb.frogger.core.Game;

import java.io.Serializable;
import java.util.ArrayList;

public class Player implements Serializable {

    private static int counter = 0;

    private int userID;
    private String username;
    private ArrayList<Integer> highest_scores = new ArrayList<>(1);

    public Player() {
        this.username = "Guest";
        this.highest_scores.add(0);
    }
    public Player(String username) {
        this.username = username;
        this.highest_scores.add(0, 0);
    }

    private void setUserID(){
        userID = counter++;
    }

    public int getUserID() {
        return userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setHighest_scores(int level, int score){
        if(level >= 0 && level <= Game.MAX_LEVEL){
            highest_scores.set(level, score);
        }
    }

    public ArrayList<Integer> getHighest_scores(){
        return highest_scores;
    }
}
