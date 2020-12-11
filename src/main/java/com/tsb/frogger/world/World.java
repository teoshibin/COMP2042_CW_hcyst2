package com.tsb.frogger.world;

import com.tsb.frogger.world.actors.Actor;
import javafx.animation.AnimationTimer;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;

/**
 * World class to change event handler
 */
public abstract class World extends Pane {

    /**
     * timer for obstacles
     */
    private AnimationTimer timer;

    /**
     * world constructor
     */
    public World() {

        sceneProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                newValue.setOnKeyReleased(event -> {
                    if(getOnKeyReleased() != null)
                        getOnKeyReleased().handle(event);
                    List<Actor> myActors = getObjects(Actor.class);
                    for (Actor anActor: myActors) {
                        if (anActor.getOnKeyReleased() != null) {
                            anActor.getOnKeyReleased().handle(event);
                        }
                    }
                });

                newValue.setOnKeyPressed(event -> {
                    if(getOnKeyPressed() != null)
                        getOnKeyPressed().handle(event);
                    List<Actor> myActors = getObjects(Actor.class);
                    for (Actor anActor: myActors) {
                        if (anActor.getOnKeyPressed() != null) {
                            anActor.getOnKeyPressed().handle(event);
                        }
                    }
                });
            }

        });
    }

    /**
     * create animation timer for actors (obstacles)
     */
    public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                List<Actor> actors = getObjects(Actor.class);
                
                for (Actor anActor: actors) {
                	anActor.act(now);
                }

            }
        };
    }

    /**
     * create and start animation timer
     */
    public void start() {
    	createTimer();
        timer.start();
    }

    /**
     * stop timer
     */
    public void stop() {
        timer.stop();
    }

    /**
     * add actor method
     * @param actor actor
     */
    public void add(Actor actor) {
        getChildren().add(actor);
    }

    /**
     * add image view
     * @param imageView image view
     */
    public void add(ImageView imageView){
        getChildren().add(imageView);
    }

    /**
     * get object
     * @param cls class
     * @param <A> A
     * @return arraylist
     */
    @SuppressWarnings("unchecked")
    public <A extends Actor> List<A> getObjects(Class<A> cls) {
        ArrayList<A> someArray = new ArrayList<>();
        for (Node n: getChildren()) {
            if (cls.isInstance(n)) {
                someArray.add((A)n);
            }
        }
        return someArray;
    }
}
