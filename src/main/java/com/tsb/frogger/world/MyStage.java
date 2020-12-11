package com.tsb.frogger.world;


import com.tsb.frogger.utils.data.datamanager.PropertiesDao;
import com.tsb.frogger.utils.data.datamanager.PropertiesDaoImpl;
import com.tsb.frogger.utils.sound.Sound;

/**
 * MyStage class
 */
public class MyStage extends World {

	/**
	 * play background music
	 */
	public void playMusic() {
		PropertiesDao pd = new PropertiesDaoImpl();
		Sound.playMediaPlayer(pd.getExternal("sound.music.frogger"));
	}

	/**
	 * stop background music
	 */
	public void stopMusic() {
		Sound.stopMediaPlayer();
	}

}
