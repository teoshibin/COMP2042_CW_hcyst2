package com.tsb.frogger.actors;

import javafx.scene.image.Image;

public class End extends Actor{
	boolean activated = false;
	@Override
	public void act(long now) {}
	
	public End(int x, int y) {
		setX(x);
		setY(y);
		setImage(new Image("file:src/main/resources/com/tsb/frogger/images/world/End.png", 60, 60, true, true));
	}
	
	public void setEnd() {
		setImage(new Image("file:src/main/resources/com/tsb/frogger/images/world/FrogEnd.png", 70, 70, true, true));
		activated = true;
	}
	
	public boolean isActivated() {
		return activated;
	}
	

}
