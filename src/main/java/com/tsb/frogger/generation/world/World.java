package com.tsb.frogger.generation.world;

import com.tsb.frogger.generation.actors.ActingActor;
import com.tsb.frogger.generation.actors.AnimatingActor;
import com.tsb.frogger.generation.actors.IntersectingActor;
import javafx.animation.AnimationTimer;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
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

        // key event listener for frogger control
        sceneProperty().addListener(new ChangeListener<Scene>() {
            @Override
            public void changed(ObservableValue<? extends Scene> observable, Scene oldValue, Scene newValue) {
                if (newValue != null) {
                    newValue.setOnKeyReleased(new EventHandler<KeyEvent>() {
                        @Override
                        public void handle(KeyEvent event) {
                            if (getOnKeyReleased() != null)
                                getOnKeyReleased().handle(event);
                            List<IntersectingActor> myActors = getObjects(IntersectingActor.class);
                            for (IntersectingActor anActor : myActors) {
                                if (anActor.getOnKeyReleased() != null) {
                                    anActor.getOnKeyReleased().handle(event);
                                }
                            }
                        }
                    });
                    newValue.setOnKeyPressed(new EventHandler<KeyEvent>() {
                        @Override
                        public void handle(KeyEvent event) {
                            if (getOnKeyPressed() != null)
                                getOnKeyPressed().handle(event);
                            List<IntersectingActor> myActors = getObjects(IntersectingActor.class);
                            for (IntersectingActor anActor : myActors) {
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
                List<ActingActor> actors = getObjects(ActingActor.class);

                for (ActingActor anActor : actors) {
                    anActor.act(now);
                }

            }
        };
    }

    /**
     * get object
     *
     * @param cls class
     * @param <A> A
     * @return arraylist
     */
    @SuppressWarnings("unchecked")
    public <A extends IntersectingActor> List<A> getObjects(Class<A> cls) {
        ArrayList<A> someArray = new ArrayList<>();
        for (Node n : getChildren()) {
            if (cls.isInstance(n)) {
                someArray.add((A) n);
            }
        }
        return someArray;
    }

    /**
     * get all animating actors
     *
     * @param <A> subclass of AnimatingActor
     * @return arraylist of animating actors
     */
    private <A extends AnimatingActor> ArrayList<AnimatingActor> getAnimatingObjects() {
        ArrayList<AnimatingActor> arrayList = new ArrayList<>();
        for (Node n : getChildren()) {
            if (n instanceof AnimatingActor) {
                arrayList.add((AnimatingActor) n);
            }
        }
        return arrayList;
    }

    /**
     * start acting actor and animation timer or act as resume if paused
     */
    public void start() {
        createTimer();
        timer.start();
        for (AnimatingActor anim : getAnimatingObjects()) {
            anim.resume();
        }
    }

    /**
     * stop acting actor and animating actor
     */
    public void stop() {
        timer.stop();
        for (AnimatingActor anim: getAnimatingObjects()){
            anim.stop();
        }
    }

    /**
     * pause acting actors and animating actors
     */
    public void pause() {
        timer.stop();
        for (AnimatingActor anim: getAnimatingObjects()){
            anim.pause();
        }
    }

    /**
     * add image view
     *
     * @param imageView image view
     */
    public void add(ImageView imageView) {
        getChildren().add(imageView);
    }

    /**
     * add actor
     *
     * @param actor actor node
     */
    public void add(IntersectingActor actor) {
        getChildren().add(actor);
    }

}
