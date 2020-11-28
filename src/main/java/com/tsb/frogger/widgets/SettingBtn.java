package com.tsb.frogger.widgets;

import com.tsb.frogger.controller.ScreensController;
import com.tsb.frogger.core.Sound;
import com.tsb.frogger.core.ConstantData;
import com.tsb.frogger.core.RuntimeData;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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
            myController.addOverlay(ConstantData.OVERLAY_ID_OPTION);
            RuntimeData.game.pause();
        });

        setOnMouseEntered(event -> {
            Sound.playAudioClip(ConstantData.SOUND_BUTTON);
        });

    }
}
