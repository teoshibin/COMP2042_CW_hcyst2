package com.tsb.frogger.generation.actors;

import com.tsb.frogger.utils.data.datamanager.PropertiesDao;
import com.tsb.frogger.utils.data.datamanager.PropertiesDaoImpl;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.util.Duration;

/**
 * wet turtle class
 */
public class WetTurtle extends ActingActor implements AnimatingActor{
	/**
	 * wet turtle speed
	 */
	private final double speed;
	/**
	 * turtle status
	 */
	private boolean sunk = false;
	/**
	 * animation timeline
	 */
	private final Timeline animation;

	/**
	 * constructor
	 * @param layoutX layout x
	 * @param layoutY layout y
	 * @param s speed
	 * @param w width
	 * @param h height
	 */
	public WetTurtle(int layoutX, int layoutY, double s, int w, int h) {

		// set layout
		setX(layoutX);
		setY(layoutY);

		// set speed
		speed = s;
		if (speed > 0){
			setScaleX(-1);
			setScaleY(-1);
		}

		PropertiesDao pd = new PropertiesDaoImpl();
		Image turtle1 = new Image(pd.getExternal("image.actor.wetTurtle.1"), w, h, true, true);
		Image turtle2 = new Image(pd.getExternal("image.actor.wetTurtle.2"), w, h, true, true);
		Image turtle3 = new Image(pd.getExternal("image.actor.wetTurtle.3"), w, h, true, true);
		Image turtle4 = new Image(pd.getExternal("image.actor.wetTurtle.4"), w, h, true, true);

		// create different animation delay for each turtle (1.6 ~ 2.6 sec per image assuming speed equals to 1)
		int delay = (int)((Math.round(Math.random() * 1000)/2 + 800)/Math.abs(speed/2));
		// create animation
		animation = new Timeline(
				new KeyFrame(Duration.ZERO, new KeyValue(imageProperty(), turtle1)),
				new KeyFrame(new Duration(delay), new KeyValue(imageProperty(), turtle2)),
				new KeyFrame(new Duration(delay*2), new KeyValue(imageProperty(), turtle3)),
				new KeyFrame(new Duration(delay*3), event -> sunk = true, new KeyValue(imageProperty(), turtle4)),
				new KeyFrame(new Duration(delay*4), event -> sunk = false, new KeyValue(imageProperty(), turtle1))
		);
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.play();
	}

	/**
	 * get status of turtle is under water
	 *
	 * @return boolean
	 */
	public boolean getSunk() {
		return sunk;
	}

	/**
	 * get actor speed
	 *
	 * @return double
	 */
	public double getSpeed(){
		return speed;
	}

	/**
	 * override act for the act of wet turtle
	 * @param now timestamp of current time in nanosecond
	 */
	@Override
	public void act(long now) {
		move(speed , 0);
	}

	/**
	 * pause animation
	 */
	@Override
	public void pause() {
		animation.pause();
	}

	/**
	 * resume animation after pause
	 */
	@Override
	public void resume() {
		animation.play();
	}

	/**
	 * stop and dispose animation
	 */
	@Override
	public void stop() {
		animation.stop();
	}
}
