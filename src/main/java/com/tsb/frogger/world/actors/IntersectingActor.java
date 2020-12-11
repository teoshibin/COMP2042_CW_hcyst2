package com.tsb.frogger.world.actors;

import com.tsb.frogger.world.World;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public abstract class IntersectingActor extends ImageView {

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
    public <A extends IntersectingActor> java.util.List<A> getIntersectingObjects(Class<A> cls){
        ArrayList<A> someArray = new ArrayList<A>();
        for (A actor: getWorld().getObjects(cls)) {
            if (actor != this && actor.intersects(this.getBoundsInLocal())) {
                someArray.add(actor);
            }
        }
        return someArray;
    }
}
