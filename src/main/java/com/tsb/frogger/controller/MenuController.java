package com.tsb.frogger.controller;

import com.tsb.frogger.core.Sound;
import com.tsb.frogger.core.Game;
import com.tsb.frogger.core.ConstantData;
import com.tsb.frogger.core.RuntimeData;
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
public class MenuController implements Initializable, ControlledScreen {
    /**
     * main screen controller
     */
    ScreensController myController;
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
                myController.loadScreen(ConstantData.SCREEN_GAME, RuntimeData.game.gamePane, RuntimeData.game);
                myController.setScreen(ConstantData.SCREEN_GAME);
                RuntimeData.game.start();
            }
            case "Scores" -> {
                myController.setScreen(ConstantData.SCREEN_SCOREBOARD);
            }
            case "Options" -> {
                myController.addOverlay(ConstantData.OVERLAY_OPTION);
            }
            case "Info" -> {
                myController.setScreen(ConstantData.SCREEN_INFO);
            }
            case "Back" -> {
                myController.setScreen(ConstantData.SCREEN_ACCOUNT);
            }
        }
    }

    /**
     * play button pop up sound effect
     * @param mouseEvent mouse event
     */
    public void enterBtn(MouseEvent mouseEvent) {
        Sound.playAudioClip(ConstantData.SOUND_BUTTON);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        usernameLabel.setText(RuntimeData.Username);
        Sound.playMediaPlayer(ConstantData.MUSIC_ARCADE);
    }

    /**
     * set main screen controller
     * @param screenPage screen page
     */
    @Override
    public void setScreenParent(ScreensController screenPage) {
        myController = screenPage;
    }
}
