package com.tsb.frogger.world.actors;

import javafx.scene.image.Image;

/**
 * obstacle class
 */
public class Obstacle extends Actor {

	/**
	 * speed of obstacles
	 */
	private double speed;

	/**
	 * override act
	 * @param now timestamp of current time in nanosecond
	 */
	@Override
	public void act(long now) {
		move(speed , 0);
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
	public Obstacle(String imageLink, int xpos, int ypos, double s, int w, int h) {
		setImage(new Image(imageLink, w,h, true, true));
		setX(xpos);
		setY(ypos);
		speed = s;
	}

}
