package com.tsb.frogger.controller;

import com.tsb.frogger.core.ConstantData;
import com.tsb.frogger.core.RuntimeData;
import com.tsb.frogger.utils.data.datamanager.AssetsDao;
import com.tsb.frogger.utils.data.datamanager.AssetsDaoImpl;
import com.tsb.frogger.utils.exceptions.LevelNotFoundException;
import com.tsb.frogger.utils.sound.Sound;
import com.tsb.frogger.utils.game.ActorLoader;
import com.tsb.frogger.generation.world.MyStage;
import com.tsb.frogger.generation.actors.End;
import com.tsb.frogger.generation.actors.Frog;
import com.tsb.frogger.generation.widgets.*;
import javafx.animation.AnimationTimer;

/**
 * game class to generate different difficulty of game map
 */
public class GameController implements ControlledScreen {

    ScreensController myController;
    public MyStage gamePane;
    private int level;
    private AnimationTimer timer;
    private Frog frog;
    private ValueIndicator scoreIndicator;
    private TimeBar timeBar;
    private HealthBar healthBar;
    private HomeBtn homeBtn;
    private SettingBtn settingBtn;

    public GameController(int level) {
        this.level = level;
        load();
    }

    public void load(){
        AssetsDao ad = new AssetsDaoImpl();

        gamePane = new MyStage();

        GameBackground gbg = new GameBackground(ad.getExternal("image.background.world"));
        gamePane.getChildren().add(gbg);

        scoreIndicator = new ValueIndicator(395, 5, "SCORE", 0, 3);
        gamePane.getChildren().add(scoreIndicator);

        ValueIndicator levelIndicator = new ValueIndicator(75, 5,"LEVEL", level, 3);
        gamePane.getChildren().add(levelIndicator);

        timeBar = new TimeBar(
                ad.getExternal("image.icon.clock"), 155,40,
                30, 195, 23, true
        );
        gamePane.getChildren().add(timeBar);

        homeBtn = new HomeBtn(ad.getExternal("image.icon.house"));
        gamePane.getChildren().add(homeBtn);

        settingBtn = new SettingBtn(ad.getExternal("image.icon.gear"));
        gamePane.getChildren().add(settingBtn);

        for (int i = 0; i < 5; i++) {
            gamePane.getChildren().add(
                    new End(ConstantData.LAYOUT_X_END[0][i], ConstantData.LAYOUT_Y_ACTOR[0][0])
            );
        }

        ActorLoader actorLoader = new ActorLoader(gamePane, level);
        try {
            gamePane = actorLoader.loadActors();
        } catch (LevelNotFoundException e) {
            e.printStackTrace();
        }

        frog = new Frog(Frog.DIRECTION.UP, ConstantData.LAYOUT_X_FROG[0],
                ConstantData.LAYOUT_Y_ACTOR[0][12], 10);
        gamePane.add(frog);

        healthBar = new HealthBar(ad.getExternal("image.icon.heart"), 160, 8, frog.getHealth(), 5);
        gamePane.getChildren().add(healthBar);
    }

    public void createTimer() {
        AssetsDao ad = new AssetsDaoImpl();
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                timeBar.getProgressBar().setProgress(frog.getProgress());
                if (frog.updateScoreLabel()) {
                    scoreIndicator.updateValue(frog.getScores());
                    healthBar.updateHealth(frog.getHealth());
                }
                if (frog.getWin() || frog.getLose()) {
                    GameController.this.stop();
                    myController.loadMarkdown(ConstantData.OVERLAY_ID_VICTORY, ad.getName("fxml.victory"));
                    myController.addOverlay(ConstantData.OVERLAY_ID_VICTORY);
                    Sound.playAudioClip(ad.getExternal("sound.clip.ui.kaChing"));
                }
            }
        };
    }

    /**
     * start the game
     * load required components and start all timers
     */
    public void start() {
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

    private void setEventHandler(){
        AssetsDao ad = new AssetsDaoImpl();

        homeBtn.setOnMouseClicked(event -> {
            RuntimeData.gameController.stop();
            RuntimeData.gameController = null;
            myController.setScreen(ConstantData.SCREEN_ID_MENU);
            Sound.playMediaPlayer(ad.getExternal("sound.music.arcade"));
        });
        homeBtn.setOnMouseEntered(event -> Sound.playAudioClip(ad.getExternal("sound.clip.ui.button")));

        settingBtn.setOnMouseClicked(event -> {
            myController.addOverlay(ConstantData.OVERLAY_ID_OPTION);
            RuntimeData.gameController.pause();
        });

        settingBtn.setOnMouseEntered(event -> {
            Sound.playAudioClip(ad.getExternal("sound.clip.ui.button"));
        });
    }

    /**
     * set main screen controller
     *
     * @param screenPage screen page
     */
    @Override
    public void setScreenParent(ScreensController screenPage) {
        myController = screenPage;
        setEventHandler();
    }
}
