package com.tsb.frogger.core;

import com.tsb.frogger.actors.*;
import com.tsb.frogger.controller.ControlledScreen;
import com.tsb.frogger.controller.ScreensController;
import com.tsb.frogger.world.MyStage;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import java.io.IOException;


/**
 * game class to generate different difficulty of game map
 */
public class Game implements ControlledScreen {

    /**
     * main screen controller
     */
    ScreensController myController;
    /**
     * game parent node
     */
    public MyStage gamePane;
    /**
     * frogger
     */
    private Animal animal;
//    private GodAnimal animal;
    /**
     * frogger animation timer
     */
    private AnimationTimer timer;
    /**
     * level
     */
    private int level;
    /**
     * current max level
     */
    public static final int MAX_LEVEL = 5;

    /**
     * constructor
     */
    public Game(){
        setLevel(1);
        gamePane = createPane();
    }

    /**
     * constructor
     * @param level initial level
     */
    public Game(int level){
        setLevel(level);
        gamePane = createPane();
    }

    /**
     * actual method of creating game map
     * @return MyStage an object Pane that contains all information of the game map
     */
    public MyStage createPane(){

        // layout
        gamePane = new MyStage();

        // background image
        BackgroundImage gameBackground = new BackgroundImage(ConstantData.IMAGE_GAME_BACKGROUND_A);
        gamePane.add(gameBackground);

        switch(level){
            case 5:
            case 4:
            case 3:
            case 2:
            default:
                // add actors
                gamePane.add(new Log(ConstantData.IMAGE_GAME_SHORT_LOG, 150, 0, 166, 0.75));
                gamePane.add(new Log(ConstantData.IMAGE_GAME_SHORT_LOG, 150, 220, 166, 0.75));
                gamePane.add(new Log(ConstantData.IMAGE_GAME_SHORT_LOG, 150, 440, 166, 0.75));

                gamePane.add(new Log(ConstantData.IMAGE_GAME_LONG_LOG, 300, 0, 276, -2));
                gamePane.add(new Log(ConstantData.IMAGE_GAME_LONG_LOG, 300, 400, 276, -2));

                gamePane.add(new Log(ConstantData.IMAGE_GAME_SHORT_LOG, 150, 50, 329, 0.75));
                gamePane.add(new Log(ConstantData.IMAGE_GAME_SHORT_LOG, 150, 270, 329, 0.75));
                gamePane.add(new Log(ConstantData.IMAGE_GAME_SHORT_LOG, 150, 490, 329, 0.75));

                gamePane.add(new Turtle(500, 376, -1, 130, 130));
                gamePane.add(new Turtle(300, 376, -1, 130, 130));
                gamePane.add(new WetTurtle(700, 376, -1, 130, 130));
                gamePane.add(new WetTurtle(600, 217, -1, 130, 130));
                gamePane.add(new WetTurtle(400, 217, -1, 130, 130));
                gamePane.add(new WetTurtle(200, 217, -1, 130, 130));

                gamePane.add(new End(13,96));
                gamePane.add(new End(141,96));
                gamePane.add(new End(141 + 141-13,96));
                gamePane.add(new End(141 + 141-13+141-13+1,96));
                gamePane.add(new End(141 + 141-13+141-13+141-13+3,96));

                gamePane.add(new Obstacle(ConstantData.IMAGE_GAME_TRUCK_A_RIGHT, 0, 649, 1, 120, 120));
                gamePane.add(new Obstacle(ConstantData.IMAGE_GAME_TRUCK_A_RIGHT, 300, 649, 1, 120, 120));
                gamePane.add(new Obstacle(ConstantData.IMAGE_GAME_TRUCK_A_RIGHT, 600, 649, 1, 120, 120));

                gamePane.add(new Obstacle(ConstantData.IMAGE_GAME_CAR_A_LEFT, 100, 597, -1, 50, 50));
                gamePane.add(new Obstacle(ConstantData.IMAGE_GAME_CAR_A_LEFT, 250, 597, -1, 50, 50));
                gamePane.add(new Obstacle(ConstantData.IMAGE_GAME_CAR_A_LEFT, 400, 597, -1, 50, 50));
                gamePane.add(new Obstacle(ConstantData.IMAGE_GAME_CAR_A_LEFT, 550, 597, -1, 50, 50));
                gamePane.add(new Obstacle(ConstantData.IMAGE_GAME_CAR_A_LEFT, 500, 490, -5, 50, 50));

                gamePane.add(new Obstacle(ConstantData.IMAGE_GAME_TRUCK_B_RIGHT, 0, 540, 1, 200, 200));
                gamePane.add(new Obstacle(ConstantData.IMAGE_GAME_TRUCK_B_RIGHT, 500, 540, 1, 200, 200));

                // add scoreboard
                gamePane.add(new Digit(0, 30, 400, 25));

                // add frogger character
                animal = new Animal("file:src/main/resources/com/tsb/frogger/images/frogger/froggerUp.png");
                gamePane.add(animal);

                // add god frogger (uncomment to use god frogger)
//                animal = new GodAnimal("file:src/main/resources/com/tsb/frogger/images/frogger/froggerUp.png");
//                animal.instantWin(600);
//                gamePane.add(animal);

                // add home button
                HomeBtn homeBtn = new HomeBtn("file:src/main/resources/com/tsb/frogger/images/world/icon-house.png");
                gamePane.add(homeBtn);

                // add setting button
                SettingBtn settingBtn = new SettingBtn("file:src/main/resources/com/tsb/frogger/images/world/icon-gear.png");
                gamePane.add(settingBtn);

                //start obstacles movement
                gamePane.start();

        }



        return gamePane;
    }



    /**
     * creates animation timer for frogger character
     * check game winning state
     */
    public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (animal.changeScore()) {
                    setNumber(animal.getPoints());
                }
                if (animal.getStop()) {
                    try{
                        Game.this.stop();
                        Pane victoryPane = FXMLLoader.load(getClass().getResource("../view/Victory.fxml"));
                        gamePane.getChildren().add(victoryPane);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
    }

    /**
     * play background music, creates animation timer and starts animation timer
     */
    public void start() {
        System.out.println("starting game timer");
        gamePane.playMusic();
        createTimer();
        timer.start();
    }

    /**
     * stop background music, stop obstacles timer
     */
    public void stop() {
        System.out.println("stopping game timer");
        gamePane.stopMusic();
        gamePane.stop();
        timer.stop();
        animal.setNoMove(true);
    }

    /**
     * pause the game without exiting
     */
    public void pause(){
        System.out.println("Pause game timer");
        gamePane.stop();
        timer.stop();
        animal.setNoMove(true);
    }

    /**
     * resume from pause
     */
    public void resume(){
        System.out.println("resume game timer");
        gamePane.start();
        timer.start();
        animal.setNoMove(false);
    }

    /**
     * display scoreboard
     * @param n total score for the player
     */
    public void setNumber(int n) {
        int shift = 0;
        while (n > 0) {
            int d = n / 10;
            int k = n - d * 10;
            n = d;
            gamePane.add(new Digit(k, 30, 400 - shift, 25));
            shift+=30;
        }
    }

    /**
     * get level
     * @return level
     */
    public int getLevel() {
        return level;
    }

    /**
     * set level
     * @param level level
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * get scored points
     * @return score
     */
    public int getScore(){
        return animal.getPoints();
    }

    /**
     * set main screen controller
     * @param screenPage screen page
     */
    @Override
    public void setScreenParent(ScreensController screenPage) {
        myController = screenPage;
    }
}
