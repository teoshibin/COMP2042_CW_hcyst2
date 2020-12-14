package com.tsb.frogger.graphics.actors;

import com.tsb.frogger.core.ConstantData;
import com.tsb.frogger.utils.data.datamanager.PropertiesDao;
import com.tsb.frogger.utils.data.datamanager.PropertiesDaoImpl;
import com.tsb.frogger.utils.sound.Sound;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.util.Duration;

/**
 * frog class
 */
public class Frog extends ActingActor implements AnimatingActor {
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
	 * death animation image
	 */
	Image crashDeath1;
	/**
	 * death animation image
	 */
	Image crashDeath2;
	/**
	 * death animation image
	 */
	Image crashDeath3;
	/**
	 * death animation image
	 */
	Image drownDeath1;
	/**
	 * death animation image
	 */
	Image drownDeath2;
	/**
	 * death animation image
	 */
	Image drownDeath3;
	/**
	 * death animation image
	 */
	Image drownDeath4;
	/**
	 * assets dao
	 */
	PropertiesDao pd;
	/**
	 * max score
	 */
	public static final int MAX_SCORE = 900;
	/**
	 * timer score
	 */
	private static final int MAX_EXTRA_SCORE = 60;
	/**
	 * score
	 */
	int scores = 0;
	/**
	 * update score boolean
	 */
	boolean changeScore = false;
	/**
	 * extra points
	 */
	private int extraScores = MAX_EXTRA_SCORE;
	/**
	 * timer for decreasing extra scores every period of time
	 */
	private Timeline extraScoresTimer;
	/**
	 * death animation timeline
	 */
	private Timeline deathAnimation;
	/**
	 * image size
	 */
	private static final int imgSize = 36;
	/**
	 * number of activated ends
	 */
	int end = 0;
	/**
	 * health
	 */
	private int health;
	/**
	 * true when not jumping false when jumping
	 */
	private boolean allowJumping = true;
	/**
	 * store previous key
	 */
	private KeyCode previousKey;
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
	 * y layout location
	 */
	double maxDistancePerRound = ConstantData.SIZE_BACKGROUND[1];
	/**
	 * frog layout x
	 */
	private final int frogLayoutX;
	/**
	 * frog layout y
	 */
	private final int frogLayoutY;
	/**
	 * frog status
	 */
	private FROG_STATUS frogStatus;
	/**
	 * frog direction
	 */
	public enum DIRECTION{
		UP,
		LEFT,
		DOWN,
		RIGHT,
	}

	/**
	 * frog current status
	 */
	private enum FROG_STATUS{
		ALIVE,
		CRASHED,
		DROWNED,
		AnimatingDeath,
	}

