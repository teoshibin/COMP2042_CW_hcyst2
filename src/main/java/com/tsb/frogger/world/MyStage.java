package com.tsb.frogger.world;


import com.tsb.frogger.core.Sound;
import com.tsb.frogger.data.ConstantData;
import javafx.scene.media.MediaPlayer;

/**
 * MyStage class
 */
public class MyStage extends World {

	/**
	 * act method
	 * @param now timestamp of current time in nanosecond
	 */
	@Override
	public void act(long now) {
	}

	/**
	 * play background music
	 */
	public void playMusic() {
		Sound.playMediaPlayer(ConstantData.gameMusic);
	}

	/**
	 * stop background music
	 */
	public void stopMusic() {
		Sound.stopMediaPlayer();
	}

}
