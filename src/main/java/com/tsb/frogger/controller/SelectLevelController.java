package com.tsb.frogger.controller;

import com.tsb.frogger.core.ConstantData;
import com.tsb.frogger.core.RuntimeData;
import com.tsb.frogger.utils.exceptions.LevelNotFoundException;
import com.tsb.frogger.utils.sound.Sound;
import com.tsb.frogger.world.Game;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;

public class SelectLevelController implements ControlledScreen{
    ScreensController myController;
    @FXML
    private ChoiceBox dropDown;

    // TODO - LINK LEVEL TO DROP DOWN

    public void handleBtnEvent(ActionEvent actionEvent) throws LevelNotFoundException {
        switch (((Button)(actionEvent.getSource())).getText()){
            case "Back" -> myController.setScreen(ConstantData.SCREEN_ID_MENU);
            case "Select" -> {
                Sound.stopMediaPlayer();
                RuntimeData.game = new Game(1);
                RuntimeData.game.start();
                myController.loadScreen(ConstantData.SCREEN_ID_GAME, RuntimeData.game.gamePane, RuntimeData.game);
                myController.setScreen(ConstantData.SCREEN_ID_GAME);
            }
        }
    }

    @Override
    public void setScreenParent(ScreensController screenPage) {
        myController = screenPage;
    }

}
