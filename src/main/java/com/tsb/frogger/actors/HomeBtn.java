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
 * home button
 */
public class HomeBtn extends ImageView {

    /**
     * constructor
     * @param imageLink image url
     */
    public HomeBtn(String imageLink) {
        setImage(new Image(imageLink, 32, 32, true, true));
        setLayoutX(15);
        setLayoutY(15);
        getStyleClass().add("homeBtn");

        setOnMouseClicked(event -> {
            RuntimeData.game.stop();
            try {
                Pane menuPane = FXMLLoader.load(getClass().getResource("../view/Menu.fxml"));
                RuntimeData.pane.getChildren().clear();
                RuntimeData.pane.getChildren().setAll(menuPane);
                Sound.stopMediaPlayer();
                Sound.playMediaPlayer(ConstantData.menuMusic);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        setOnMouseEntered(event -> Sound.playAudioClip(ConstantData.buttonSound));
    }

}
