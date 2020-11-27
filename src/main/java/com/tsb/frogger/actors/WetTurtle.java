package com.tsb.frogger.actors;

import com.tsb.frogger.core.ConstantData;
import javafx.scene.image.Image;

/**
 * wet turtle class
 */
public class WetTurtle extends Actor{
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
	 * image 4
	 */
	Image turtle4;
	/**
	 * wet turtle speed
	 */
	private int speed;

//	int i = 1;
//	boolean bool = true;
	/**
	 * turtle status
	 */
	boolean sunk = false;

	/**
	 * override act for the act of wet turtle
	 * @param now timestamp of current time in nanosecond
	 */
	@Override
	public void act(long now) {

				if (now/900000000  % 4 ==0) {
					setImage(turtle2);
					sunk = false;
					
				}
				else if (now/900000000 % 4 == 1) {
					setImage(turtle1);
					sunk = false;
				}
				else if (now/900000000 %4 == 2) {
					setImage(turtle3);
					sunk = false;
				} else if (now/900000000 %4 == 3) {
					setImage(turtle4);
					sunk = true;
				}
			
		move(speed , 0);
		if (getX() > ConstantData.SIZE_BACKGROUND[1] && speed>0)
			setX(-200);
		if (getX() < -200 && speed<0)
			setX(ConstantData.SIZE_BACKGROUND[1]);
	}

	/**
	 * constructor
	 * @param xpos layout x
	 * @param ypos layout y
	 * @param s speed
	 * @param w width
	 * @param h height
	 */
	public WetTurtle(int xpos, int ypos, int s, int w, int h) {
		turtle1 = new Image("file:src/main/resources/com/tsb/frogger/images/objects/TurtleAnimation1.png", w, h, true, true);
		turtle2 = new Image("file:src/main/resources/com/tsb/frogger/images/objects/TurtleAnimation2Wet.png", w, h, true, true);
		turtle3 = new Image("file:src/main/resources/com/tsb/frogger/images/objects/TurtleAnimation3Wet.png", w, h, true, true);
		turtle4 = new Image("file:src/main/resources/com/tsb/frogger/images/objects/TurtleAnimation4Wet.png", w, h, true, true);
		setX(xpos);
		setY(ypos);
		speed = s;
		setImage(turtle2);
	}

	/**
	 * get status of turtle is under water
	 * @return sunk boolean
	 */
	public boolean isSunk() {
		return sunk;
	}
}
