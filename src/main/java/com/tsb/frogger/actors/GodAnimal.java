package com.tsb.frogger.actors;

public class GodAnimal extends Animal {
    public GodAnimal(String imageLink) {
        super(imageLink);
    }

    public void instantWin(int score) {
        end = 5;
        points = score;
    }

}
