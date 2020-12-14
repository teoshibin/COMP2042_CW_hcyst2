package com.tsb.frogger.graphics.widgets;

import com.tsb.frogger.core.ConstantData;
import com.tsb.frogger.utils.data.datamanager.PropertiesDao;
import com.tsb.frogger.utils.data.datamanager.PropertiesDaoImpl;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * setting button
 */
public class SettingBtn extends ImageView {
    //TODO DONT PUT MOUSE HANDLING HERE
    /**
     * constructor
     * @param imageLink image url\
     */
    public SettingBtn(String imageLink) {
        PropertiesDao pd = new PropertiesDaoImpl();

        setImage(new Image(imageLink, 32, 32, true, true));
        setLayoutX(ConstantData.SIZE_BACKGROUND[0] - 15 - 32);
        setLayoutY(15);
        getStyleClass().add("settingBtn");
    }
}
