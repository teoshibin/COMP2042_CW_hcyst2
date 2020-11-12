package com.tsb.frogger.actors;

import com.tsb.frogger.controller.OptionController;
import com.tsb.frogger.core.Game;
import com.tsb.frogger.world.MyStage;
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
     * @param imageLink image url
     * @param gamePane parent node
     * @param game game object
     */
    public SettingBtn(String imageLink, MyStage gamePane, Game game) {
        setImage(new Image(imageLink, 32, 32, true, true));
        setLayoutX(553);
        setLayoutY(15);
        getStyleClass().add("settingBtn");

        setOnMouseClicked(event -> {
            try {
                Pane optionPane = FXMLLoader.load(getClass().getResource("../view/Option.fxml"));
                gamePane.getChildren().add(optionPane);
                OptionController.setParentPane(gamePane);
                OptionController.setGameInfo(gamePane, game);
                game.pause();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

}
