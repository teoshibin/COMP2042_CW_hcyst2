package com.tsb.frogger.world;

import com.tsb.frogger.controller.ControlledScreen;
import com.tsb.frogger.controller.ScreensController;
import com.tsb.frogger.core.ConstantData;
import com.tsb.frogger.utils.data.datamanager.PropertiesDao;
import com.tsb.frogger.utils.data.datamanager.PropertiesDaoImpl;
import com.tsb.frogger.utils.exceptions.LevelNotFoundException;
import com.tsb.frogger.utils.sound.Sound;
import com.tsb.frogger.world.actors.Frog;
import com.tsb.frogger.world.widgets.HealthBar;
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
    private Frog frog;
//    private GodFrog frog;
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

    private HealthBar healthBar;
    /**
     * constructor
     *
     * @param level initial level
     */
    public Game(int level) {
        setLevel(level);
    }

    public void load() throws LevelNotFoundException {
        PropertiesDao pd = new PropertiesDaoImpl();

        gamePane = LoadComponents.load(level);

        scoreDisplay = LoadComponents.getScoreOutputLabel();
        gamePane.getChildren().add(scoreDisplay);

        timeBar = LoadComponents.getTimeBar();
        gamePane.getChildren().add(timeBar);

        frog = new Frog(
                Frog.DIRECTION.UP,
                ConstantData.LAYOUT_X_FROG[0],
                ConstantData.LAYOUT_Y_ACTOR[0][12],
                10
        );
        gamePane.add(frog);

        //TODO move this to load component
        healthBar = new HealthBar(pd.getExternal("image.icon.heart"), 160, 8, frog.getHealth(), 5);
        healthBar.addStyleClass("main-font");
        healthBar.addStyleClass("font-weight-bold");
        gamePane.getChildren().add(healthBar);

        //god frogger (uncomment to use god frogger)
//        frog = new GodFrog(pd.getExternal("image.actor.frog.up"), ConstantData.LAYOUT_X_FROG[0], ConstantData.LAYOUT_Y_ACTOR[0][12]);
//        frog.instantWin(800);
//        gamePane.add(frog);
    }

    /**
     * creates animation timer for win check
     * check game winning state
     */
    public void createTimer() {
        PropertiesDao pd = new PropertiesDaoImpl();
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (frog.updateScoreLabel()) {
                    setNumber(frog.getScores());
                    healthBar.updateHealth(frog.getHealth());
                }
                if (frog.getWin() || frog.getLose()) {
                    Game.this.stop();
                    myController.loadMarkdown(ConstantData.OVERLAY_ID_VICTORY, pd.getName("fxml.victory"));
                    myController.addOverlay(ConstantData.OVERLAY_ID_VICTORY);
                    Sound.playAudioClip(pd.getExternal("sound.clip.ui.kaChing"));
                }
            }
        };
    }

    /**
     * start the game
     * load required components and start all timers
     */
    public void start() throws LevelNotFoundException {
        load();
        createTimer();
        timer.start();
        gamePane.start();
    }

    /**
     * completely stop the game
     */
    public void stop() {
        timer.stop();
        gamePane.stop();
    }

    /**
     * pause the game
     */
    public void pause() {
        timer.stop();
        gamePane.pause();
    }

    /**
     * resume from pause
     */
    public void resume() {
        timer.start();
        gamePane.start();
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
        return frog.getScores();
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
        PropertiesDao pd = new PropertiesDaoImpl();
        // add home button
        gamePane.add(new HomeBtn(pd.getExternal("image.icon.house"), myController));

        // add setting button
        gamePane.add(new SettingBtn(pd.getExternal("image.icon.gear"), myController));

    }
}
