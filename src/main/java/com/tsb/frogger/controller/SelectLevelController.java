package com.tsb.frogger.controller;

import com.tsb.frogger.core.ConstantData;
import com.tsb.frogger.core.RuntimeData;
import com.tsb.frogger.utils.data.datamanager.AssetsDao;
import com.tsb.frogger.utils.data.datamanager.AssetsDaoImpl;
import com.tsb.frogger.utils.exceptions.LevelNotFoundException;
import com.tsb.frogger.utils.sound.Sound;
import com.tsb.frogger.utils.game.LevelSelector;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * select level screen controller
 */
public class SelectLevelController implements Initializable, ControlledScreen{
    /**
     * main controller
     */
    ScreensController myController;
    /**
     * drop down
     */
    @FXML
    public ComboBox<String> dropDown;

    /**
     * init drop down
     *
     * @param location location
     * @param resources resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for (int i = 1; i <= LevelSelector.MAX_LEVEL; i++){
            dropDown.getItems().add("Level " + i);
        }
        dropDown.getSelectionModel().selectFirst();
    }

    /**
     * handle button event
     *
     * @param actionEvent event
     * @throws LevelNotFoundException fail to load level
     */
    public void handleBtnEvent(ActionEvent actionEvent) throws LevelNotFoundException {
        switch (((Button)(actionEvent.getSource())).getText()){
            case "Back" -> myController.setScreen(ConstantData.SCREEN_ID_MENU);
            case "Select" -> {
                Sound.stopMediaPlayer();
                int level = dropDown.getSelectionModel().getSelectedIndex() + 1;

                RuntimeData.gameController = new GameController(level);
                RuntimeData.gameController.start();
                myController.loadScreen(ConstantData.SCREEN_ID_GAME, RuntimeData.gameController.gamePane, RuntimeData.gameController);
                myController.setScreen(ConstantData.SCREEN_ID_GAME);
            }
        }
    }

    /**
     * enter button sound
     *
     * @param mouseEvent event
     */
    public void enterBtn(MouseEvent mouseEvent) {
        AssetsDao ad = new AssetsDaoImpl();
        Sound.playAudioClip(ad.getExternal("sound.clip.ui.button"));
    }

    /**
     * drop down sound
     *
     * @param event event
     */
    public void onHiding(Event event) {
        AssetsDao ad = new AssetsDaoImpl();
        Sound.playAudioClip(ad.getExternal("sound.clip.ui.click.off"));
    }

    /**
     * drop down sound
     *
     * @param event event
     */
    public void onShowing(Event event) {
        AssetsDao ad = new AssetsDaoImpl();
        Sound.playAudioClip(ad.getExternal("sound.clip.ui.click.on"));
    }

    /**
     * inject main screen controller
     *
     * @param screenPage screen page
     */
    @Override
    public void setScreenParent(ScreensController screenPage) {
        myController = screenPage;
    }


}
