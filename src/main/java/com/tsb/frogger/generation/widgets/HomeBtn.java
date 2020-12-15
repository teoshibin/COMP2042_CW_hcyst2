package com.tsb.frogger.generation.widgets;

import com.tsb.frogger.utils.data.datamanager.AssetsDao;
import com.tsb.frogger.utils.data.datamanager.AssetsDaoImpl;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * home button
 */
public class HomeBtn extends ImageView {
    /**
     * constructor
     * @param imageLink image url
     */
    public HomeBtn(String imageLink) {
        AssetsDao ad = new AssetsDaoImpl();
        setImage(new Image(imageLink, 32, 32, true, true));
        setLayoutX(15);
        setLayoutY(15);
        getStyleClass().add("homeBtn");

    }

}
