package com.tsb.frogger.files;

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
    private ArrayList<Integer> highest_scores;

    /**
     * constructor
     */
    public Player() {
        this.username = "Guest";
        highest_scores = new ArrayList<>();
    }

    /**
     * constructor
     * @param username username
     */
    public Player(String username) {
        this.username = username;
        highest_scores = new ArrayList<>();
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
    public ArrayList<Integer> getHighest_scores(){
        return highest_scores;
    }

    /**
     * set all level highest scores for this user
     * @param highest_scores list of highest scores
     */
    public void setHighest_scores(ArrayList<Integer> highest_scores) {
        this.highest_scores = highest_scores;
    }
}
