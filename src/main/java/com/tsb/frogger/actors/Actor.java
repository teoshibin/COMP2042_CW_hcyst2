package com.tsb.frogger.actors;

import com.tsb.frogger.world.World;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

/**
 * actor class extended from imageview for moving images
 */
public abstract class Actor extends ImageView{

    /**
     * move method for image
     * @param dx distance x
     * @param dy distance y
     */
    public void move(double dx, double dy) {
        setX(getX() + dx);
        setY(getY() + dy);
    }

    /**
     * get parent
     * @return parent node
     */
    public World getWorld() {
        return (World) getParent();
    }

    /**
     * actor properties
     * @param cls class
     * @param <A> A
     * @return intersected actors
     */
    public <A extends Actor> java.util.List<A> getIntersectingObjects(Class<A> cls){
        ArrayList<A> someArray = new ArrayList<A>();
        for (A actor: getWorld().getObjects(cls)) {
            if (actor != this && actor.intersects(this.getBoundsInLocal())) {
                someArray.add(actor);
            }
        }
        return someArray;
    }

    /**
     * abstract act method
     * @param now timestamp of current time in nanosecond
     */
    public abstract void act(long now);

}
