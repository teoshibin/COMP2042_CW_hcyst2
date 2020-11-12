package com.tsb.frogger.actors;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * pre-defined background image class
 */
public class BackgroundImage extends ImageView {

	/**
	 * constructor
	 * @param imageLink image url
	 */
	public BackgroundImage(String imageLink) {
		setImage(new Image(imageLink, 600, 800, false, false));
	}

}