	/**
	 * frog constructor
	 *
	 * @param direction initial direction
	 * @param layoutX layout x
	 * @param layoutY layout y
	 */
	public Frog(DIRECTION direction, int layoutX, int layoutY, int health) {

		this.health = health;

		pd = new PropertiesDaoImpl();

		imgW1 = new Image(pd.getExternal("image.actor.frog.up"), imgSize, imgSize, true, true);
		imgA1 = new Image(pd.getExternal("image.actor.frog.left"), imgSize, imgSize, true, true);
		imgS1 = new Image(pd.getExternal("image.actor.frog.down"), imgSize, imgSize, true, true);
		imgD1 = new Image(pd.getExternal("image.actor.frog.right"), imgSize, imgSize, true, true);
		imgW2 = new Image(pd.getExternal("image.actor.frog.up.jump"), imgSize, imgSize, true, true);
		imgA2 = new Image(pd.getExternal("image.actor.frog.left.jump"), imgSize, imgSize, true, true);
		imgS2 = new Image(pd.getExternal("image.actor.frog.down.jump"), imgSize, imgSize, true, true);
		imgD2 = new Image(pd.getExternal("image.actor.frog.right.jump"), imgSize, imgSize, true, true);

		crashDeath1 = new Image(pd.getExternal("image.actor.frog.crash.1"), imgSize, imgSize, true, true);
		crashDeath2 = new Image(pd.getExternal("image.actor.frog.crash.2"), imgSize, imgSize, true, true);
		crashDeath3 = new Image(pd.getExternal("image.actor.frog.crash.3"), imgSize, imgSize, true, true);

		drownDeath1 = new Image(pd.getExternal("image.actor.frog.drown.1"), imgSize, imgSize, true, true);
		drownDeath2 = new Image(pd.getExternal("image.actor.frog.drown.2"), imgSize, imgSize, true, true);
		drownDeath3 = new Image(pd.getExternal("image.actor.frog.drown.3"), imgSize, imgSize, true, true);
		drownDeath4 = new Image(pd.getExternal("image.actor.frog.drown.4"), imgSize, imgSize, true, true);

		switch (direction){
			case UP -> setImage(imgW1);
			case DOWN -> setImage(imgS1);
			case LEFT -> setImage(imgA1);
			case RIGHT -> setImage(imgD1);
		}

		frogLayoutX = layoutX;
		frogLayoutY = layoutY;

		resetFrog();

		// handle on key press
		setOnKeyPressed(event -> {
			if (!noMove && allowJumping && previousKey == null) {
				switch (event.getCode()) {
					case W -> {
						frogMove(DIRECTION.UP);
						changeScore = false;
					}
					case A -> frogMove(DIRECTION.LEFT);
					case S -> frogMove(DIRECTION.DOWN);
					case D -> frogMove(DIRECTION.RIGHT);
				}
				previousKey = event.getCode();
			}
		});

		// handle on key release
		setOnKeyReleased(event -> {
			if (!noMove && !allowJumping && previousKey == event.getCode()){
				switch (event.getCode()){
					case W -> {
						if (getY() < maxDistancePerRound && getY() > ConstantData.LAYOUT_Y_ACTOR[0][1]) {
							changeScore = true;
							maxDistancePerRound = getY();
							scores += 10;
						}
						frogMove(DIRECTION.UP);
					}
					case A -> frogMove(DIRECTION.LEFT);
					case S -> frogMove(DIRECTION.DOWN);
					case D -> frogMove(DIRECTION.RIGHT);
				}
				previousKey = null;
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
		// if frog out of up or down bound
		if (getY() < 0 || getY() > ConstantData.SIZE_BACKGROUND[1]) {
			setY(ConstantData.LAYOUT_Y_ACTOR[0][12] + movementY);
		}
		// if frog out of left bound
		if (getX() < 0) {
			move(movementX, 0);
		}
		// if frog out of right bound
		if (getX()>(ConstantData.SIZE_BACKGROUND[0] - imgSize)) {
			move(-movementX, 0);
		}

		switch (frogStatus){
			case ALIVE -> {
				// if not dead check intersecting object
				if(!noMove){
					// if overlap with obstacles then status died
					if (getIntersectingObjects(Obstacle.class).size() > 0) {
						frogStatus = FROG_STATUS.CRASHED;
						noMove = true;
						// if overlap with log and not dead then frog move log speed
					} else if (getIntersectingObjects(Log.class).size() > 0) {
						move(getIntersectingObjects(Log.class).get(0).getSpeed(), 0);
						// if overlap with turtle and not dead then frog move turtle speed
					} else if (getIntersectingObjects(Turtle.class).size() > 0) {
						move(getIntersectingObjects(Turtle.class).get(0).getSpeed(),0);
						// if overlap with wet turtle and if is sunk then death else frog move wet turtle speed
					} else if (getIntersectingObjects(WetTurtle.class).size() > 0) {
						if (getIntersectingObjects(WetTurtle.class).get(0).getSunk()) {
							frogStatus = FROG_STATUS.DROWNED;
							noMove = true;
						} else {
							move(getIntersectingObjects(WetTurtle.class).get(0).getSpeed(),0);
						}
						// if overlap with end then add score respawn frog
					} else if (getIntersectingObjects(End.class).size() > 0) {
						// if end is activated frog drowned
						if (getIntersectingObjects(End.class).get(0).isActivated()) {
							frogStatus = FROG_STATUS.DROWNED;
							noMove = true;
						} else {
							extraScoresTimer.stop();
							scores += extraScores;
							changeScore = true;
							maxDistancePerRound = ConstantData.SIZE_BACKGROUND[1];
							getIntersectingObjects(End.class).get(0).setEnd();
							end++;
							resetFrog();
						}
						// if frog go beyond layout Y then allow water death
					} else if (getY()<372){
						frogStatus = FROG_STATUS.DROWNED;
						noMove = true;
					}
				}
			}
			case CRASHED -> {
				frogStatus = FROG_STATUS.AnimatingDeath;
				Sound.playAudioClip(pd.getExternal("sound.clip.actor.frog.crashed"));
				deathAnimation = createCrashDeathTimeline();
				deathAnimation.play();
			}
			case DROWNED -> {
				frogStatus = FROG_STATUS.AnimatingDeath;
				Sound.playAudioClip(pd.getExternal("sound.clip.actor.frog.drowned"));
				deathAnimation = createDrownedDeathTimeline();
				deathAnimation.play();
			}
		}
	}

	private Timeline createCrashDeathTimeline() {
		return new Timeline(
				new KeyFrame(new Duration(100), new KeyValue(imageProperty(), crashDeath1)),
				new KeyFrame(new Duration(200), new KeyValue(imageProperty(), crashDeath2)),
				new KeyFrame(new Duration(300), new KeyValue(imageProperty(), crashDeath3)),
				new KeyFrame(new Duration(400), event -> {
					resetFrog();
					reducePoints();
					noMove = false;
					health--;
				}, new KeyValue(imageProperty(), imgW1))
		);
	}

	private Timeline createDrownedDeathTimeline() {
		return new Timeline(
				new KeyFrame(new Duration(100), new KeyValue(imageProperty(), drownDeath1)),
				new KeyFrame(new Duration(200), new KeyValue(imageProperty(), drownDeath2)),
				new KeyFrame(new Duration(300), new KeyValue(imageProperty(), drownDeath3)),
				new KeyFrame(new Duration(400), new KeyValue(imageProperty(), drownDeath4)),
				new KeyFrame(new Duration(500), event -> {
					resetFrog();
					reducePoints();
					noMove = false;
					health--;
				}, new KeyValue(imageProperty(), imgW1))
		);
	}

	/**
	 * create score deceasing timer
	 *
	 * @param period time delay between every call
	 * @return timeline
	 */
	private Timeline createExtraScoreTimer(double period){
		Timeline timeline = new Timeline(
				new KeyFrame(Duration.seconds(period), new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						extraScores--;
					}
				})
		);
		timeline.setCycleCount(MAX_EXTRA_SCORE);
		return timeline;
	}

	private void resetFrog(){
		setX(frogLayoutX);
		setY(frogLayoutY + movementY);
		frogStatus = FROG_STATUS.ALIVE;
		extraScores = MAX_EXTRA_SCORE;
		if (extraScoresTimer != null){
			extraScoresTimer.stop();
		}
		extraScoresTimer = createExtraScoreTimer(1);
		extraScoresTimer.play();
		allowJumping = true;
		previousKey = null;
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
		allowJumping = !allowJumping;
		return !allowJumping;
	}

	private void reducePoints(){
		if(scores >= 50){
			scores -= 50;
		} else {
			scores = 0;
		}
		changeScore = true;
	}

	/**
	 * check all frogs are at the end
	 * @return true if frogs at the end equals 5
	 */
	public boolean getWin() {
		return end==5;
	}

	/**
	 * return true when ran out of health
	 *
	 * @return boolean
	 */
	public boolean getLose(){
		return health <= 0;
	}

	/**
	 * get health
	 *
	 * @return health
	 */
	public int getHealth() {
		return health;
	}

	/**
	 * get earned scores
	 * @return scores
	 */
	public int getScores() {
		return scores;
	}


	//TODO
	public double getProgress(){
		return (double)extraScores / MAX_EXTRA_SCORE;
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

	@Override
	public void pause(){
		extraScoresTimer.pause();
		noMove = true;
		if (frogStatus == FROG_STATUS.AnimatingDeath){
			deathAnimation.pause();
		}
	}

	@Override
	public void resume(){
		extraScoresTimer.play();
		noMove = false;
		if (frogStatus == FROG_STATUS.AnimatingDeath){
			deathAnimation.play();
		}
	}

	@Override
	public void stop() {
		extraScoresTimer.stop();
		noMove = true;
		if (frogStatus == FROG_STATUS.AnimatingDeath){
			deathAnimation.stop();
		}
	}

}
