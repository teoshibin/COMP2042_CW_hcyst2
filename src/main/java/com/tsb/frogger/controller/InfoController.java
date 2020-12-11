package com.tsb.frogger.controller;

import com.tsb.frogger.utils.data.datamanager.PropertiesDao;
import com.tsb.frogger.utils.data.datamanager.PropertiesDaoImpl;
import com.tsb.frogger.utils.sound.Sound;
import com.tsb.frogger.core.ConstantData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

/**
 * info controller
 */
public class InfoController implements ControlledScreen {
    /**
     * main screen controller
     */
    ScreensController myController;
    /**
     * button
     */
    @FXML
    public Button backBtn;
    /**
     * anchor pane
     */
    @FXML
    public AnchorPane infoPane;

    /**
     * handle button action
     * @param actionEvent action event
     * @throws IOException open file exception
     */
    public void handleBtnAction(ActionEvent actionEvent) throws IOException {
        if ("Back".equals(((Button) actionEvent.getSource()).getText())) {
            myController.setScreen(ConstantData.SCREEN_ID_MENU);
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
     * set main screen controller
     * @param screenPage screen page
     */
    @Override
    public void setScreenParent(ScreensController screenPage) {
        myController = screenPage;
    }
}
