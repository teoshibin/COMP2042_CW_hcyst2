package com.tsb.frogger.actors;

import javafx.scene.image.Image;

/**
 * log class
 */
public class Log extends Actor {

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
		if (getX()>600 && speed>0)
			setX(-180);
		if (getX()<-300 && speed<0)
			setX(700);
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
	 * get the moving direction of the log
	 * @return if left then true else false
	 */
	public boolean getLeft() {
		return speed < 0;
	}
}
