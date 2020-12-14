package com.tsb.frogger.controller;

import com.tsb.frogger.utils.data.datamanager.PropertiesDao;
import com.tsb.frogger.utils.data.datamanager.PropertiesDaoImpl;
import com.tsb.frogger.utils.sound.Sound;
import com.tsb.frogger.core.ConstantData;
import com.tsb.frogger.core.RuntimeData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * option controller for option GUI
 */
public class OptionController implements Initializable, ControlledScreen{
    /**
     * main screen controller
     */
    ScreensController myController;
    /**
     * anchor pane
     */
    @FXML
    public AnchorPane optionPane;
    /**
     * master volume slider
     */
    @FXML
    public Slider masterVolumeSlider;
    /**
     * music volume slider
     */
    @FXML
    public Slider musicVolumeSlider;
    /**
     * control volume slider
     */
    @FXML
    public Slider controlVolumeSlider;

    /**
     * init
     * @param location loc
     * @param resources res
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        masterVolumeSlider.setValue(Sound.getMasterVolume()*100);
        controlVolumeSlider.setValue(Sound.getControlVolume()*100);
        musicVolumeSlider.setValue(Sound.getMusicVolume()*100);
    }

    /**
     * handle action event
     * @param actionEvent event
     */
    public void handleBtnAction(ActionEvent actionEvent) {
        if(((Button)actionEvent.getSource()).getText().equals("Back")){
            myController.removeOverlay(ConstantData.OVERLAY_ID_OPTION);
            if(RuntimeData.gameController != null){
                RuntimeData.gameController.resume();
            }
        }
    }

    /**
     * play button pop up sound effect
     * @param mouseEvent mouse event
     */
    public void enterBtn(MouseEvent mouseEvent) {
        PropertiesDao pd = new PropertiesDaoImpl();
        Sound.playAudioClip(pd.getExternal("sound.clip.ui.button"));
    }

    /**
     * handle slider on release
     * @param mouseEvent mouse event
     */
    public void handleOnRelease(MouseEvent mouseEvent) {
        Sound.setMasterVolume(masterVolumeSlider.getValue()/100);
        Sound.setControlVolume(controlVolumeSlider.getValue()/100);
        Sound.setMusicVolume(musicVolumeSlider.getValue()/100);
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
