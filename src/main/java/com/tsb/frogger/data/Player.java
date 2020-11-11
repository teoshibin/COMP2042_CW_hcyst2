package com.tsb.frogger.data;

import com.tsb.frogger.core.Game;

import java.io.Serializable;
import java.util.ArrayList;

public class Player implements Serializable {

    private String username;
    private ArrayList<Integer> highest_scores;

    public Player() {
        this.username = "Guest";
        highest_scores = new ArrayList<>();
    }
    public Player(String username) {
        this.username = username;
        highest_scores = new ArrayList<>();
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public ArrayList<Integer> getHighest_scores(){
        return highest_scores;
    }

    public void setHighest_scores(ArrayList<Integer> highest_scores) {
        this.highest_scores = highest_scores;
    }
}
