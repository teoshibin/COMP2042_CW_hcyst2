package com.tsb.frogger.graphics.widgets;

import com.tsb.frogger.utils.data.datamanager.PropertiesDao;
import com.tsb.frogger.utils.data.datamanager.PropertiesDaoImpl;
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
        PropertiesDao pd = new PropertiesDaoImpl();
        setImage(new Image(imageLink, 32, 32, true, true));
        setLayoutX(15);
        setLayoutY(15);
        getStyleClass().add("homeBtn");

    }

}
