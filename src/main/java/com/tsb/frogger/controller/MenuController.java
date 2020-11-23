package com.tsb.frogger.controller;

import com.tsb.frogger.core.Sound;
import com.tsb.frogger.core.Game;
import com.tsb.frogger.data.ConstantData;
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
 * Main menu controller for menu GUI
 */
public class MenuController implements Initializable {
    /**
     * anchor pane
     */
    @FXML
    public AnchorPane menuPane;
    /**
     * label
     */
    @FXML
    public Label usernameLabel;

    /**
     * handle main menu GUI button event
     * @param actionEvent button event
     * @throws IOException exception
     */
    @FXML
    public void handleBtnAction(ActionEvent actionEvent) throws IOException {
        // TODO: 11/12/2020
        switch (((Button) actionEvent.getSource()).getText()) {
            case "Play" -> {
                Sound.stopMediaPlayer();
                RuntimeData.game = new Game(1);
                RuntimeData.game.start();
                menuPane.getChildren().setAll(Game.gamePane);
            }
            case "Scores" -> {
                Pane scorePane = FXMLLoader.load(getClass().getResource("../view/Scoreboard.fxml"));
                menuPane.getChildren().setAll(scorePane);
            }
            case "Options" -> {
                Pane optionPane = FXMLLoader.load(getClass().getResource("../view/Option.fxml"));
                menuPane.getChildren().add(optionPane);
            }
            case "Info" -> {
                Pane infoPane = FXMLLoader.load(getClass().getResource("../view/Info.fxml"));
                menuPane.getChildren().setAll(infoPane);
            }
            case "Back" -> {
                Pane accountPane = FXMLLoader.load(getClass().getResource("../view/Account.fxml"));
                menuPane.getChildren().setAll(accountPane);
            }
        }
    }

    /**
     * play button pop up sound effect
     * @param mouseEvent mouse event
     */
    public void enterBtn(MouseEvent mouseEvent) {
        Sound.playAudioClip(ConstantData.buttonSound);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        usernameLabel.setText(RuntimeData.Username);
    }
}
