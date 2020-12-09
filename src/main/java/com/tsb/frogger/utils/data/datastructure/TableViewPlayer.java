package com.tsb.frogger.utils.data.datastructure;

public class TableViewPlayer {

    private String username;
    private Integer currentLevelHighScore;

    public TableViewPlayer(String username, Integer currentLevelHighScore){
        this.username = username;
        this.currentLevelHighScore = currentLevelHighScore;
    }

    public Integer getCurrentLevelHighScore() {
        return currentLevelHighScore;
    }

    public void setCurrentLevelHighScore(int currentLevelHighScore) {
        this.currentLevelHighScore = currentLevelHighScore;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
