package com.tsb.frogger.generation.world;


import com.tsb.frogger.utils.data.datamanager.AssetsDao;
import com.tsb.frogger.utils.data.datamanager.AssetsDaoImpl;
import com.tsb.frogger.utils.sound.Sound;

/**
 * MyStage class
 */
public class MyStage extends World {

	@Override
	public void start() {
		super.start();
		AssetsDao ad = new AssetsDaoImpl();
		Sound.playMediaPlayer(ad.getExternal("sound.music.frogger"));
	}

	@Override
	public void stop() {
		super.stop();
		Sound.stopMediaPlayer();
	}
}
