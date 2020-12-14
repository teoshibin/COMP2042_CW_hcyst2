package com.tsb.frogger.graphics.widgets;

import com.tsb.frogger.core.ConstantData;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class GameBackground extends ImageView {

    public GameBackground(String imagePath){
        this.setImage(new Image(imagePath, ConstantData.SIZE_BACKGROUND[0],
                ConstantData.SIZE_BACKGROUND[1], false, false));
    }

}
