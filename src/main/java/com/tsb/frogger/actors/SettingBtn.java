package com.tsb.frogger.actors;

import com.tsb.frogger.core.Sound;
import com.tsb.frogger.data.ConstantData;
import com.tsb.frogger.data.RuntimeData;
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
    public SettingBtn(String imageLink) {
        setImage(new Image(imageLink, 32, 32, true, true));
        setLayoutX(553);
        setLayoutY(15);
        getStyleClass().add("settingBtn");

        setOnMouseClicked(event -> {
            try {
                Pane optionPane = FXMLLoader.load(getClass().getResource("../view/Option.fxml"));
                RuntimeData.pane.getChildren().add(optionPane);
                RuntimeData.game.pause();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        setOnMouseEntered(event -> Sound.playAudioClip(ConstantData.buttonSound));
    }

}
