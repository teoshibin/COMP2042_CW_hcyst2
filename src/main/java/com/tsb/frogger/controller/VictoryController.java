package com.tsb.frogger.controller;

import com.tsb.frogger.core.ConstantData;
import com.tsb.frogger.core.*;
import com.tsb.frogger.utils.exceptions.LevelNotFoundException;
import com.tsb.frogger.utils.files.FileScore;
import com.tsb.frogger.utils.files.FileUsername;
import com.tsb.frogger.utils.sound.Sound;
import com.tsb.frogger.world.LevelSelector;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * victory controller for victory GUI
 */
public class VictoryController implements Initializable, ControlledScreen{
    ScreensController myController;
    /**
     * image view
     */
    @FXML
    public ImageView newImageView;
    /**
     * button
     */
    @FXML
    private Button continueBtn;
    /**
     * label
     */
    @FXML
    private Label highestScoreLabel;
    /**
     * label
     */
    @FXML
    private Label usernameLabel;
    /**
     * label
     */
    @FXML
    private Label levelLabel;
    /**
     * label
     */
    @FXML
    private Label scoreLabel;

    /**
     * handle action event
     * @param actionEvent event
     */
    public void handleBtnAction(ActionEvent actionEvent) throws LevelNotFoundException {
        switch (((Button) actionEvent.getSource()).getText()) {
            case "Leave", "Done" -> {
                myController.removeOverlay(ConstantData.OVERLAY_ID_VICTORY);
                myController.setScreen(ConstantData.SCREEN_ID_MENU);
                myController.unloadScreen(ConstantData.SCREEN_ID_GAME);
                myController.unloadScreen(ConstantData.OVERLAY_ID_VICTORY);
                Sound.stopMediaPlayer();
                Sound.playMediaPlayer(ConstantData.MUSIC_ARCADE);
            }
            case "Continue" -> {
                RuntimeData.game.setLevel(RuntimeData.game.getLevel() + 1);
                myController.removeOverlay(ConstantData.OVERLAY_ID_VICTORY);
                myController.unloadScreen(ConstantData.OVERLAY_ID_VICTORY);
                RuntimeData.game.start();
                myController.loadScreen(ConstantData.SCREEN_ID_GAME, RuntimeData.game.gamePane, RuntimeData.game);
                myController.setScreen(ConstantData.SCREEN_ID_GAME);
            }
        }
    }

    /**
     * mouse enter event
     * @param mouseEvent event
     */
    public void MouseEnter(MouseEvent mouseEvent) {
        Sound.playAudioClip(ConstantData.SOUND_BUTTON);
    }

    /**
     * init GUI
     * @param location location
     * @param resources resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        int playerIndex = RuntimeData.selectedUsernameIndex;
        int currentScore = RuntimeData.game.getScore();
        int currentLevel = RuntimeData.game.getLevel();
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
        if(RuntimeData.game.getLevel() == LevelSelector.MAX_LEVEL){
            continueBtn.setText("Done");
        }
    }

    @Override
    public void setScreenParent(ScreensController screenPage) {
        myController = screenPage;
    }
}
