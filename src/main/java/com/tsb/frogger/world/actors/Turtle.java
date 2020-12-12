package com.tsb.frogger.world.actors;

import com.tsb.frogger.utils.data.datamanager.PropertiesDao;
import com.tsb.frogger.utils.data.datamanager.PropertiesDaoImpl;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.util.Duration;

/**
 * turtle class
 */
public class Turtle extends ActingActor implements AnimatingActor{
	/**
	 * turtle speed
	 */
	private final double speed;
	/**
	 * animation timeline
	 */
	private final Timeline animation;

	/**
	 * construct a turtle
	 *
	 * @param layoutX layout x
	 * @param layoutY layout y
	 * @param s speed
	 * @param w width
	 * @param h height
	 */
	public Turtle(int layoutX, int layoutY, double s, int w, int h) {

		// set layout position
		setX(layoutX);
		setY(layoutY);

		// set speed
		speed = s;

		// if moving to the right flip image
		if (speed > 0){
			setScaleX(-1);
			setScaleY(-1);
		}

		// load image
		PropertiesDao pd = new PropertiesDaoImpl();
		Image turtle1 = new Image(pd.getExternal("image.actor.turtle.1"), w, h, true, true);
		Image turtle2 = new Image(pd.getExternal("image.actor.turtle.2"), w, h, true, true);
		Image turtle3 = new Image(pd.getExternal("image.actor.turtle.3"), w, h, true, true);

		// create different animation delay for each turtle (0.3 ~ 0.8 sec per image assuming speed equals to 1)
		int delay = (int)((Math.round(Math.random() * 1000)/2 + 300)/ Math.abs(speed));
		// create animation
		animation = new Timeline(
				new KeyFrame(Duration.ZERO, new KeyValue(imageProperty(), turtle1)),
				new KeyFrame(new Duration(delay), new KeyValue(imageProperty(), turtle2)),
				new KeyFrame(new Duration(delay*2), new KeyValue(imageProperty(), turtle3)),
				new KeyFrame(new Duration(delay*3), new KeyValue(imageProperty(), turtle1))
		);
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.play();

	}

	/**
	 * get speed
	 * mainly for the use of calculating the frog speed when standing on it
	 *
	 * @return double
	 */
	public double getSpeed(){
		return speed;
	}

	/**
	 * turtle acting
	 *
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
	 * resume animation of pause
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
