package com.tsb.frogger.world;


import com.tsb.frogger.core.Sound;
import javafx.scene.media.MediaPlayer;

/**
 * MyStage class
 */
public class MyStage extends World {

	/**
	 * act method
	 * @param now
	 */
	@Override
	public void act(long now) {
	}

	/**
	 * play background music
	 */
	public void playMusic() {
		Sound.playMusic();
	}

	/**
	 * stop background music
	 */
	public void stopMusic() {
		Sound.stopMusic();
	}

}
