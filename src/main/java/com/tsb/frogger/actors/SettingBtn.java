package com.tsb.frogger.actors;

import com.tsb.frogger.controller.ControlledScreen;
import com.tsb.frogger.controller.ScreensController;
import com.tsb.frogger.core.Sound;
import com.tsb.frogger.core.ConstantData;
import com.tsb.frogger.core.RuntimeData;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.IOException;

/**
 * setting button
 */
public class SettingBtn extends ImageView {
    /**
     * constructor
     * @param imageLink image url\
     */
    public SettingBtn(String imageLink, ScreensController myController) {
        setImage(new Image(imageLink, 32, 32, true, true));
        setLayoutX(ConstantData.SIZE_BACKGROUND[0] - 15 - 32);
        setLayoutY(15);
        getStyleClass().add("settingBtn");

        setOnMouseClicked(event -> {
            myController.addOverlay(ConstantData.OVERLAY_OPTION);
            RuntimeData.game.pause();
        });

        setOnMouseEntered(event -> {
            Sound.playAudioClip(ConstantData.SOUND_BUTTON);
        });

    }
}
