package com.tsb.frogger.utils.data.datastructure;

/**
 * display data structure for javafx table view
 */
public class TableViewPlayer {
    /**
     * username
     */
    private String username;
    /**
     * selected level high score
     */
    private Integer currentLevelHighScore;

    /**
     * constructor
     *
     * @param username username
     * @param currentLevelHighScore high score
     */
    public TableViewPlayer(String username, Integer currentLevelHighScore){
        this.username = username;
        this.currentLevelHighScore = currentLevelHighScore;
    }

    /**
     * get selected level high score
     *
     * @return high score
     */
    public Integer getCurrentLevelHighScore() {
        return currentLevelHighScore;
    }

    /**
     * set selected level high score
     *
     * @param currentLevelHighScore high score
     */
    public void setCurrentLevelHighScore(int currentLevelHighScore) {
        this.currentLevelHighScore = currentLevelHighScore;
    }

    /**
     * get username
     *
     * @return string username
     */
    public String getUsername() {
        return username;
    }

    /**
     * set username
     *
     * @param username username
     */
    public void setUsername(String username) {
        this.username = username;
    }
}
