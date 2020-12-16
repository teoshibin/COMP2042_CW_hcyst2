package com.tsb.frogger.generation.widgets;

import com.tsb.frogger.core.ConstantData;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * game background image
 */
public class GameBackground extends ImageView {
    /**
     * constructor
     *
     * @param imagePath image path
     */
    public GameBackground(String imagePath){
        this.setImage(new Image(imagePath, ConstantData.SIZE_BACKGROUND[0],
                ConstantData.SIZE_BACKGROUND[1], false, false));
    }

}
