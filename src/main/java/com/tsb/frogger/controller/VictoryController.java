package com.tsb.frogger.controller;

import com.tsb.frogger.core.Game;
import com.tsb.frogger.core.Sound;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class VictoryController implements Initializable {

    @FXML
    private Button leaveBtn;
    @FXML
    private Button continueBtn;
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

        if(game.getLevel() == Game.MAX_LEVEL){
            continueBtn.setText("Done");
        }
    }

    public void handleBtnAction(ActionEvent actionEvent) {
        switch (((Button) actionEvent.getSource()).getText()) {
            case "Leave", "Done" -> {
                try {
                    Pane menuPane = FXMLLoader.load(getClass().getResource("../view/Menu.fxml"));
                    game.getGamePane().getChildren().setAll(menuPane);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Sound.stopMusic();
            }
            case "Continue" -> {
                game.setLevel(game.getLevel() + 1);
                game.getGamePane().getChildren().setAll(game.createPane());
                game.start();
            }
        }
    }

    public void MouseEnter(MouseEvent mouseEvent) {
        Sound.playBtnSound();
    }

    public static void setGame(Game game){
        VictoryController.game = game;
    }
}
