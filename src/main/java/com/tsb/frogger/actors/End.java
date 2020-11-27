package com.tsb.frogger.actors;

import com.tsb.frogger.core.ConstantData;
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
		setImage(new Image(ConstantData.IMAGE_ACTOR_END, ConstantData.SIZE_END, ConstantData.SIZE_END, true, true));
	}

	/**
	 * set activated end image
	 */
	public void setEnd() {
		setImage(new Image(ConstantData.IMAGE_ACTOR_FROG_END, ConstantData.SIZE_FROG_END, ConstantData.SIZE_FROG_END, true, true));
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
