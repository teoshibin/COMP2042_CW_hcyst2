package com.tsb.frogger.world.actors;

import com.tsb.frogger.core.ConstantData;
import com.tsb.frogger.utils.data.datamanager.PropertiesDao;
import com.tsb.frogger.utils.data.datamanager.PropertiesDaoImpl;
import javafx.scene.image.Image;

/**
 * end class
 */
public class End extends IntersectingActor{

	/**
	 * activated ends
	 */
	boolean activated = false;

	/**
	 * constructor
	 * @param x layout x
	 * @param y layout y
	 */
	public End(int x, int y) {
		PropertiesDao pd = new PropertiesDaoImpl();
		setX(x);
		setY(y);
		setImage(new Image(pd.getExternal("image.actor.end.deactivated"), ConstantData.SIZE_END, ConstantData.SIZE_END, true, true));
	}

	/**
	 * set activated end image
	 */
	public void setEnd() {
		PropertiesDao pd = new PropertiesDaoImpl();
		setImage(new Image(pd.getExternal("image.actor.end.activated"), ConstantData.SIZE_FROG_END, ConstantData.SIZE_FROG_END, true, true));
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
