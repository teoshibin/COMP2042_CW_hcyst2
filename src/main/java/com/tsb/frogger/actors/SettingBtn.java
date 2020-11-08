package com.tsb.frogger.actors;

import javafx.scene.image.Image;

public class SettingBtn extends Actor{

    @Override
    public void act(long now) {}

    public SettingBtn(String imageLink) {
        setImage(new Image(imageLink, 32, 32, true, true));
        setLayoutX(553);
        setLayoutY(15);
        getStyleClass().add("settingBtn");

        setOnMouseClicked(event -> {
            System.out.println("pause game");
            // TODO: 11/8/2020
        });
    }
}
