package com.tsb.frogger.world.actors;

import javafx.scene.image.Image;

/**
 * log class
 */
public class Log extends ActingActor {

	/**
	 * speed of log
	 */
	private double speed;

	/**
	 * override act for the act of log
	 * @param now timestamp of current time in nanosecond
	 */
	@Override
	public void act(long now) {
		move(speed , 0);
	}

	/**
	 * constructor
	 * @param imageLink image url
	 * @param size image size
	 * @param xpos layout x
	 * @param ypos layout y
	 * @param s speed
	 */
	public Log(String imageLink, int size, int xpos, int ypos, double s) {
		setImage(new Image(imageLink, size,size, true, true));
		setX(xpos);
		setY(ypos);
		speed = s;
		
	}

	/**
	 * get speed
	 * @return speed
	 */
	public double getSpeed() {
		return speed;
	}
}
