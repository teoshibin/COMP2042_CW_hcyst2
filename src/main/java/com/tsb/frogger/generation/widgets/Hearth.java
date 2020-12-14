package com.tsb.frogger.generation.widgets;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Hearth extends ImageView {
    public Hearth(String imagePath){
        setImage(new Image(imagePath));
        setLayoutX(0);
        setLayoutY(0);
    }
}
