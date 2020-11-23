package com.tsb.frogger.controller;

import com.tsb.frogger.core.Sound;
import com.tsb.frogger.data.ConstantData;
import com.tsb.frogger.data.RuntimeData;
import com.tsb.frogger.world.MyStage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * option controller for option GUI
 */
public class OptionController {

    /**
     * anchor pane
     */
    @FXML
    public AnchorPane optionPane;

    /**
     * handle action event
     * @param actionEvent event
     */
    public void handleBtnAction(ActionEvent actionEvent) {
        if(((Button)actionEvent.getSource()).getText().equals("Back")){
            ((Pane)optionPane.getParent()).getChildren().remove(optionPane);
            if(RuntimeData.game != null){
                RuntimeData.game.resume();
            }
        }
    }

    public void enterBtn(MouseEvent mouseEvent) {
        Sound.playAudioClip(ConstantData.buttonSound);
    }
}
