package com.tsb.frogger.world;


import com.tsb.frogger.utils.sound.Sound;
import com.tsb.frogger.core.ConstantData;

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
		Sound.playMediaPlayer(ConstantData.MUSIC_FROGGER);
	}

	/**
	 * stop background music
	 */
	public void stopMusic() {
		Sound.stopMediaPlayer();
	}

}
