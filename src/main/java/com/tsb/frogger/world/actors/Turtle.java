package com.tsb.frogger.world.actors;

import com.tsb.frogger.utils.data.datamanager.PropertiesDao;
import com.tsb.frogger.utils.data.datamanager.PropertiesDaoImpl;
import javafx.scene.image.Image;

/**
 * turtle class
 */
public class Turtle extends Actor{
	//TODO OPTIMIZE ANIMATION
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
	private double speed;

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
	}

	/**
	 * constructor
	 * @param xpos layout x
	 * @param ypos layout y
	 * @param s speed
	 * @param w width
	 * @param h height
	 */
	public Turtle(int xpos, int ypos, double s, int w, int h) {
		PropertiesDao pd = new PropertiesDaoImpl();
		turtle1 = new Image(pd.getExternal("image.actor.turtle.1"), w, h, true, true);
		turtle2 = new Image(pd.getExternal("image.actor.turtle.2"), w, h, true, true);
		turtle3 = new Image(pd.getExternal("image.actor.turtle.3"), w, h, true, true);
		setX(xpos);
		setY(ypos);
		speed = s;
		setImage(turtle2);
	}

	public double getSpeed(){
		return speed;
	}
}
