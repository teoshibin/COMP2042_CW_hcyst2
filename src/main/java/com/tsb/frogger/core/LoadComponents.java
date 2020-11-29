package com.tsb.frogger.core;

import com.tsb.frogger.actors.*;
import com.tsb.frogger.exceptions.LevelNotFoundException;
import com.tsb.frogger.world.MyStage;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * class contains static methods for loading gamePane components
 */
public class LoadComponents {

    /**
     * temp MyStage for loading levels
     */
    private static MyStage gamePane;

    /**
     * load entire game map
     * @param level input level
     * @return game pane
     * @throws LevelNotFoundException level not found exception
     */
    public static MyStage load(int level) throws LevelNotFoundException {

        // create new game pane
        gamePane = new MyStage();

        // set background
        addBackground(ConstantData.IMAGE_GAME_BACKGROUND_A);

        // set Labels
        addLabels();

        // set ending points
        for (int i = 0; i < 5; i++) {
            addEnd(ConstantData.LAYOUT_X_END[0][i], ConstantData.LAYOUT_Y_ACTOR[0][0]);
        }

        // load obstacle based on levels
        LevelSelector.selectLevel(gamePane, level);

        return gamePane;
    }

    /**
     * add scoreboard
     */
    public static void addLabels(){
        // add label
        Label myLabel = new Label();
        myLabel.setLayoutX(390);
        myLabel.setLayoutY(5);
        myLabel.setText("SCORE");
        myLabel.getStyleClass().add("main-font");
        myLabel.getStyleClass().add("font-weight-bold");
        gamePane.getChildren().add(myLabel);
    }

    /**
     * add background
     * @param filePath resource string
     */
    public static void addBackground(String filePath){
        Image background = new Image(filePath, ConstantData.SIZE_BACKGROUND[0], ConstantData.SIZE_BACKGROUND[1], false, false);
        ImageView imageView = new ImageView();
        imageView.setImage(background);
        gamePane.getChildren().add(imageView);

    }

    /**
     * add ending actor
     * @param layoutX layout position X
     * @param layoutY layout position Y
     */
    public static void addEnd(int layoutX, int layoutY){
        gamePane.add(new End(layoutX, layoutY));
    }
    /**
     * add short log actor
     * @param layoutX layout position X
     * @param layoutY layout position Y
     * @param speed speed
     */
    public static void addShortLog(int layoutX, int layoutY, double speed){
        gamePane.add(new Log(ConstantData.IMAGE_ACTOR_SHORT_LOG, ConstantData.SIZE_SHORT_LOG, layoutX, layoutY, speed));
    }
    /**
     * add medium log actor
     * @param layoutX layout position X
     * @param layoutY layout position Y
     * @param speed speed
     */
    public static void addMediumLog(int layoutX, int layoutY, double speed){
        gamePane.add(new Log(ConstantData.IMAGE_ACTOR_MEDIUM_LOG, ConstantData.SIZE_MEDIUM_LOG, layoutX, layoutY, speed));
    }
    /**
     * add long log actor
     * @param layoutX layout position X
     * @param layoutY layout position Y
     * @param speed speed
     */
    public static void addLongLog(int layoutX, int layoutY, double speed){
        gamePane.add(new Log(ConstantData.IMAGE_ACTOR_LONG_LOG, ConstantData.SIZE_LONG_LOG, layoutX, layoutY, speed));
    }
    /**
     * add turtle actor
     * @param layoutX layout position X
     * @param layoutY layout position Y
     * @param speed speed
     */
    public static void addTurtle(int layoutX, int layoutY, int speed){
        gamePane.add(new Turtle(layoutX, layoutY, speed, ConstantData.SIZE_TURTLE, ConstantData.SIZE_TURTLE));
    }
    /**
     * add wet turtle actor
     * @param layoutX layout position X
     * @param layoutY layout position Y
     * @param speed speed
     */
    public static void addWetTurtle(int layoutX, int layoutY, int speed){
        gamePane.add(new WetTurtle(layoutX, layoutY, speed, ConstantData.SIZE_TURTLE, ConstantData.SIZE_TURTLE));
    }
    /**
     * add short truck actor
     * @param layoutX layout position X
     * @param layoutY layout position Y
     * @param speed speed
     */
    public static void addShortTruck(int layoutX, int layoutY, int speed){
        if (speed > 0){
            gamePane.add(new Obstacle(ConstantData.IMAGE_ACTOR_SHORT_TRUCK_RIGHT, layoutX, layoutY, speed, ConstantData.SIZE_SHORT_TRUCK, ConstantData.SIZE_SHORT_TRUCK));
        } else {
            gamePane.add(new Obstacle(ConstantData.IMAGE_ACTOR_SHORT_TRUCK_LEFT, layoutX, layoutY, speed, ConstantData.SIZE_SHORT_TRUCK, ConstantData.SIZE_SHORT_TRUCK));
        }
    }
    /**
     * add long truck actor
     * @param layoutX layout position X
     * @param layoutY layout position Y
     * @param speed speed
     */
    public static void addLongTruck(int layoutX, int layoutY, int speed){
        if (speed > 0){
            gamePane.add(new Obstacle(ConstantData.IMAGE_ACTOR_LONG_TRUCK_RIGHT, layoutX, layoutY, speed, ConstantData.SIZE_LONG_TRUCK, ConstantData.SIZE_LONG_TRUCK));
        } else {
            gamePane.add(new Obstacle(ConstantData.IMAGE_ACTOR_LONG_TRUCK_LEFT, layoutX, layoutY, speed, ConstantData.SIZE_LONG_TRUCK, ConstantData.SIZE_LONG_TRUCK));
        }
    }
    /**
     * add car actor
     * @param layoutX layout position X
     * @param layoutY layout position Y
     * @param speed speed
     */
    public static void addCar(int layoutX, int layoutY, int speed){
        if (speed > 0){
            gamePane.add(new Obstacle(ConstantData.IMAGE_ACTOR_CAR_A_RIGHT, layoutX, layoutY, speed, ConstantData.SIZE_CAR, ConstantData.SIZE_CAR));
        } else {
            gamePane.add(new Obstacle(ConstantData.IMAGE_ACTOR_CAR_A_LEFT, layoutX, layoutY, speed, ConstantData.SIZE_CAR, ConstantData.SIZE_CAR));
        }
    }

}
