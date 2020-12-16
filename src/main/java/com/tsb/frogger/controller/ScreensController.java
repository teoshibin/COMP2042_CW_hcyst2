package com.tsb.frogger.controller;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.util.HashMap;

/**
 * model class for screen controlling or routing
 */
public class ScreensController extends Pane {
    /**
     * screens hashmap to store all routes
     */
    private HashMap<String, Node> screens = new HashMap<>();

    /**
     * inherit constructor from super class
     */
    public ScreensController(){
        super();
    }

    /**
     * add screen to hashmap using id
     *
     * @param name screen id
     * @param screen screen
     */
    private void addScreenToHash(String name, Node screen) {
        screens.put(name, screen);
    }

    /**
     * get screen from hashmap using id
     *
     * @param name screen id
     * @return screen
     */
    private Node getScreenFromHash(String name) {
        return screens.get(name);
    }

    /**
     * load screen without fxml
     *
     * @param name screen id
     * @param node views
     * @param myScreenController controller
     */
    public void loadScreen(String name, Parent node, ControlledScreen myScreenController){
        myScreenController.setScreenParent(this);
        addScreenToHash(name, node);
    }

    /**
     *  load fxml using id and resource path
     *  add loaded fxml pane into hashmap
     *
     * @param id screen id
     * @param name fxml resource name
     */
    public void loadMarkdown(String id, String name) {
        try {
            FXMLLoader myLoader = new FXMLLoader(getClass().getResource(name));
            Parent loadScreen = myLoader.load();
            ControlledScreen myScreenController = myLoader.getController();
            myScreenController.setScreenParent(this);
            addScreenToHash(id, loadScreen);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * unload screen from hash
     *
     * @param name screen id
     */
    public void unloadScreen(String name) {
        if (screens.remove(name) == null) {
            System.out.println("Screen didn't exist");
        }
    }

    /**
     * add overlay
     *
     * @param name screen id
     */
    public void addOverlay(final String name){
        getChildren().add(getScreenFromHash(name));
    }

    /**
     * remove overlay
     *
     * @param name screen id
     */
    public void removeOverlay(final String name){
        getChildren().remove(getScreenFromHash(name));
    }
    
    /**
     * display screen with predefined screen id
     * only loaded screen in hashmap will be loaded
     *
     * @param name screen id
     * @return success true, fail false
     */
    public boolean setScreen(final String name) {
        //screen is not in hashmap
        if (screens.get(name) == null) {
            System.out.println("screen hasn't been loaded!!! \n");
            return false;
        }

        final DoubleProperty opacity = opacityProperty();

        if (!getChildren().isEmpty()) {
            Timeline fade = new Timeline(
                    new KeyFrame(Duration.ZERO, new KeyValue(opacity, 1.0)),
                    new KeyFrame(new Duration(500), new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent t) {
                            getChildren().remove(0);
                            getChildren().add(0, getScreenFromHash(name));
                            fadeIn(opacity);
                        }
                    }, new KeyValue(opacity, 0.0)));
            fade.play();
        } else {
            setOpacity(0.0);
            getChildren().add(getScreenFromHash(name));       //no one else been displayed, then just show
            fadeIn(opacity);
        }
        return true;
    }

    /**
     * fade in transition
     *
     * @param opacity opacity
     */
    private void fadeIn(DoubleProperty opacity){
        Timeline fadeIn = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(opacity, 0.0)),
                new KeyFrame(new Duration(500), new KeyValue(opacity, 1.0)));
        fadeIn.play();
    }


}
