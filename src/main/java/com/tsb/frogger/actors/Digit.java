package com.tsb.frogger.actors;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * digit class for score display
 */
public class Digit extends ImageView {
	/**
	 * dimensions
	 */
	int dim;
	/**
	 * image
	 */
	Image im1;

	/**
	 * constructor
	 * @param n digit (0 ~ 9)
	 * @param dim image dimension
	 * @param x layout x coordinate
	 * @param y layout y coordinate
	 */
	public Digit(int n, int dim, int x, int y) {
		im1 = new Image("file:src/main/resources/com/tsb/frogger/images/digits/"+n+".png", dim, dim, true, true);
		setImage(im1);
		setX(x);
		setY(y);
	}
	
}
