package com.tsb.frogger.world.actors;

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
	private double speed;
	/**
	 * speed of sinking
	 */
	private double phaseChangeDelay;
	/**
	 * turtle status
	 */
	boolean sunk = false;
	/**
	 * different sinking time
	 */
	private final int sinking_shift = (int)Math.floor(Math.random()*10);
	/**
	 * override act for the act of wet turtle
	 * @param now timestamp of current time in nanosecond
	 */
	@Override
	public void act(long now) {
		long sinkingTime = ((now + sinking_shift*1000000000)/1000000000) % 4;

		if (sinkingTime ==0) {
			setImage(turtle2);
			sunk = false;
		} else if (sinkingTime == 1) {
			setImage(turtle1);
			sunk = false;
		} else if (sinkingTime == 2) {
			setImage(turtle3);
			sunk = false;
		} else if (sinkingTime == 3) {
			setImage(turtle4);
			sunk = true;
		}
			
		move(speed , 0);
	}

	/**
	 * constructor
	 * @param xpos layout x
	 * @param ypos layout y
	 * @param s speed
	 * @param w width
	 * @param h height
	 */
	public WetTurtle(int xpos, int ypos, double s, int w, int h) {
		turtle1 = new Image(ConstantData.IMAGE_ACTOR_TURTLE_1, w, h, true, true);
		turtle2 = new Image(ConstantData.IMAGE_ACTOR_WET_TURTLE_2, w, h, true, true);
		turtle3 = new Image(ConstantData.IMAGE_ACTOR_WET_TURTLE_3, w, h, true, true);
		turtle4 = new Image(ConstantData.IMAGE_ACTOR_WET_TURTLE_4, w, h, true, true);
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

	public double getSpeed(){
		return speed;
	}
}