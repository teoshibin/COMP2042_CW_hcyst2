package com.tsb.frogger.actors;

import javafx.scene.image.Image;

/**
 * obstacle class
 */
public class Obstacle extends Actor {

	/**
	 * speed of obstacles
	 */
	private int speed;

	/**
	 * override act
	 * @param now timestamp of current time in nanosecond
	 */
	@Override
	public void act(long now) {
		move(speed , 0);
		if (getX() > 600 && speed>0)
			setX(-200);
		if (getX() < -50 && speed<0)
			setX(600);
	}

	/**
	 * constructor
	 * @param imageLink image url
	 * @param xpos layout x
	 * @param ypos layout y
	 * @param s speed
	 * @param w width
	 * @param h height
	 */
	public Obstacle(String imageLink, int xpos, int ypos, int s, int w, int h) {
		setImage(new Image(imageLink, w,h, true, true));
		setX(xpos);
		setY(ypos);
		speed = s;
	}

}
