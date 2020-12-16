package com.tsb.frogger.generation.widgets;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * heart icon image
 */
public class Heart extends ImageView {
    /**
     * constructor
     *
     * @param imagePath icon image path
     */
    public Heart(String imagePath){
        setImage(new Image(imagePath));
        setLayoutX(0);
        setLayoutY(0);
    }
}
