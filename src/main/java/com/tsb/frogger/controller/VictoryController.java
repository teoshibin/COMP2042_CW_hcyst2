package com.tsb.frogger.controller;

import com.tsb.frogger.core.Game;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class VictoryController implements Initializable {

    @FXML
    private Label highestScoreLabel;
    @FXML
    private Label usernameLabel;
    @FXML
    private Label levelLabel;
    @FXML
    private Label scoreLabel;

    private static Game game;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        usernameLabel.setText(game.getUsername());
        levelLabel.setText(Integer.toString(game.getLevel()));
        scoreLabel.setText(Integer.toString(game.getScore()));
    }

    public static void setGame(Game game){
        VictoryController.game = game;
    }
}
