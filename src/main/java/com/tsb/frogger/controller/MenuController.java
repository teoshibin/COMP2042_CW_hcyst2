package com.tsb.frogger.controller;

import com.tsb.frogger.core.ConstantData;
import com.tsb.frogger.core.RuntimeData;
import com.tsb.frogger.utils.data.datamanager.AssetsDao;
import com.tsb.frogger.utils.data.datamanager.AssetsDaoImpl;
import com.tsb.frogger.utils.exceptions.LevelNotFoundException;
import com.tsb.frogger.utils.data.datamanager.PlayersDao;
import com.tsb.frogger.utils.data.datamanager.PlayersDaoImpl;
import com.tsb.frogger.utils.sound.Sound;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Main menu controller for menu GUI
 */
public class MenuController implements Initializable, ControlledScreen {
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
     * main screen controller
     */
    ScreensController myController;

    /**
     * handle main menu GUI button event
     * @param actionEvent button event
     * @throws LevelNotFoundException fail to load level
     */
    @FXML
    public void handleBtnAction(ActionEvent actionEvent) throws LevelNotFoundException {
        switch (((Button) actionEvent.getSource()).getText()) {
            case "Play" -> myController.setScreen(ConstantData.SCREEN_ID_SELECT_LEVEL);
            case "Scores" -> myController.setScreen(ConstantData.SCREEN_ID_SCOREBOARD);
            case "Options" -> myController.addOverlay(ConstantData.OVERLAY_ID_OPTION);
            case "Info" -> myController.setScreen(ConstantData.SCREEN_ID_INFO);
            case "Back" -> myController.setScreen(ConstantData.SCREEN_ID_ACCOUNT);
        }
    }

    /**
     * play button pop up sound effect
     * @param mouseEvent mouse event
     */
    public void enterBtn(MouseEvent mouseEvent) {
        AssetsDao ad = new AssetsDaoImpl();
        Sound.playAudioClip(ad.getExternal("sound.clip.ui.button"));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        AssetsDao ad = new AssetsDaoImpl();
        PlayersDao playersDao = new PlayersDaoImpl();
        usernameLabel.setText(playersDao.getUsername(RuntimeData.selectedPlayerIndex));
        Sound.playMediaPlayer(ad.getExternal("sound.music.arcade"));
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
