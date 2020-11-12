package com.tsb.frogger.controller;

import com.tsb.frogger.actors.Animal;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ScoreboardController implements Initializable {
    @FXML
    private AnchorPane scoreBoardPane;
    @FXML
    private Label nameLabel;
    @FXML
    private Label levelLabel;
    @FXML
    private Label maxLevelLabel;
    @FXML
    private Label highestScoreLabel;
    @FXML
    private Label maxScoreLabel;

    private int selectedLevel = 1;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        updateInfo();
    }

    public void handleBtnAction(ActionEvent actionEvent) throws IOException {
        switch (((Button) actionEvent.getSource()).getText()) {
            case "Prev" -> {
                selectedLevel--;
                if (selectedLevel < 1) {
                    selectedLevel = Game.MAX_LEVEL;
                }
            }
            case "Next" -> {
                selectedLevel++;
                if (selectedLevel > Game.MAX_LEVEL) {
                    selectedLevel = 1;
                }
            }
            case "Back" -> {
                Pane menuPane = FXMLLoader.load(getClass().getResource("../view/Menu.fxml"));
                scoreBoardPane.getChildren().setAll(menuPane);
            }
        }
        updateInfo();
    }

    public void enterBtn(MouseEvent mouseEvent) {
        Sound.playBtnSound();
    }

    public void updateInfo(){
        nameLabel.setText(FileUsername.readUsernames().get(AccountController.getSelectedNameIndex()));
        levelLabel.setText(String.valueOf(selectedLevel));
        maxLevelLabel.setText(String.valueOf(Game.MAX_LEVEL));
        highestScoreLabel.setText(String.valueOf(FileScore.readScore(AccountController.getSelectedNameIndex(), selectedLevel)));
        maxScoreLabel.setText(String.valueOf(Animal.MAX_SCORE));
    }


}
