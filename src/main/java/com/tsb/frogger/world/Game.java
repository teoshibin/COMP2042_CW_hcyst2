package com.tsb.frogger.world;

import com.tsb.frogger.controller.ControlledScreen;
import com.tsb.frogger.controller.ScreensController;
import com.tsb.frogger.core.ConstantData;
import com.tsb.frogger.utils.exceptions.LevelNotFoundException;
import com.tsb.frogger.utils.sound.Sound;
import com.tsb.frogger.world.actors.Animal;
import com.tsb.frogger.world.widgets.HomeBtn;
import com.tsb.frogger.world.widgets.SettingBtn;
import javafx.animation.AnimationTimer;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

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
     * progress bar denoting time remaining for extra score
     */
    private ProgressBar timeBar;
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

        scoreDisplay = LoadComponents.getScoreOutputLabel();
        gamePane.getChildren().add(scoreDisplay);

        timeBar = LoadComponents.getTimeBar();
        gamePane.getChildren().add(timeBar);

        animal = new Animal(ConstantData.IMAGE_ACTOR_FROG_UP, ConstantData.LAYOUT_X_FROG[0], ConstantData.LAYOUT_Y_ACTOR[0][12]);
        gamePane.add(animal);

        //god frogger (uncomment to use god frogger)
//        animal = new GodAnimal(ConstantData.IMAGE_ACTOR_FROG_UP, ConstantData.LAYOUT_X_FROG[0], ConstantData.LAYOUT_Y_ACTOR[0][12]);
//        animal.instantWin(800);
//        gamePane.add(animal);
        // TODO - ADD HEALTH FOR FROGGER
        // TODO - ADD TIME COUNT DOWN
    }

    /**
     * creates animation timer for win check
     * check game winning state
     */
    public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (animal.updateScoreLabel()) {
                    setNumber(animal.getScores());
                }
                if (animal.getWin()) {
                    Game.this.stop();
                    myController.loadMarkdown(ConstantData.OVERLAY_ID_VICTORY, ConstantData.FXML_VICTORY);
                    myController.addOverlay(ConstantData.OVERLAY_ID_VICTORY);
                    Sound.playAudioClip(ConstantData.SOUND_KACHING);
                }
            }
        };
    }

    /**
     * play background music, creates animation timer and starts animation timer
     */
    public void start() throws LevelNotFoundException {
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
        gamePane.stopMusic();
        gamePane.stop();
        timer.stop();
        animal.pause();
    }

    /**
     * pause the game without exiting
     */
    public void pause() {
        gamePane.stop();
        timer.stop();
        animal.pause();
    }

    /**
     * resume from pause
     */
    public void resume() {
        gamePane.start();
        timer.start();
        animal.resume();
    }

    /**
     * display scoreboard
     *
     * @param n total score for the player
     */
    public void setNumber(int n) {
        String temp = "0".repeat(3 - String.valueOf(n).length()) + n;
        scoreDisplay.setText(temp);
    }

    /**
     * set time bar remaining time
     *
     * @param remaining remaining time
     * @param total initial time
     */
    public void setTimeBar(int remaining, int total){
        timeBar.setProgress((double)remaining/total);
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
        return animal.getScores();
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
