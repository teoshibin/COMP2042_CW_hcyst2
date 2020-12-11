package com.tsb.frogger.controller;

import com.tsb.frogger.core.ConstantData;
import com.tsb.frogger.core.RuntimeData;
import com.tsb.frogger.utils.data.datamanager.PropertiesDao;
import com.tsb.frogger.utils.data.datamanager.PropertiesDaoImpl;
import com.tsb.frogger.utils.exceptions.LevelNotFoundException;
import com.tsb.frogger.utils.sound.Sound;
import com.tsb.frogger.world.Game;
import com.tsb.frogger.world.LevelSelector;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class SelectLevelController implements Initializable, ControlledScreen{

    ScreensController myController;

    @FXML
    public ComboBox<String> dropDown;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for (int i = 1; i <= LevelSelector.MAX_LEVEL; i++){
            dropDown.getItems().add("Level " + i);
        }
        dropDown.getSelectionModel().selectFirst();
    }

    public void handleBtnEvent(ActionEvent actionEvent) throws LevelNotFoundException {
        switch (((Button)(actionEvent.getSource())).getText()){
            case "Back" -> myController.setScreen(ConstantData.SCREEN_ID_MENU);
            case "Select" -> {
                Sound.stopMediaPlayer();
                RuntimeData.game = new Game(dropDown.getSelectionModel().getSelectedIndex() + 1);
                RuntimeData.game.start();
                myController.loadScreen(ConstantData.SCREEN_ID_GAME, RuntimeData.game.gamePane, RuntimeData.game);
                myController.setScreen(ConstantData.SCREEN_ID_GAME);
            }
        }
    }

    public void enterBtn(MouseEvent mouseEvent) {
        PropertiesDao pd = new PropertiesDaoImpl();
        Sound.playAudioClip(pd.getExternal("sound.clip.ui.button"));
    }

    public void onHiding(Event event) {
        PropertiesDao pd = new PropertiesDaoImpl();
        Sound.playAudioClip(pd.getExternal("sound.clip.ui.click.off"));
    }

    public void onShowing(Event event) {
        PropertiesDao pd = new PropertiesDaoImpl();
        Sound.playAudioClip(pd.getExternal("sound.clip.ui.click.on"));
    }

    @Override
    public void setScreenParent(ScreensController screenPage) {
        myController = screenPage;
    }


}
