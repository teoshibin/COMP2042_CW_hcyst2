package com.tsb.frogger.controller;

import com.tsb.frogger.core.Game;
import com.tsb.frogger.core.Sound;
import com.tsb.frogger.data.FileScore;
import com.tsb.frogger.data.FileUsername;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class VictoryController implements Initializable {

    @FXML
    public AnchorPane victoryPane;
    @FXML
    public ImageView newImageView;
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        int playerIndex = AccountController.getSelectedNameIndex();
        int currentScore = game.getScore();
        int currentLevel = game.getLevel();
        int previousHighScore = FileScore.readScore(playerIndex, currentLevel);

        usernameLabel.setText(FileUsername.readUsernames().get(playerIndex));
        levelLabel.setText(Integer.toString(currentLevel));
        scoreLabel.setText(Integer.toString(currentScore));

        if(currentScore <= previousHighScore){
            highestScoreLabel.setText(Integer.toString(previousHighScore));
            newImageView.setVisible(false);
        } else {
            highestScoreLabel.setText(Integer.toString(currentScore));
            FileScore.writeScore(playerIndex, currentLevel, currentScore);
            newImageView.setVisible(true);
        }
        if(game.getLevel() == Game.MAX_LEVEL){
            continueBtn.setText("Done");
        }
    }
}
