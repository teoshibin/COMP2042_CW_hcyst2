package com.tsb.frogger.generation.actors;

/**
 * godlike version of animal (for debug purpose)
 */
public class GodFrog extends Frog {

    /**
     * constructor
     *
      * @param direction initial direction
     * @param layoutX layout x
     * @param layoutY layout y
     * @param health initial health
     */
    public GodFrog(DIRECTION direction, int layoutX, int layoutY, int health) {
        super(direction, layoutX, layoutY, health);
    }

    /**
     * activate instant win
     * @param score set desired score
     */
    public void instantWin(int score) {
        end = 5;
        scores = score;
    }

}
