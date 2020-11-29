package com.tsb.frogger.actors;

import java.util.ArrayList;

import com.tsb.frogger.core.ConstantData;
import javafx.event.EventHandler;

import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;

/**
 * frogger class
 */
public class Animal extends Actor {
	/**
	 * max score
	 */
	public static int MAX_SCORE = 800;
	/**
	 * image up
	 */
	Image imgW1;
	/**
	 * image left
	 */
	Image imgA1;
	/**
	 * image down
	 */
	Image imgS1;
	/**
	 * image right
	 */
	Image imgD1;
	/**
	 * image up 2
	 */
	Image imgW2;
	/**
	 * image left 2
	 */
	Image imgA2;
	/**
	 * image down 2
	 */
	Image imgS2;
	/**
	 * image right 2
	 */
	Image imgD2;
	/**
	 * score
	 */
	int points = 0;
	/**
	 * number of activated ends
	 */
	int end = 0;
	/**
	 * second frame animation boolean
	 */
	private boolean jumping = false;
	/**
	 * no move boolean
	 */
	boolean noMove = false;
	/**
	 * movement
	 */
	double movementY = 23.999999;
	/**
	 * movement x axis
	 */
	double movementX = 16.799999;
	/**
	 * image size
	 */
	int imgSize = 36;
	/**
	 * car death boolean
	 */
	boolean carDeath = false;
	/**
	 * water death boolean
	 */
	boolean waterDeath = false;
	/**
	 * update score boolean
	 */
	boolean changeScore = false;
	/**
	 * car death counter
	 */
	int animationCounter = 0;
	/**
	 * y layout location
	 */
	double maxDistancePerRound = ConstantData.SIZE_BACKGROUND[1];
	/**
	 * ends
	 */
	ArrayList<End> inter = new ArrayList<End>();
	/**
	 * frog layout x
	 */
	private final int frogLayoutX;
	/**
	 * frog layout y
	 */
	private final int frogLayoutY;
	/**
	 * frog direction
	 */
	private enum DIRECTION{
		UP,
		LEFT,
		DOWN,
		RIGHT,
	}


