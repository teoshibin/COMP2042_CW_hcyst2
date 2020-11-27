package com.tsb.frogger.core;

import com.tsb.frogger.world.MyStage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class LoadActors {

    public static void load(MyStage gamePane, int level){

        loadBackground(gamePane, level);
    }

    private static void loadBackground(MyStage gamePane, int level){
        Image background;
        switch (level){
            default:
                background = new Image(ConstantData.IMAGE_GAME_BACKGROUND_A);
        }
        ImageView imageView = new ImageView();
        imageView.setImage(background);
        gamePane.getChildren().add(imageView);
    }

    private static void loadLogs(MyStage gamePane, int level){

    }

}
