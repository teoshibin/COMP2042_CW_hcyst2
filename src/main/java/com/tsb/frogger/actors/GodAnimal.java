package com.tsb.frogger.actors;

/**
 * godlike version of animal (for debug purpose)
 */
public class GodAnimal extends Animal {

    /**
     * constructor
     * @param imageLink image url
     */
    public GodAnimal(String imageLink) {
        super(imageLink);
    }

    /**
     * activate instant win
     * @param score set desired score
     */
    public void instantWin(int score) {
        end = 5;
        points = score;
    }

}
