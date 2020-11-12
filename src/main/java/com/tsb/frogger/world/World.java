
package com.tsb.frogger.world;


import java.util.ArrayList;
import java.util.List;

import com.tsb.frogger.actors.Actor;
import javafx.animation.AnimationTimer;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

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

        sceneProperty().addListener(new ChangeListener<Scene>() {

			@Override
			public void changed(ObservableValue<? extends Scene> observable, Scene oldValue, Scene newValue) {
				if (newValue != null) {
					newValue.setOnKeyReleased(new EventHandler<KeyEvent>() {

						@Override
						public void handle(KeyEvent event) {
							if(getOnKeyReleased() != null) 
								getOnKeyReleased().handle(event);
							List<Actor> myActors = getObjects(Actor.class);
							for (Actor anActor: myActors) {
								if (anActor.getOnKeyReleased() != null) {
									anActor.getOnKeyReleased().handle(event);
								}
							}
						}
						
					});
					
					newValue.setOnKeyPressed(new EventHandler<KeyEvent>() {

						@Override
						public void handle(KeyEvent event) {
							if(getOnKeyPressed() != null) 
								getOnKeyPressed().handle(event);
							List<Actor> myActors = getObjects(Actor.class);
							for (Actor anActor: myActors) {
								if (anActor.getOnKeyPressed() != null) {
									anActor.getOnKeyPressed().handle(event);
								}
							}
						}
						
					});
				}
				
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
                act(now);
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
     * remove actor
     * @param actor actor
     */
    public void remove(Actor actor) {
        getChildren().remove(actor);
    }

    /**
     * get object
     * @param cls class
     * @param <A> A
     * @return arraylist
     */
    public <A extends Actor> List<A> getObjects(Class<A> cls) {
        ArrayList<A> someArray = new ArrayList<A>();
        for (Node n: getChildren()) {
            if (cls.isInstance(n)) {
                someArray.add((A)n);
            }
        }
        return someArray;
    }

    /**
     * act method
     * @param now timestamp of current time in nanosecond
     */
    public abstract void act(long now);
}
