package com.tsb.frogger.world.actors;

/**
 * godlike version of animal (for debug purpose)
 */
public class GodFrog extends Frog {

    /**
     * constructor
     * @param imageLink image url
     */
    public GodFrog(String imageLink, int layoutX, int layoutY) {
        super(imageLink, layoutX, layoutY);
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
