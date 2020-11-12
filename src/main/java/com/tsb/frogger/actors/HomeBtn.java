package com.tsb.frogger.actors;

import com.tsb.frogger.core.Sound;
import com.tsb.frogger.core.Game;
import com.tsb.frogger.world.MyStage;
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
     * @param gamePane parent node
     * @param game game object
     */
    public HomeBtn(String imageLink, MyStage gamePane, Game game) {
        setImage(new Image(imageLink, 32, 32, true, true));
        setLayoutX(15);
        setLayoutY(15);
        getStyleClass().add("homeBtn");

        setOnMouseClicked(event -> {
            game.stop();
            try {
                Pane menuPane = FXMLLoader.load(getClass().getResource("../view/Menu.fxml"));
                gamePane.getChildren().clear();
                gamePane.getChildren().setAll(menuPane);
                Sound.playMenuMusic();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

}
