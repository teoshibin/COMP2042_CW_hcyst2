package com.tsb.frogger.actors;

import com.tsb.frogger.core.ConstantData;
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
		if (getX() > ConstantData.ACTOR_MOVING_BOUND[1] && speed>0)
			setX(ConstantData.ACTOR_MOVING_BOUND[0]);
		if (getX() < ConstantData.ACTOR_MOVING_BOUND[0] && speed<0)
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
	public Turtle(int xpos, int ypos, int s, int w, int h) {
		//TODO - make speed double
		turtle1 = new Image(ConstantData.IMAGE_ACTOR_TURTLE_1, w, h, true, true);
		turtle2 = new Image(ConstantData.IMAGE_ACTOR_TURTLE_2, w, h, true, true);
		turtle3 = new Image(ConstantData.IMAGE_ACTOR_TURTLE_3, w, h, true, true);
		setX(xpos);
		setY(ypos);
		speed = s;
		setImage(turtle2);
	}

	public int getSpeed(){
		return speed;
	}
}