	/**
	 * frogger constructor
	 * @param imageLink image url
	 */
	public Animal(String imageLink, int layoutX, int layoutY) {

		setImage(new Image(imageLink, imgSize, imgSize, true, true));
		frogLayoutX = layoutX;
		frogLayoutY = layoutY;
		resetFrogLocation();

		imgW1 = new Image(ConstantData.IMAGE_ACTOR_FROG_UP, imgSize, imgSize, true, true);
		imgA1 = new Image(ConstantData.IMAGE_ACTOR_FROG_LEFT, imgSize, imgSize, true, true);
		imgS1 = new Image(ConstantData.IMAGE_ACTOR_FROG_DOWN, imgSize, imgSize, true, true);
		imgD1 = new Image(ConstantData.IMAGE_ACTOR_FROG_RIGHT, imgSize, imgSize, true, true);
		imgW2 = new Image(ConstantData.IMAGE_ACTOR_FROG_UP_JUMP, imgSize, imgSize, true, true);
		imgA2 = new Image(ConstantData.IMAGE_ACTOR_FROG_LEFT_JUMP, imgSize, imgSize, true, true);
		imgS2 = new Image(ConstantData.IMAGE_ACTOR_FROG_DOWN_JUMP, imgSize, imgSize, true, true);
		imgD2 = new Image(ConstantData.IMAGE_ACTOR_FROG_RIGHT_JUMP, imgSize, imgSize, true, true);

		// handle on key press
		setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event){
				if (!noMove && jumping) {
					switch (event.getCode()) {
						case W -> {
							frogMove(DIRECTION.UP);
							changeScore = false;
						}
						case A -> frogMove(DIRECTION.LEFT);
						case S -> frogMove(DIRECTION.DOWN);
						case D -> frogMove(DIRECTION.RIGHT);
					}
				}
			}
		});

		// handle on key release
		setOnKeyReleased(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
				if (!noMove && !jumping){
					switch (event.getCode()){
						case W -> {
							if (getY() < maxDistancePerRound && getY() > ConstantData.LAYOUT_Y_ACTOR[0][1]) {
								changeScore = true;
								maxDistancePerRound = getY();
								points += 10;
							}
							frogMove(DIRECTION.UP);
						}
						case A -> frogMove(DIRECTION.LEFT);
						case S -> frogMove(DIRECTION.DOWN);
						case D -> frogMove(DIRECTION.RIGHT);
					}
				}
			}
			
		});
	}

	/**
	 * frog behaviour every time frame
	 * @param now timestamp of current time in nanosecond
	 */
	@Override
	public void act(long now) {

		//// bounding box related

		// if frogger out of up or down bound
		if (getY() < 0 || getY() > ConstantData.SIZE_BACKGROUND[1]) {
			setY(ConstantData.LAYOUT_Y_ACTOR[0][12] + movementY);
		}
		// if frogger out of left bound
		if (getX() < 0) {
			move(movementX, 0);
		}
		// if frogger out of right bound
		if (getX()>(ConstantData.SIZE_BACKGROUND[0] - imgSize)) {
			move(-movementX, 0);
		}

		//// death related

		// crashed by car animation
		if (carDeath) {
			if ((now)% 11 ==0) {
				animationCounter++;
			}
			switch (animationCounter){
				case 1 -> setImage(new Image(ConstantData.IMAGE_ACTOR_FROG_CRASH_1, imgSize, imgSize, true, true));
				case 2 -> setImage(new Image(ConstantData.IMAGE_ACTOR_FROG_CRASH_2, imgSize, imgSize, true, true));
				case 3 -> setImage(new Image(ConstantData.IMAGE_ACTOR_FROG_CRASH_3, imgSize, imgSize, true, true));
				case 4 -> {
					setImage(new Image(ConstantData.IMAGE_ACTOR_FROG_UP, imgSize, imgSize, true, true));
					resetFrogLocation();
					carDeath = false;
					noMove = false;
					animationCounter = 0;
					reducePoints(50);
				}
			}
		}

		// drowned in water animation
		if (waterDeath) {
			if ((now)% 11 ==0) {
				animationCounter++;
			}
			switch (animationCounter){
				case 1 -> setImage(new Image(ConstantData.IMAGE_ACTOR_FROG_DROWNED_1, imgSize,imgSize , true, true));
				case 2 -> setImage(new Image(ConstantData.IMAGE_ACTOR_FROG_DROWNED_2, imgSize,imgSize , true, true));
				case 3 -> setImage(new Image(ConstantData.IMAGE_ACTOR_FROG_DROWNED_3, imgSize,imgSize , true, true));
				case 4 -> setImage(new Image(ConstantData.IMAGE_ACTOR_FROG_DROWNED_4, imgSize,imgSize , true, true));
				case 5 -> {
					setImage(new Image(ConstantData.IMAGE_ACTOR_FROG_UP, imgSize, imgSize, true, true));
					resetFrogLocation();
					waterDeath = false;
					noMove = false;
					animationCounter = 0;
					reducePoints(50);
				}
			}
		}

		// if not dead check intersecting object
		if(!noMove){
			// if overlap with obstacles then dead
			if (getIntersectingObjects(Obstacle.class).size() > 0) {
				carDeath = true;
				noMove = true;
			// if overlap with log and not dead then frog move log speed
			} else if (getIntersectingObjects(Log.class).size() > 0) {
				move(getIntersectingObjects(Log.class).get(0).getSpeed(), 0);
			// if overlap with turtle and not dead then frog move turtle speed
			} else if (getIntersectingObjects(Turtle.class).size() > 0) {
				move(getIntersectingObjects(Turtle.class).get(0).getSpeed(),0);
			// if overlap with wet turtle and if is sunk then death else frog move wet turtle speed
			} else if (getIntersectingObjects(WetTurtle.class).size() > 0) {
				if (getIntersectingObjects(WetTurtle.class).get(0).isSunk()) {
					waterDeath = true;
					noMove = true;
				} else {
					move(getIntersectingObjects(WetTurtle.class).get(0).getSpeed(),0);
				}
			// if overlap with end then add score respawn frog
			} else if (getIntersectingObjects(End.class).size() > 0) {
				// if end is activated frog drowned
				if (getIntersectingObjects(End.class).get(0).isActivated()) {
					waterDeath = true;
					noMove = true;
				} else {
					points += 40;
					changeScore = true;
					maxDistancePerRound = ConstantData.SIZE_BACKGROUND[1];
					getIntersectingObjects(End.class).get(0).setEnd();
					end++;
					resetFrogLocation();
				}
			// if frog go beyond layout Y then allow water death
			} else if (getY()<372){
				waterDeath = true;
				noMove = true;
			}
		}
	}

	private void resetFrogLocation(){
		setX(frogLayoutX);
		setY(frogLayoutY + movementY);
	}

	private void frogMove(DIRECTION direction){
		switch (direction) {
			case UP -> {
				move(0, -movementY);
				setImage(checkJump() ? imgW2 : imgW1);
			}
			case LEFT -> {
				move(-movementX, 0);
				setImage(checkJump() ? imgA2 : imgA1);
			}
			case DOWN -> {
				move(0, movementY);
				setImage(checkJump() ? imgS2 : imgS1);
			}
			case RIGHT -> {
				move(movementX, 0);
				setImage(checkJump() ? imgD2 : imgD1);
			}
		}
	}

	private boolean checkJump(){
		jumping = !jumping;
		return !jumping;
	}

	private void reducePoints(int deltaPoints){
		if(points >= deltaPoints){
			points -= deltaPoints;
		} else {
			points = 0;
		}
		changeScore = true;
	}

	/**
	 * lock movement of frogger
	 * @param noMove movement boolean
	 */
	public void setNoMove(boolean noMove) {
		this.noMove = noMove;
	}

	/**
	 * check all frogs are at the end
	 * @return true if frogs at the end equals 5
	 */
	public boolean getStop() {
		return end==5;
	}

	/**
	 * get earned scores
	 * @return scores
	 */
	public int getPoints() {
		return points;
	}

	/**
	 * method for updating score above game map
	 * so that animation timer won't constantly update the score
	 * @return new score available returns true, no score change return false
	 */
	public boolean updateScoreLabel() {
		if (changeScore) {
			changeScore = false;
			return true;
		} else {
			return false;
		}
	}
	

}
