package com.tsb.frogger.world.actors;

/**
 * godlike version of animal (for debug purpose)
 */
public class GodFrog extends Frog {

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
