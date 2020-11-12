package com.tsb.frogger.actors;

import java.util.ArrayList;

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
	double movement = 13.3333333*2;
	/**
	 * movement x axis
	 */
	double movementX = 10.666666*2;
	/**
	 * image size
	 */
	int imgSize = 40;
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
	double w = 800;
	/**
	 * ends
	 */
	ArrayList<End> inter = new ArrayList<End>();

	/**
	 * frogger constructor
	 * @param imageLink image url
	 */
	public Animal(String imageLink) {
		setImage(new Image(imageLink, imgSize, imgSize, true, true));
		setX(300);
		setY(679.8+movement);
		imgW1 = new Image("file:src/main/resources/com/tsb/frogger/images/frogger/froggerUp.png", imgSize, imgSize, true, true);
		imgA1 = new Image("file:src/main/resources/com/tsb/frogger/images/frogger/froggerLeft.png", imgSize, imgSize, true, true);
		imgS1 = new Image("file:src/main/resources/com/tsb/frogger/images/frogger/froggerDown.png", imgSize, imgSize, true, true);
		imgD1 = new Image("file:src/main/resources/com/tsb/frogger/images/frogger/froggerRight.png", imgSize, imgSize, true, true);
		imgW2 = new Image("file:src/main/resources/com/tsb/frogger/images/frogger/froggerUpJump.png", imgSize, imgSize, true, true);
		imgA2 = new Image("file:src/main/resources/com/tsb/frogger/images/frogger/froggerLeftJump.png", imgSize, imgSize, true, true);
		imgS2 = new Image("file:src/main/resources/com/tsb/frogger/images/frogger/froggerDownJump.png", imgSize, imgSize, true, true);
		imgD2 = new Image("file:src/main/resources/com/tsb/frogger/images/frogger/froggerRightJump.png", imgSize, imgSize, true, true);

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
		if (getY()<0 || getY()>734) {
			setX(300);
			setY(679.8+movement);
		}
		if (getX()<0) {
			move(movement*2, 0);
		}
		if (carDeath) {
			noMove = true;
			if ((now)% 11 ==0) {
				carD++;
			}
			if (carD==1) {
				setImage(new Image("file:src/main/resources/com/tsb/frogger/images/frogger/cardeath1.png", imgSize, imgSize, true, true));
			}
			if (carD==2) {
				setImage(new Image("file:src/main/resources/com/tsb/frogger/images/frogger/cardeath2.png", imgSize, imgSize, true, true));
			}
			if (carD==3) {
				setImage(new Image("file:src/main/resources/com/tsb/frogger/images/frogger/cardeath3.png", imgSize, imgSize, true, true));
			}
			if (carD == 4) {
				setX(300);
				setY(679.8+movement);
				carDeath = false;
				carD = 0;
				setImage(new Image("file:src/main/resources/com/tsb/frogger/images/frogger/froggerUp.png", imgSize, imgSize, true, true));
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
				setImage(new Image("file:src/main/resources/com/tsb/frogger/images/frogger/waterdeath1.png", imgSize,imgSize , true, true));
			}
			if (carD==2) {
				setImage(new Image("file:src/main/resources/com/tsb/frogger/images/frogger/waterdeath2.png", imgSize,imgSize , true, true));
			}
			if (carD==3) {
				setImage(new Image("file:src/main/resources/com/tsb/frogger/images/frogger/waterdeath3.png", imgSize,imgSize , true, true));
			}
			if (carD == 4) {
				setImage(new Image("file:src/main/resources/com/tsb/frogger/images/frogger/waterdeath4.png", imgSize,imgSize , true, true));
			}
			if (carD == 5) {
				setX(300);
				setY(679.8+movement);
				waterDeath = false;
				carD = 0;
				setImage(new Image("file:src/main/resources/com/tsb/frogger/images/frogger/froggerUp.png", imgSize, imgSize, true, true));
				noMove = false;
				if (points>50) {
					points-=50;
					changeScore = true;
				}
			}
			
		}
		
		if (getX()>600) {
			move(-movement*2, 0);
		}
		if (getIntersectingObjects(Obstacle.class).size() >= 1) {
			carDeath = true;
		}
		if (getX() == 240 && getY() == 82) {
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
			w=800;
			getIntersectingObjects(End.class).get(0).setEnd();
			end++;
			setX(300);
			setY(679.8+movement);
		}
		else if (getY()<413){
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
