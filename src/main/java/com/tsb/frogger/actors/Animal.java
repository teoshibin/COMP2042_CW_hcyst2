package com.tsb.frogger.actors;

import java.util.ArrayList;

import com.sun.tools.jconsole.JConsoleContext;
import com.tsb.frogger.core.ConstantData;
import javafx.event.EventHandler;

import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
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
	private boolean second = false;
	/**
	 * no move boolean
	 */
	boolean noMove = false;
	/**
	 * movement
	 */
	double movement = 23.999999;
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
	 * stop boolean
	 */
	boolean stop = false;
	/**
	 * update score boolean
	 */
	boolean changeScore = false;
	/**
	 * car death counter
	 */
	int carD = 0;
	/**
	 * y layout location
	 */
	double w = ConstantData.SIZE_BACKGROUND[1];
	/**
	 * ends
	 */
	ArrayList<End> inter = new ArrayList<End>();

	/**
	 * frogger constructor
	 * @param imageLink image url
	 */
	public Animal(String imageLink, int layoutX, int layoutY) {
		setImage(new Image(imageLink, imgSize, imgSize, true, true));
		setX(layoutX);
		setY(layoutY + movement);
		imgW1 = new Image(ConstantData.IMAGE_ACTOR_FROG_UP, imgSize, imgSize, true, true);
		imgA1 = new Image(ConstantData.IMAGE_ACTOR_FROG_LEFT, imgSize, imgSize, true, true);
		imgS1 = new Image(ConstantData.IMAGE_ACTOR_FROG_DOWN, imgSize, imgSize, true, true);
		imgD1 = new Image(ConstantData.IMAGE_ACTOR_FROG_RIGHT, imgSize, imgSize, true, true);
		imgW2 = new Image(ConstantData.IMAGE_ACTOR_FROG_UP_JUMP, imgSize, imgSize, true, true);
		imgA2 = new Image(ConstantData.IMAGE_ACTOR_FROG_LEFT_JUMP, imgSize, imgSize, true, true);
		imgS2 = new Image(ConstantData.IMAGE_ACTOR_FROG_DOWN_JUMP, imgSize, imgSize, true, true);
		imgD2 = new Image(ConstantData.IMAGE_ACTOR_FROG_RIGHT_JUMP, imgSize, imgSize, true, true);

		// handle key event
		setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event){
				if (noMove) {
					
				}
				else {
				if (second) {
					if (event.getCode() == KeyCode.W) {	  
		                move(0, -movement);
		                changeScore = false;
		                setImage(imgW1);
		                second = false;
		            }
		            else if (event.getCode() == KeyCode.A) {	            	
		            	 move(-movementX, 0);
		            	 setImage(imgA1);
		            	 second = false;
		            }
		            else if (event.getCode() == KeyCode.S) {	            	
		            	 move(0, movement);
		            	 setImage(imgS1);
		            	 second = false;
		            }
		            else if (event.getCode() == KeyCode.D) {	            	
		            	 move(movementX, 0);
		            	 setImage(imgD1);
		            	 second = false;
		            }
				}
				else if (event.getCode() == KeyCode.W) {	            	
	                move(0, -movement);
	                setImage(imgW2);
	                second = true;
	            }
	            else if (event.getCode() == KeyCode.A) {	            	
	            	 move(-movementX, 0);
	            	 setImage(imgA2);
	            	 second = true;
	            }
	            else if (event.getCode() == KeyCode.S) {	            	
	            	 move(0, movement);
	            	 setImage(imgS2);
	            	 second = true;
	            }
	            else if (event.getCode() == KeyCode.D) {	            	
	            	 move(movementX, 0);
	            	 setImage(imgD2);
	            	 second = true;
	            }
	        }
			}
		});	
		setOnKeyReleased(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
				if (noMove) {}
				else {
				if (event.getCode() == KeyCode.W) {	  
					if (getY() < w) {
						changeScore = true;
						w = getY();
						points+=10;
					}
	                move(0, -movement);
	                setImage(imgW1);
	                second = false;
	            }
	            else if (event.getCode() == KeyCode.A) {	            	
	            	 move(-movementX, 0);
	            	 setImage(imgA1);
	            	 second = false;
	            }
	            else if (event.getCode() == KeyCode.S) {	            	
	            	 move(0, movement);
	            	 setImage(imgS1);
	            	 second = false;
	            }
	            else if (event.getCode() == KeyCode.D) {	            	
	            	 move(movementX, 0);
	            	 setImage(imgD1);
	            	 second = false;
	            }
	        }
			}
			
		});
	}

	/**
	 * override solidify act method
	 * @param now timestamp of current time in nanosecond
	 */
	@Override
	public void act(long now) {
		int bounds = 0;
		if (getY()<0 || getY()>ConstantData.SIZE_BACKGROUND[1]) {
			setY(ConstantData.LAYOUT_Y_ACTOR[0][12] + movement);
		}
		if (getX() < 0) {
			move(movementX, 0);
		}
		if (carDeath) {
			noMove = true;
			if ((now)% 11 ==0) {
				carD++;
			}
			if (carD==1) {
				setImage(new Image(ConstantData.IMAGE_ACTOR_FROG_CRASH_1, imgSize, imgSize, true, true));
			}
			if (carD==2) {
				setImage(new Image(ConstantData.IMAGE_ACTOR_FROG_CRASH_2, imgSize, imgSize, true, true));
			}
			if (carD==3) {
				setImage(new Image(ConstantData.IMAGE_ACTOR_FROG_CRASH_3, imgSize, imgSize, true, true));
			}
			if (carD == 4) {
				setX(ConstantData.LAYOUT_X_FROG[0]);
				setY(ConstantData.LAYOUT_Y_ACTOR[0][12]+movement);
				carDeath = false;
				carD = 0;
				setImage(new Image(ConstantData.IMAGE_ACTOR_FROG_UP, imgSize, imgSize, true, true));
				noMove = false;
				if (points>50) {
					points-=50;
					changeScore = true;
				}
			}
			
		}
		if (waterDeath) {
			noMove = true;
			if ((now)% 11 ==0) {
				carD++;
			}
			if (carD==1) {
				setImage(new Image(ConstantData.IMAGE_ACTOR_FROG_DROWNED_1, imgSize,imgSize , true, true));
			}
			if (carD==2) {
				setImage(new Image(ConstantData.IMAGE_ACTOR_FROG_DROWNED_2, imgSize,imgSize , true, true));
			}
			if (carD==3) {
				setImage(new Image(ConstantData.IMAGE_ACTOR_FROG_DROWNED_3, imgSize,imgSize , true, true));
			}
			if (carD == 4) {
				setImage(new Image(ConstantData.IMAGE_ACTOR_FROG_DROWNED_4, imgSize,imgSize , true, true));
			}
			if (carD == 5) {
				setX(ConstantData.LAYOUT_X_FROG[0]);
				setY(ConstantData.LAYOUT_Y_ACTOR[0][12]+movement);
				waterDeath = false;
				carD = 0;
				setImage(new Image(ConstantData.IMAGE_ACTOR_FROG_UP, imgSize, imgSize, true, true));
				noMove = false;
				if (points>50) {
					points-=50;
					changeScore = true;
				}
			}
			
		}

		// if frogger out of bound right bound
		if (getX()>(ConstantData.SIZE_BACKGROUND[0] - imgSize)) {
			move(-movementX, 0);
		}
		if (getIntersectingObjects(Obstacle.class).size() >= 1) {
			carDeath = true;
		}
		if (getX() == 216 && getY() == 74) {
			stop = true;
		}
		if (getIntersectingObjects(Log.class).size() >= 1 && !noMove) {
			if(getIntersectingObjects(Log.class).get(0).getLeft())
				move(-2,0);
			else
				move (.75,0);
		}
		else if (getIntersectingObjects(Turtle.class).size() >= 1 && !noMove) {
			move(-1,0);
		}
		else if (getIntersectingObjects(WetTurtle.class).size() >= 1) {
			if (getIntersectingObjects(WetTurtle.class).get(0).isSunk()) {
				waterDeath = true;
			} else {
				move(-1,0);
			}
		}
		else if (getIntersectingObjects(End.class).size() >= 1) {
			inter = (ArrayList<End>) getIntersectingObjects(End.class);
			if (getIntersectingObjects(End.class).get(0).isActivated()) {
				end--;
				points-=50;
			}
			points+=50;
			changeScore = true;
			w=ConstantData.SIZE_BACKGROUND[1];
			getIntersectingObjects(End.class).get(0).setEnd();
			end++;
			setX(ConstantData.LAYOUT_X_FROG[0]);
			setY(ConstantData.LAYOUT_Y_ACTOR[0][12]+movement);
		}
		else if (getY()<372){
			waterDeath = true;
			//setX(300);
			//setY(679.8+movement);
		}
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
	public boolean changeScore() {
		if (changeScore) {
			changeScore = false;
			return true;
		}
		return false;
		
	}
	

}
