package com.tsb.frogger.core;

import com.tsb.frogger.actors.*;
import com.tsb.frogger.controller.ControlledScreen;
import com.tsb.frogger.controller.ScreensController;
import com.tsb.frogger.world.MyStage;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
     * @param level initial level
     */
    public Game(int level){
        setLevel(level);
        gamePane = new MyStage();
        createPane();
    }

    /**
     * actual method of creating game map
     * @return MyStage an object Pane that contains all information of the game map
     */
    public MyStage createPane(){

        // background image
//        BackgroundImage gameBackground = new BackgroundImage(ConstantData.IMAGE_GAME_BACKGROUND_A);
//        gamePane.add(gameBackground);
        Image background = new Image(ConstantData.IMAGE_GAME_BACKGROUND_A, 540, 720, false,false);
        ImageView imageView = new ImageView();
        imageView.setImage(background);
        gamePane.getChildren().add(imageView);

        switch(level){
            case 5:
            case 4:
            case 3:
            case 2:
            default:
                // add actors
                gamePane.add(new Log(ConstantData.IMAGE_ACTOR_SHORT_LOG, ConstantData.SIZE_SHORT_LOG, 0, ConstantData.LAYOUT_Y_ACTOR[0][1], 0.75));
                gamePane.add(new Log(ConstantData.IMAGE_ACTOR_SHORT_LOG, ConstantData.SIZE_SHORT_LOG, 198, ConstantData.LAYOUT_Y_ACTOR[0][1], 0.75));
                gamePane.add(new Log(ConstantData.IMAGE_ACTOR_SHORT_LOG, ConstantData.SIZE_SHORT_LOG, 396, ConstantData.LAYOUT_Y_ACTOR[0][1], 0.75));

                gamePane.add(new Log(ConstantData.IMAGE_ACTOR_LONG_LOG, ConstantData.SIZE_LONG_LOG, 0, ConstantData.LAYOUT_Y_ACTOR[0][3], -2));
                gamePane.add(new Log(ConstantData.IMAGE_ACTOR_LONG_LOG, ConstantData.SIZE_LONG_LOG, 360, ConstantData.LAYOUT_Y_ACTOR[0][3], -2));

                gamePane.add(new Log(ConstantData.IMAGE_ACTOR_SHORT_LOG, ConstantData.SIZE_SHORT_LOG, 45, ConstantData.LAYOUT_Y_ACTOR[0][4], 0.75));
                gamePane.add(new Log(ConstantData.IMAGE_ACTOR_SHORT_LOG, ConstantData.SIZE_SHORT_LOG, 240, ConstantData.LAYOUT_Y_ACTOR[0][4], 0.75));
                gamePane.add(new Log(ConstantData.IMAGE_ACTOR_SHORT_LOG, ConstantData.SIZE_SHORT_LOG, 440, ConstantData.LAYOUT_Y_ACTOR[0][4], 0.75));

                gamePane.add(new Turtle(100, ConstantData.LAYOUT_Y_ACTOR[0][2], -1, ConstantData.SIZE_TURTLE, ConstantData.SIZE_TURTLE));
                gamePane.add(new Turtle(150, ConstantData.LAYOUT_Y_ACTOR[0][5], -1, ConstantData.SIZE_TURTLE, ConstantData.SIZE_TURTLE));
                gamePane.add(new WetTurtle(500, ConstantData.LAYOUT_Y_ACTOR[0][2], -1, ConstantData.SIZE_TURTLE, ConstantData.SIZE_TURTLE));
                gamePane.add(new WetTurtle(350, ConstantData.LAYOUT_Y_ACTOR[0][5], -1, ConstantData.SIZE_TURTLE, ConstantData.SIZE_TURTLE));
                gamePane.add(new WetTurtle(500, ConstantData.LAYOUT_Y_ACTOR[0][5], -1, ConstantData.SIZE_TURTLE, ConstantData.SIZE_TURTLE));
                gamePane.add(new WetTurtle(300, ConstantData.LAYOUT_Y_ACTOR[0][2], -1, ConstantData.SIZE_TURTLE, ConstantData.SIZE_TURTLE));

                gamePane.add(new End(ConstantData.LAYOUT_X_END[0][0], ConstantData.LAYOUT_Y_ACTOR[0][0]));
                gamePane.add(new End(ConstantData.LAYOUT_X_END[0][1],ConstantData.LAYOUT_Y_ACTOR[0][0]));
                gamePane.add(new End(ConstantData.LAYOUT_X_END[0][2],ConstantData.LAYOUT_Y_ACTOR[0][0]));
                gamePane.add(new End(ConstantData.LAYOUT_X_END[0][3],ConstantData.LAYOUT_Y_ACTOR[0][0]));
                gamePane.add(new End(ConstantData.LAYOUT_X_END[0][4],ConstantData.LAYOUT_Y_ACTOR[0][0]));

                gamePane.add(new Obstacle(ConstantData.IMAGE_ACTOR_SHORT_TRUCK_RIGHT, 0, ConstantData.LAYOUT_Y_ACTOR[0][10], 1, ConstantData.SIZE_SHORT_TRUCK, ConstantData.SIZE_SHORT_TRUCK));
                gamePane.add(new Obstacle(ConstantData.IMAGE_ACTOR_SHORT_TRUCK_RIGHT, 300, ConstantData.LAYOUT_Y_ACTOR[0][10], 1, ConstantData.SIZE_SHORT_TRUCK, ConstantData.SIZE_SHORT_TRUCK));
                gamePane.add(new Obstacle(ConstantData.IMAGE_ACTOR_SHORT_TRUCK_RIGHT, 500, ConstantData.LAYOUT_Y_ACTOR[0][10], 1, ConstantData.SIZE_SHORT_TRUCK, ConstantData.SIZE_SHORT_TRUCK));

                gamePane.add(new Obstacle(ConstantData.IMAGE_ACTOR_CAR_A_LEFT, 100, ConstantData.LAYOUT_Y_ACTOR[0][9], -1, ConstantData.SIZE_CAR, ConstantData.SIZE_CAR));
                gamePane.add(new Obstacle(ConstantData.IMAGE_ACTOR_CAR_A_LEFT, 250, ConstantData.LAYOUT_Y_ACTOR[0][9], -1, ConstantData.SIZE_CAR, ConstantData.SIZE_CAR));
                gamePane.add(new Obstacle(ConstantData.IMAGE_ACTOR_CAR_A_LEFT, 400, ConstantData.LAYOUT_Y_ACTOR[0][9], -1, ConstantData.SIZE_CAR, ConstantData.SIZE_CAR));
                gamePane.add(new Obstacle(ConstantData.IMAGE_ACTOR_CAR_A_LEFT, 200, ConstantData.LAYOUT_Y_ACTOR[0][7], -5, ConstantData.SIZE_CAR, ConstantData.SIZE_CAR));
                gamePane.add(new Obstacle(ConstantData.IMAGE_ACTOR_CAR_A_LEFT, 300, ConstantData.LAYOUT_Y_ACTOR[0][7], -5, ConstantData.SIZE_CAR, ConstantData.SIZE_CAR));

                gamePane.add(new Obstacle(ConstantData.IMAGE_ACTOR_LONG_TRUCK_RIGHT, 0, ConstantData.LAYOUT_Y_ACTOR[0][8], 1, ConstantData.SIZE_LONG_TRUCK, ConstantData.SIZE_LONG_TRUCK));
                gamePane.add(new Obstacle(ConstantData.IMAGE_ACTOR_LONG_TRUCK_RIGHT, 500, ConstantData.LAYOUT_Y_ACTOR[0][8], 1, ConstantData.SIZE_LONG_TRUCK, ConstantData.SIZE_LONG_TRUCK));

                gamePane.add(new Obstacle(ConstantData.IMAGE_ACTOR_CAR_A_RIGHT, 100, ConstantData.LAYOUT_Y_ACTOR[0][11], 1, ConstantData.SIZE_CAR, ConstantData.SIZE_CAR));
                gamePane.add(new Obstacle(ConstantData.IMAGE_ACTOR_CAR_A_RIGHT, 250, ConstantData.LAYOUT_Y_ACTOR[0][11], 1, ConstantData.SIZE_CAR, ConstantData.SIZE_CAR));
                gamePane.add(new Obstacle(ConstantData.IMAGE_ACTOR_CAR_A_RIGHT, 400, ConstantData.LAYOUT_Y_ACTOR[0][11], 1, ConstantData.SIZE_CAR, ConstantData.SIZE_CAR));

                // add scoreboard
                gamePane.add(new Digit(0, 30, 400, 25));

                // add frogger character
                animal = new Animal(ConstantData.IMAGE_ACTOR_FROG_UP, ConstantData.LAYOUT_X_FROG[0], ConstantData.LAYOUT_Y_ACTOR[0][12]);
                gamePane.add(animal);

                // add god frogger (uncomment to use god frogger)
//                animal = new GodAnimal(ConstantData.IMAGE_ACTOR_FROG_UP, ConstantData.LAYOUT_X_FROG[0], ConstantData.LAYOUT_Y_ACTOR[0][12]);
//                animal.instantWin(600);
//                gamePane.add(animal);

        }
        return gamePane;
    }

    private void createUI(){
        // add home button
        HomeBtn homeBtn = new HomeBtn(ConstantData.IMAGE_ICON_HOME, myController);
        gamePane.add(homeBtn);

        // add setting button
        SettingBtn settingBtn = new SettingBtn(ConstantData.IMAGE_ICON_GEAR, myController);
        gamePane.add(settingBtn);
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
                    Game.this.stop();
                    myController.loadMarkdown(ConstantData.OVERLAY_VICTORY, ConstantData.FXML_VICTORY);
                    myController.addOverlay(ConstantData.OVERLAY_VICTORY);
                }
            }
        };
    }

    /**
     * play background music, creates animation timer and starts animation timer
     */
    public void start() {
        System.out.println("starting game timer");
        gamePane.start();
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
        createUI();
    }
}
