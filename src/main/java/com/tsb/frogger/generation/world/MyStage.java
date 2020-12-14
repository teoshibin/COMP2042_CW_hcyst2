package com.tsb.frogger.generation.world;


import com.tsb.frogger.utils.data.datamanager.PropertiesDao;
import com.tsb.frogger.utils.data.datamanager.PropertiesDaoImpl;
import com.tsb.frogger.utils.sound.Sound;

/**
 * MyStage class
 */
public class MyStage extends World {

	@Override
	public void start() {
		super.start();
		PropertiesDao pd = new PropertiesDaoImpl();
		Sound.playMediaPlayer(pd.getExternal("sound.music.frogger"));
	}

	@Override
	public void stop() {
		super.stop();
		Sound.stopMediaPlayer();
	}
}
