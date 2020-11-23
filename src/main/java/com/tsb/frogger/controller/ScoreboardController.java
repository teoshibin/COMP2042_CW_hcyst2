package com.tsb.frogger.controller;

import com.tsb.frogger.actors.Animal;
import com.tsb.frogger.core.Game;
import com.tsb.frogger.core.Sound;
import com.tsb.frogger.data.ConstantData;
import com.tsb.frogger.data.FileScore;
import com.tsb.frogger.data.FileUsername;
import com.tsb.frogger.data.RuntimeData;
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

/**
 * scoreboard controller for scoreboard GUI
 */
public class ScoreboardController implements Initializable {
    /**
     * anchor pane
     */
    @FXML
    private AnchorPane scoreBoardPane;
    /**
     * label
     */
    @FXML
    private Label nameLabel;
    /**
     * label
     */
    @FXML
    private Label levelLabel;
    /**
     * label
     */
    @FXML
    private Label maxLevelLabel;
    /**
     * label
     */
    @FXML
    private Label highestScoreLabel;
    /**
     * label
     */
    @FXML
    private Label maxScoreLabel;

    /**
     * selected level
     */
    private int selectedLevel = 1;

    /**
     * init GUI
     * @param location location
     * @param resources resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        updateInfo();
    }

    /**
     * handle action event
     * @param actionEvent event
     * @throws IOException exception
     */
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

    /**
     * mouse enter event
     * @param mouseEvent event
     */
    public void enterBtn(MouseEvent mouseEvent) {
        Sound.playAudioClip(ConstantData.buttonSound);
    }

    /**
     * update display info
     */
    public void updateInfo(){
        nameLabel.setText(FileUsername.readUsernames().get(RuntimeData.selectedUsernameIndex));
        levelLabel.setText(String.valueOf(selectedLevel));
        maxLevelLabel.setText(String.valueOf(Game.MAX_LEVEL));
        highestScoreLabel.setText(String.valueOf(FileScore.readScore(RuntimeData.selectedUsernameIndex, selectedLevel)));
        maxScoreLabel.setText(String.valueOf(Animal.MAX_SCORE));
    }


}
