package com.tsb.frogger.world;

import com.tsb.frogger.core.ConstantData;
import com.tsb.frogger.world.actors.*;
import com.tsb.frogger.utils.exceptions.LevelNotFoundException;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Rotate;

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
        addLabels(level);

        // set ending points
        for (int i = 0; i < 5; i++) {
            addEnd(ConstantData.LAYOUT_X_END[0][i], ConstantData.LAYOUT_Y_ACTOR[0][0]);
        }

        // load obstacle based on levels
        LevelSelector.selectLevel(level);

        return gamePane;
    }

    /**
     * add scoreboard
     */
    public static void addLabels(int level){
        // add score label
        Label scoreLabel = new Label();
        scoreLabel.setLayoutX(395);
        scoreLabel.setLayoutY(5);
        scoreLabel.setText("SCORE");
        scoreLabel.getStyleClass().add("main-font");
        scoreLabel.getStyleClass().add("font-weight-bold");
        gamePane.getChildren().add(scoreLabel);

        // add level label
        Label levelLabel = new Label();
        levelLabel.setLayoutX(75);
        levelLabel.setLayoutY(5);
        levelLabel.setText("Level");
        levelLabel.getStyleClass().add("main-font");
        levelLabel.getStyleClass().add("font-weight-bold");
        gamePane.getChildren().add(levelLabel);

        // add level value
        Label valueLabel = new Label();
        valueLabel.setLayoutX(70);
        valueLabel.setLayoutY(30);
        valueLabel.setText("0".repeat(3 - String.valueOf(level).length()) + level);
        valueLabel.getStyleClass().add("inGame-font");
        valueLabel.getStyleClass().add("bigger-font-size");
        gamePane.getChildren().add(valueLabel);

        ImageView alarmClock = new ImageView(
                new Image(LoadComponents.class.getResource(ConstantData.IMAGE_ICON_ALARM_CLOCK).toExternalForm(),
                        30, 30, true, true)
        );
        alarmClock.setLayoutX(350);
        alarmClock.setLayoutY(37);
        gamePane.getChildren().add(alarmClock);
    }

    static Label getScoreOutputLabel(){
        Label scoreOutputLabel = new Label();
        scoreOutputLabel.setLayoutX(400);
        scoreOutputLabel.setLayoutY(30);
        scoreOutputLabel.getStyleClass().add("inGame-font");
        scoreOutputLabel.getStyleClass().add("bigger-font-size");
        scoreOutputLabel.setText("000");
        return scoreOutputLabel;
    }

    static ProgressBar getTimeBar(){
        ProgressBar progressBar = new ProgressBar(1);
        progressBar.setLayoutX(150);
        progressBar.setLayoutY(44);
        progressBar.setPrefSize(195, 20);
        progressBar.getStyleClass().add("orange-bar");
        Rotate rotate = new Rotate();
        rotate.setPivotX(progressBar.getPrefWidth()/2);
        rotate.setPivotY(progressBar.getPrefHeight()/2);
        rotate.setAngle(180);
        progressBar.getTransforms().add(rotate);
        return progressBar;
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
    public static void addTurtle(int layoutX, int layoutY, double speed){
        gamePane.add(new Turtle(layoutX, layoutY, speed, ConstantData.SIZE_TURTLE, ConstantData.SIZE_TURTLE));
    }
    /**
     * add wet turtle actor
     * @param layoutX layout position X
     * @param layoutY layout position Y
     * @param speed speed
     */
    public static void addWetTurtle(int layoutX, int layoutY, double speed){
        gamePane.add(new WetTurtle(layoutX, layoutY, speed, ConstantData.SIZE_TURTLE, ConstantData.SIZE_TURTLE));
    }
    /**
     * add short truck actor
     * @param layoutX layout position X
     * @param layoutY layout position Y
     * @param speed speed
     */
    public static void addShortTruck(int layoutX, int layoutY, double speed){
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
    public static void addLongTruck(int layoutX, int layoutY, double speed){
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
    public static void addCar(int layoutX, int layoutY, double speed){
        if (speed > 0){
            gamePane.add(new Obstacle(ConstantData.IMAGE_ACTOR_CAR_A_RIGHT, layoutX, layoutY, speed, ConstantData.SIZE_CAR, ConstantData.SIZE_CAR));
        } else {
            gamePane.add(new Obstacle(ConstantData.IMAGE_ACTOR_CAR_A_LEFT, layoutX, layoutY, speed, ConstantData.SIZE_CAR, ConstantData.SIZE_CAR));
        }
    }

}
