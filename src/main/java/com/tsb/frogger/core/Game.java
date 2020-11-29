package com.tsb.frogger.core;

import com.tsb.frogger.actors.*;
import com.tsb.frogger.controller.ControlledScreen;
import com.tsb.frogger.controller.ScreensController;
import com.tsb.frogger.exceptions.LevelNotFoundException;
import com.tsb.frogger.widgets.HomeBtn;
import com.tsb.frogger.widgets.SettingBtn;
import com.tsb.frogger.world.MyStage;
import javafx.animation.AnimationTimer;
import javafx.scene.control.Label;

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
     * scoreboard
     */
    private Label scoreDisplay;

    /**
     * constructor
     *
     * @param level initial level
     */
    public Game(int level) {
        setLevel(level);
    }

    public void load() throws LevelNotFoundException {

        gamePane = LoadComponents.load(level);

        scoreDisplay = new Label();
        scoreDisplay.setLayoutX(395);
        scoreDisplay.setLayoutY(30);
        scoreDisplay.getStyleClass().add("inGame-font");
        scoreDisplay.getStyleClass().add("bigger-font-size");
        scoreDisplay.setText("000");
        gamePane.getChildren().add(scoreDisplay);

        animal = new Animal(ConstantData.IMAGE_ACTOR_FROG_UP, ConstantData.LAYOUT_X_FROG[0], ConstantData.LAYOUT_Y_ACTOR[0][12]);
        gamePane.add(animal);

        //god frogger (uncomment to use god frogger)
//        animal = new GodAnimal(ConstantData.IMAGE_ACTOR_FROG_UP, ConstantData.LAYOUT_X_FROG[0], ConstantData.LAYOUT_Y_ACTOR[0][12]);
//        animal.instantWin(600);
//        gamePane.add(animal);

    }

    /**
     * creates animation timer for frogger character
     * check game winning state
     */
    public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (animal.updateScoreLabel()) {
                    setNumber(animal.getPoints());
                }
                if (animal.getStop()) {
                    Game.this.stop();
                    myController.loadMarkdown(ConstantData.OVERLAY_ID_VICTORY, ConstantData.FXML_VICTORY);
                    myController.addOverlay(ConstantData.OVERLAY_ID_VICTORY);
                }
            }
        };
    }

    /**
     * play background music, creates animation timer and starts animation timer
     */
    public void start() throws LevelNotFoundException {
        System.out.println("starting game timer");
        load();
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
    public void pause() {
        System.out.println("Pause game timer");
        gamePane.stop();
        timer.stop();
        animal.setNoMove(true);
    }

    /**
     * resume from pause
     */
    public void resume() {
        System.out.println("resume game timer");
        gamePane.start();
        timer.start();
        animal.setNoMove(false);
    }

    /**
     * display scoreboard
     *
     * @param n total score for the player
     */
    public void setNumber(int n) {
        int shift = 0;
//        while (n > 0) {
//            int d = n / 10;
//            int k = n - d * 10;
//            n = d;
//            gamePane.add(new Digit(k, 30, 400 - shift, 40));
//            shift += 30;
//        }
        String temp = "0".repeat(3 - String.valueOf(n).length()) + n;
        scoreDisplay.setText(temp);
    }

    /**
     * get level
     *
     * @return level
     */
    public int getLevel() {
        return level;
    }

    /**
     * set level
     *
     * @param level level
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * get scored points
     *
     * @return score
     */
    public int getScore() {
        return animal.getPoints();
    }

    public void setAnimal(Animal animal){
        this.animal = animal;
    }

    /**
     * set main screen controller
     *
     * @param screenPage screen page
     */
    @Override
    public void setScreenParent(ScreensController screenPage) {
        myController = screenPage;
        createUserControl();
    }

    private void createUserControl(){
        // add home button
        gamePane.add(new HomeBtn(ConstantData.IMAGE_ICON_HOME, myController));

        // add setting button
        gamePane.add(new SettingBtn(ConstantData.IMAGE_ICON_GEAR, myController));

    }
}
