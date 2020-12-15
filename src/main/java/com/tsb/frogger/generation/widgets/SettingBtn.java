package com.tsb.frogger.generation.widgets;

import com.tsb.frogger.core.ConstantData;
import com.tsb.frogger.utils.data.datamanager.AssetsDao;
import com.tsb.frogger.utils.data.datamanager.AssetsDaoImpl;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * setting button
 */
public class SettingBtn extends ImageView {
    /**
     * constructor
     * @param imageLink image url\
     */
    public SettingBtn(String imageLink) {
        AssetsDao ad = new AssetsDaoImpl();

        setImage(new Image(imageLink, 32, 32, true, true));
        setLayoutX(ConstantData.SIZE_BACKGROUND[0] - 15 - 32);
        setLayoutY(15);
        getStyleClass().add("settingBtn");
    }
}
