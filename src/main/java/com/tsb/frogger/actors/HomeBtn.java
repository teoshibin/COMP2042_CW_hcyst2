package com.tsb.frogger.actors;

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
 * home button
 */
public class HomeBtn extends ImageView {

    /**
     * constructor
     * @param imageLink image url
     */
    public HomeBtn(String imageLink, ScreensController myController) {
        setImage(new Image(imageLink, 32, 32, true, true));
        setLayoutX(15);
        setLayoutY(15);
        getStyleClass().add("homeBtn");

        setOnMouseClicked(event -> {
            RuntimeData.game.stop();
            RuntimeData.game = null;
            myController.setScreen(ConstantData.SCREEN_MENU);
            Sound.stopMediaPlayer();
        });

        setOnMouseEntered(event -> Sound.playAudioClip(ConstantData.SOUND_BUTTON));
    }

}
