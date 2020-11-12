package com.tsb.frogger.actors;

import javafx.scene.image.Image;

/**
 * end class
 */
public class End extends Actor{

	/**
	 * activated ends
	 */
	boolean activated = false;
	@Override
	public void act(long now) {}

	/**
	 * constructor
	 * @param x layout x
	 * @param y layout y
	 */
	public End(int x, int y) {
		setX(x);
		setY(y);
		setImage(new Image("file:src/main/resources/com/tsb/frogger/images/world/End.png", 60, 60, true, true));
	}

	/**
	 * set activated end image
	 */
	public void setEnd() {
		setImage(new Image("file:src/main/resources/com/tsb/frogger/images/world/FrogEnd.png", 70, 70, true, true));
		activated = true;
	}

	/**
	 * get activation status
	 * @return activated
	 */
	public boolean isActivated() {
		return activated;
	}
	

}
