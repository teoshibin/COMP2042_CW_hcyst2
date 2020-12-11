package com.tsb.frogger.world.widgets;

import com.tsb.frogger.controller.ScreensController;
import com.tsb.frogger.utils.data.datamanager.PropertiesDao;
import com.tsb.frogger.utils.data.datamanager.PropertiesDaoImpl;
import com.tsb.frogger.utils.sound.Sound;
import com.tsb.frogger.core.ConstantData;
import com.tsb.frogger.core.RuntimeData;
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
    public HomeBtn(String imageLink, ScreensController myController) {
        PropertiesDao pd = new PropertiesDaoImpl();

        setImage(new Image(imageLink, 32, 32, true, true));
        setLayoutX(15);
        setLayoutY(15);
        getStyleClass().add("homeBtn");

        setOnMouseClicked(event -> {
            RuntimeData.game.stop();
            RuntimeData.game = null;
            myController.setScreen(ConstantData.SCREEN_ID_MENU);
            Sound.playMediaPlayer(pd.getExternal("sound.music.arcade"));
        });

        setOnMouseEntered(event -> Sound.playAudioClip(pd.getExternal("sound.clip.ui.button")));
    }

}
