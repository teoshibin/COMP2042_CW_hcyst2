package com.tsb.frogger.controller;

import com.tsb.frogger.core.ConstantData;
import com.tsb.frogger.core.RuntimeData;
import com.tsb.frogger.utils.files.datamanager.PlayersDao;
import com.tsb.frogger.utils.files.datamanager.PlayersDaoImpl;
import com.tsb.frogger.utils.sound.Sound;
import com.tsb.frogger.world.LevelSelector;
import com.tsb.frogger.world.actors.Animal;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * scoreboard controller for scoreboard GUI
 */
public class ScoreboardController implements Initializable, ControlledScreen{
    /**
     * main screen controller
     */
    ScreensController myController;
    /**
     * data access object
     */
    PlayersDao playersDao = new PlayersDaoImpl();
    /**
     * table view
     */
    @FXML
    public TableView scoreboardTable;
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
                    selectedLevel = LevelSelector.MAX_LEVEL;
                }
            }
            case "Next" -> {
                selectedLevel++;
                if (selectedLevel > LevelSelector.MAX_LEVEL) {
                    selectedLevel = 1;
                }
            }
            case "Back" -> {
                myController.setScreen(ConstantData.SCREEN_ID_MENU);
            }
        }
        updateInfo();
    }

    /**
     * mouse enter event
     * @param mouseEvent event
     */
    public void enterBtn(MouseEvent mouseEvent) {
        Sound.playAudioClip(ConstantData.SOUND_BUTTON);
    }

    /**
     * mouse click event
     * @param mouseEvent event
     */
    public void clickBtn(MouseEvent mouseEvent) {
        Sound.playAudioClip(ConstantData.SOUND_PAGE_FLIP);
    }

    /**
     * update display info
     */
    public void updateInfo(){
        nameLabel.setText(
                playersDao.getPlayer(RuntimeData.selectedPlayerIndex).getUsername()
        );
        levelLabel.setText(String.valueOf(selectedLevel));
        maxLevelLabel.setText(String.valueOf(LevelSelector.MAX_LEVEL));
        //TODO savegame read all players score based on level
        maxScoreLabel.setText(String.valueOf(Animal.MAX_SCORE));
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
