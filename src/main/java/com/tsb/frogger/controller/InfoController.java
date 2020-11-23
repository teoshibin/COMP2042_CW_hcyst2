package com.tsb.frogger.controller;

import com.tsb.frogger.core.Sound;
import com.tsb.frogger.data.ConstantData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;

/**
 * info controller
 */
public class InfoController {

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
            Pane menuPane = FXMLLoader.load(getClass().getResource("../view/Menu.fxml"));
            infoPane.getChildren().setAll(menuPane);
        }
    }

    /**
     * play button pop up sound effect
     * @param mouseEvent mouse event
     */
    public void enterBtn(MouseEvent mouseEvent) {
        Sound.playAudioClip(ConstantData.buttonSound);
    }
}
