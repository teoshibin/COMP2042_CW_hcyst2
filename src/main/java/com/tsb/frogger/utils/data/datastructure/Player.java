package com.tsb.frogger.utils.data.datastructure;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * player model
 * data structure
 */
public class Player implements Serializable {

    /**
     * username
     */
    private String username;
    /**
     * highest score list
     */
    private ArrayList<Integer> highScores;

    /**
     * constructor
     */
    public Player() {
        username = "Guest";
        highScores = new ArrayList<>();
    }

    /**
     * constructor
     * @param username username
     */
    public Player(String username) {
        this.username = username;
        highScores = new ArrayList<>();
    }

    /**
     * get username
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * set username
     * @param username username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * get all level highest scores from this user
     * @return list of highest scores
     */
    public ArrayList<Integer> getHighScores(){
        return highScores;
    }

    /**
     * set all level highest scores for this user
     * @param highScores list of highest scores
     */
    public void setHighScores(ArrayList<Integer> highScores) {
        this.highScores = highScores;
    }

    @Override
    public String toString() {
        return "Player{" +
                "username='" + username + '\'' +
                ", highest_scores=" + highScores +
                '}';
    }

}
