package com.tsb.frogger.actors;

import javafx.scene.image.Image;

/**
 * turtle class
 */
public class Turtle extends Actor{
	/**
	 * image 1
	 */
	Image turtle1;
	/**
	 * image 2
	 */
	Image turtle2;
	/**
	 * image 3
	 */
	Image turtle3;
	/**
	 * turtle speed
	 */
	private int speed;

	/**
	 * override act for turtle act
	 * @param now timestamp of current time in nanosecond
	 */
	@Override
	public void act(long now) {

				if (now/900000000  % 3 ==0) {
					setImage(turtle2);
					
				}
				else if (now/900000000 % 3 == 1) {
					setImage(turtle1);
					
				}
				else if (now/900000000 %3 == 2) {
					setImage(turtle3);
					
				}
			
		move(speed , 0);
		if (getX() > 600 && speed>0)
			setX(-200);
		if (getX() < -75 && speed<0)
			setX(600);
	}

	/**
	 * constructor
	 * @param xpos layout x
	 * @param ypos layout y
	 * @param s speed
	 * @param w width
	 * @param h height
	 */
	public Turtle(int xpos, int ypos, int s, int w, int h) {
		turtle1 = new Image("file:src/main/resources/com/tsb/frogger/images/objects/TurtleAnimation1.png", w, h, true, true);
		turtle2 = new Image("file:src/main/resources/com/tsb/frogger/images/objects/TurtleAnimation2.png", w, h, true, true);
		turtle3 = new Image("file:src/main/resources/com/tsb/frogger/images/objects/TurtleAnimation3.png", w, h, true, true);
		setX(xpos);
		setY(ypos);
		speed = s;
		setImage(turtle2);
	}
}
