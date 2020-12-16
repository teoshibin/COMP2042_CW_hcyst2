package com.tsb.frogger.generation.actors;

import com.tsb.frogger.core.ConstantData;

/**
 * actor that moves
 */
public abstract class ActingActor extends IntersectingActor{

    //TODO ADD EAGLE ACTOR

    /**
     * move method for image
     * @param dx distance x
     * @param dy distance y
     */
    public void move(double dx, double dy) {
        if (getX() > ConstantData.ACTOR_MOVING_BOUND[1] - dx && dx > 0){
            setX(ConstantData.ACTOR_MOVING_BOUND[0]);
        } else if (getX() < ConstantData.ACTOR_MOVING_BOUND[0] + dx && dx < 0){
            setX(ConstantData.ACTOR_MOVING_BOUND[1]);
        } else {
            setX(getX() + dx);
        }
        setY(getY() + dy);
    }

    /**
     * abstract act method
     * @param now timestamp of current time in nanosecond
     */
    public abstract void act(long now);
}
